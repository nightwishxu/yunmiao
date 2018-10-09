package com.api.wxaction;

import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.base.util.JSONUtils;
import com.item.dao.model.*;
import com.item.daoEx.model.CommentEx;
import com.item.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value="/api/article", produces = {"application/json;charset=UTF-8"})
@Api(tags = "动态相关")
public class ApiArticleController extends ApiBaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private UserPraiseService userPraiseService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserReportService userReportService;

    @Autowired
    private UserFollowService userFollowService;

    @Autowired
    private CollectPraiseService collectPraiseService;

    @Autowired
    private WxUserInfoService wxUserInfoService;

    @Autowired
    private UserBlackService userBlackService;

    @ApiOperation(value = "新增动态", notes = "")
    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Integer add(MobileInfo mobileInfo,
                       @ApiParam(value = "内容", required = true)String content,
                       @ApiParam(value = "图片", required = false)String imgs,
                       @ApiParam(value = "标签信息", required = true)String labels,
                       @ApiParam(value = "状态：1草稿2发布", required = true)Integer status){
        Article article=new Article();
        article.setUserId(mobileInfo.getUserid());
        article.setStatus(status);
        article.setCollectCount(0);
        article.setCommentCount(0);
        article.setContent(content);
        article.setImgs(imgs);
        article.setLabels(labels);
        article.setCreateTime(new Date());
        article.setCreateName(String.valueOf(mobileInfo.getUserid()));
        int num=articleService.insert(article);
        wxUserInfoService.updateArticleCount(mobileInfo.getUserid());
        return num;
    }

    @ApiOperation(value = "编辑动态", notes = "")
    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Integer edit(MobileInfo mobileInfo,
                        @ApiParam(value = "内容", required = false)String content,
                        @ApiParam(value = "图片", required = false)String imgs,
                        @ApiParam(value = "标签信息", required = false)String labels,
                        @ApiParam(value = "状态：1草稿2发布", required = true)Integer status,
                        @ApiParam(value = "动态id", required = true)Integer id){
        ArticleExample example=new ArticleExample();
        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
        Article article=articleService.selectByPrimaryKey(id);
        article.setContent(content);
        article.setImgs(imgs);
        article.setLabels(labels);
        article.setStatus(status);
        article.setUpdateTime(new Date());
        wxUserInfoService.updateArticleCount(mobileInfo.getUserid());
        return articleService.updateByPrimaryKeySelective(article);
    }

    @ApiOperation(value = "收藏动态", notes = "")
    @RequestMapping(value = "/collect",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Integer collect(MobileInfo mobileInfo,
                        @ApiParam(value = "0取消收藏，1收藏",required = true) Integer type,
                        @ApiParam(value = "用户头像",required = true) String headImg,
                        @ApiParam(value = "昵称",required = true) String nickName,
                        @ApiParam(value = "动态图片",required = false) String img,
                           @ApiParam(value = "动态作者id",required = true) Integer authorId,
                        @ApiParam(value = "动态id", required = true)Integer id){
        Integer num=0;
        if (type==0){
            num=-1;
            CollectPraiseExample example=new CollectPraiseExample();
            example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andArticleIdEqualTo(id).andTypeEqualTo(1);
            collectPraiseService.deleteByExample(example);
        }else if (type==1){
            if (userBlackService.isBlackUser(mobileInfo.getUserid(),authorId)>0){
                throw new ApiException("已被拉黑无法收藏动态");
            }
            num=1;
            CollectPraise entity=new CollectPraise();
            entity.setArticleId(id);
            entity.setUserId(mobileInfo.getUserid());
            entity.setCreateTime(new Date());
            entity.setType(1);
            entity.setHeadImg(headImg);
            entity.setNickName(nickName);
            entity.setImg(img);
            entity.setAuthorId(authorId);
            collectPraiseService.insert(entity);
        }else {
            throw new ApiException("非法参数");
        }
        return articleService.updateArticleCount(id,num,1);
    }

    @ApiOperation(value = "点赞动态", notes = "")
    @RequestMapping(value = "/praise",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Integer praise(MobileInfo mobileInfo,
                           @ApiParam(value = "0取消点赞，1点赞",required = true) Integer type,
                          @ApiParam(value = "用户头像",required = true) String headImg,
                          @ApiParam(value = "昵称",required = true) String nickName,
                          @ApiParam(value = "动态图片",required = false) String img,
                          @ApiParam(value = "动态作者id",required = true) Integer authorId,
                           @ApiParam(value = "动态id", required = true)Integer id){
        Integer num=0;
        if (type==0){
            num=-1;
            CollectPraiseExample example=new CollectPraiseExample();
            example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andArticleIdEqualTo(id).andTypeEqualTo(0);
            collectPraiseService.deleteByExample(example);
        }else if (type==1){
            num=1;
            CollectPraise entity=new CollectPraise();
            entity.setArticleId(id);
            entity.setUserId(mobileInfo.getUserid());
            entity.setCreateTime(new Date());
            entity.setType(1);
            entity.setHeadImg(headImg);
            entity.setNickName(nickName);
            entity.setImg(img);
            entity.setAuthorId(authorId);
            collectPraiseService.insert(entity);
        }else {
            throw new ApiException("非法参数");
        }
        return articleService.updateArticleCount(id,num,2);
    }





    @ApiOperation(value = "动态评价列表", notes = "分页")
    @RequestMapping(value = "/comment/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = false)
    public List<CommentEx> commentList(@ApiParam(value = "动态id", required = true)Integer id){

        return commentService.findList(id);
    }


    @ApiOperation(value = "动态明细", notes = "")
    @RequestMapping(value = "/get",method = {RequestMethod.POST})
    @ApiMethod(isLogin = false)
    public Article detail(@ApiParam(value = "动态id", required = true)Integer id){
       return articleService.selectByPrimaryKey(id);
    }


    @ApiOperation(value = "举报动态", notes = "")
    @RequestMapping(value = "/report",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Object report(MobileInfo mobileInfo,@ApiParam(value = "动态id", required = true)Integer articleId,
    @ApiParam(value = "举报信息", required = true)String info,
    @ApiParam(value = "图片", required = true)String imgs,
    @ApiParam(value = "昵称", required = true)String nickName
    ){
        UserReport report=new UserReport();
        report.setArticleId(articleId);
        report.setNickName(nickName);
        report.setCreateTime(new Date());
        report.setImgs(imgs);
        report.setStatus(1);
        report.setUserId(mobileInfo.getUserid());
        return userReportService.insert(report);
    }




    @ApiOperation(value = "关注用户的动态列表", notes = "登陆，分页")
    @RequestMapping(value = "/follow/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Object followArticle(MobileInfo mobileInfo){
       UserFollowExample example=new UserFollowExample();
       List<Integer> status=new ArrayList<>();
       status.add(1);
       status.add(3);
        List<Integer> status1=new ArrayList<>();
        status1.add(2);
        status1.add(3);
       example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andStatusIn(status);
       example.or().andOperateObjectEqualTo(mobileInfo.getUserid()).andStatusIn(status1);
       //关注或互相关注的用户
       List<UserFollow> follows=userFollowService.selectByExample(example);
       if (follows!=null && follows.size()>0){
           List<Integer> list=new ArrayList<>();
           for (UserFollow follow:follows){
               if (mobileInfo.getUserid()==follow.getUserId()){
                   list.add(follow.getOperateObject());
               }else {
                   list.add(follow.getUserId());
               }
           }
           ArticleExample articleExample=new ArticleExample();
           articleExample.setOrderByClause("create_time desc");
           articleExample.createCriteria().andUserIdIn(list);
           return articleService.selectByExample(articleExample);
       }

       return null;
    }


    @ApiOperation(value = "动态推荐列表", notes = "分页")
    @RequestMapping(value = "/recommend/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = false)
    public Object recommendArticle(){
        ArticleExample example=new ArticleExample();
        example.setOrderByClause("create_time desc");
        List<Article> articles=articleService.selectByExample(example);
        return articles;
    }


    @ApiOperation(value = "动态查询列表", notes = "分页")
    @RequestMapping(value = "/search/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = false)
    public Object search( @ApiParam(value = "查询内容", required = true)String label){
        if (StringUtils.isBlank(label)){
            throw new ApiException("查询内容不能为空！");
        }
        ArticleExample example=new ArticleExample();
        example.createCriteria().andLabelsLike(label);
        example.setOrderByClause("create_time desc");
        List<Article> articles=articleService.selectByExample(example);
        return articles;
    }


    @ApiOperation(value = "我的动态", notes = "分页")
    @RequestMapping(value = "/search/list",method = {RequestMethod.POST})
    @ApiMethod(isLogin = true)
    public Object myArticle( MobileInfo mobileInfo,@ApiParam(value = "1草稿2发布", required = true)Integer status){
        ArticleExample example=new ArticleExample();
        example.createCriteria().andStatusEqualTo(status).andUserIdEqualTo(mobileInfo.getUserid());
        example.setOrderByClause("create_time desc");
        List<Article> articles=articleService.selectByExample(example);
        return articles;
    }




}
