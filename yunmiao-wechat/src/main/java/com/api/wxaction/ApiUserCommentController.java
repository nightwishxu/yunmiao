package com.api.wxaction;

import com.api.view.userComment.AppUserComment;
import com.base.action.CoreController;
import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.base.service.SensitivWordsService;
import com.base.util.BeanUtils;
import com.item.dao.model.*;
import com.item.service.*;
import com.paidang.dao.model.Goods;
import com.paidang.dao.model.OrderExample;
import com.paidang.service.GoodsService;
import com.paidang.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.paidang.dao.model.Order;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api/comment", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
@Api(tags = "用户评价")
public class ApiUserCommentController extends ApiBaseController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentReplyService commentReplyService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SensitivWordsService sensitivWordsService;

    @Autowired
    private UserBlackService userBlackService;



    @ApiOperation(value = "新增评价", notes = "登陆")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object add(MobileInfo mobileInfo,
                      @ApiParam(value = "评论", required = true)String content,
                      @ApiParam(value = "头像", required =false)String headImg,
                      @ApiParam(value = "昵称", required = true)String nickName,
                      @ApiParam(value = "动态id", required = true)Integer articleId
                      ){

        Comment entity=new Comment();
        Article article=articleService.selectByPrimaryKey(articleId);
        if (article==null){
            throw new ApiException("动态不存在！");
        }
        if (userBlackService.isBlackUser(mobileInfo.getUserid(),article.getUserId())>0){
            throw new ApiException("已被拉黑无法评论动态");
        }

        //敏感词汇过滤
        entity.setContent(sensitivWordsService.relpSensitivWords(content));
        entity.setIsHot(0);
        entity.setUserId(mobileInfo.getUserid());
        entity.setLikeNum(0);
        entity.setIsReply(0);
        entity.setReplyNum(0);
        entity.setIsTop(0);
        entity.setHeadImg(headImg);
        entity.setNickName(nickName);
        entity.setArticleId(articleId);
        entity.setType(1);
        entity.setStatus(1);
        entity.setAuthorId(article.getUserId());
        entity.setCreateTime(new Date());
        if (article.getUserId()==mobileInfo.getUserid()){
            entity.setIsAuthor(2);
        }else {
            entity.setIsAuthor(0);
        }
        //更新评论数
        articleService.updateArticleCount(articleId,1,0);
        return commentService.insert(entity);
    }


    @ApiOperation(value = "回复评价", notes = "登陆")
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object reply(MobileInfo mobileInfo,
                      @ApiParam(value = "评论", required = true)String content,
                        @ApiParam(value = "动态id", required = true)Integer articleId,
                      @ApiParam(value = "头像", required = false)String headImg,
                      @ApiParam(value = "昵称", required = true)String nickName,
                      @ApiParam(value = "评论id", required = true)Integer commentId,
                      @ApiParam(value = "1为回复评论，2为回复别人的回复", required = true)Integer replyType,
                      @ApiParam(value = "replyType为2时传值，回复评论id", required = false)Integer replyId

    ){

        Article article=articleService.selectByPrimaryKey(articleId);
        if (article==null){
            throw new ApiException("动态不存在！");
        }
        if (userBlackService.isBlackUser(mobileInfo.getUserid(),article.getUserId())>0){
            throw new ApiException("已被拉黑无法评论动态");
        }
        CommentReply entity=new CommentReply();
        entity.setReplyType(replyType);
        Comment comment=commentService.selectByPrimaryKey(commentId);
        if (article.getUserId()==mobileInfo.getUserid()){
            entity.setIsAuthor(2);
        }else {
            entity.setIsAuthor(0);
        }
        //敏感词汇过滤
        entity.setContent(sensitivWordsService.relpSensitivWords(content));
        entity.setReplyId(commentId);
        if (replyType==2){
            if (replyId==null){
                throw new ApiException("缺少必要参数replyId");
            }
            entity.setReplyId(replyId);
            CommentReply reply=commentReplyService.selectByPrimaryKey(replyId);
            if (reply==null){
                throw new ApiException("回复对象不存在");
            }
            entity.setToUid(reply.getFromUid());
            entity.setToNickname(entity.getFromNickname());
        }else {
            entity.setReplyId(commentId);
            entity.setToUid(comment.getUserId());
            entity.setToNickname(comment.getNickName());
        }
        entity.setFromUid(mobileInfo.getUserid());
        entity.setFromNickname(nickName);
        entity.setFromThumbImg(headImg);
        entity.setCreateTime(new Date());
        commentService.updateReplyNum(commentId);
        //更新评论数
        articleService.updateArticleCount(articleId,1,0);
        return commentReplyService.insert(entity);

    }







}
