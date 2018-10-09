package com.api.wxaction;

import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.item.dao.model.*;
import com.item.service.UserBlackService;
import com.item.service.UserFollowService;
import com.item.service.UserMessageService;
import com.item.service.UserOptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user", produces = { "application/json;charset=UTF-8" })
@Api(tags = "用户操作")
public class ApiUserController extends ApiBaseController {

    @Autowired
    private UserFollowService userFollowService;

    @Autowired
    private UserBlackService userBlackService;

    @Autowired
    private UserMessageService userMessageService;

    @Autowired
    private UserOptionService userOptionService;




    @ApiOperation(value = "关注(取消关注)用户", notes = "登陆")
    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Integer userFollow(MobileInfo mobileInfo,
                              @ApiParam(value = "目标用户id", required = true)Integer followUserId,
                              @ApiParam(value = "操作类型0取消关注1关注", required = true)Integer type){
        //获取关注状态
//        Integer status = userFollowService.getFollowStatus(mobileInfo.getUserid(),followUserId);
        UserFollowExample example=new UserFollowExample();
        UserFollow follow=new UserFollow();
        if (type==0){
            //取消关注
            example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andFollowIdEqualTo(followUserId);
            return userFollowService.deleteByExample(example);
        }else if (type==1){
            if (userBlackService.isBlackUser(mobileInfo.getUserid(),followUserId)>0){
                throw new ApiException("已被拉黑无法关注");
            }

            follow.setUserId(mobileInfo.getUserid());
            follow.setFollowId(followUserId);
            follow.setCreateTime(new Date());
            return userFollowService.insert(follow);

        }else {
            throw new ApiException("参数非法");
        }
    }


    @ApiOperation(value = "拉黑用户", notes = "登陆")
    @RequestMapping(value = "/black", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Integer userBlack(MobileInfo mobileInfo,
                              @ApiParam(value = "目标用户id", required = true)Integer blackUserId,
                              @ApiParam(value = "操作类型0取消拉黑1拉黑", required = true)Integer type){

        if (type==1){
            UserBlack black=new UserBlack();
            black.setUserId(mobileInfo.getUserid());
            black.setBackUserId(blackUserId);
            black.setCreateTime(new Date());
            int num=userBlackService.insert(black);
            //删除关注状态
            UserFollowExample example1=new UserFollowExample();
            example1.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andFollowIdEqualTo(blackUserId);
            example1.or().andUserIdEqualTo(blackUserId).andFollowIdEqualTo(mobileInfo.getUserid());
            userFollowService.deleteByExample(example1);
            return num;
        }else if (type==0){
            UserBlackExample example=new UserBlackExample();
            example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andBackUserIdEqualTo(blackUserId);
            return userBlackService.deleteByExample(example);
        }
        return 0;
    }


    @ApiOperation(value = "用户私信", notes = "登陆")
    @RequestMapping(value = "/message/add", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Integer addUserMessage(MobileInfo mobileInfo,
                             @ApiParam(value = "目标用户id", required = true)Integer toUserId,
                             @ApiParam(value = "内容", required = true)String content){

        if (userBlackService.isBlackUser(mobileInfo.getUserid(),toUserId)>0){
            throw new ApiException("已被拉黑无法私信");
        }
        UserMessage message=new UserMessage();
        message.setFromUserId(mobileInfo.getUserid());
        message.setToUserId(toUserId);
        message.setStatus(0);
        message.setContent(content);
        message.setCreateTime(new Date());
        return userMessageService.insert(message);
    }


    @ApiOperation(value = "用户私信列表", notes = "登陆")
    @RequestMapping(value = "/message/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userMessageList(MobileInfo mobileInfo,
                                  @ApiParam(value = "目标用户id", required = false)Integer toUserId,
                                  @ApiParam(value = "状态0未读1已读", required = false)Integer status){

        UserMessage entity=new UserMessage();

        entity.setFromUserId(mobileInfo.getUserid());
        entity.setToUserId(toUserId);
        entity.setStatus(status);

        return userMessageService.findList(entity);
    }


    @ApiOperation(value = "用户私信对话列表", notes = "登陆")
    @RequestMapping(value = "/message/list", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object userMessageList(MobileInfo mobileInfo,
                                  @ApiParam(value = "目标用户id", required = false)Integer toUserId){

        UserMessage entity=new UserMessage();

        entity.setFromUserId(mobileInfo.getUserid());
        entity.setToUserId(toUserId);

        return userMessageService.findListEx(entity);
    }


    @ApiOperation(value = "意见反馈", notes = "登陆")
    @RequestMapping(value = "/option/add", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Object addUserOption(MobileInfo mobileInfo,
                                  @ApiParam(value = "图片", required = false)String img,
                                  @ApiParam(value = "意见内容", required = true)String info
    ){
        UserOption option=new UserOption();
        option.setCreateTime(new Date());
        option.setStatus(1);
        option.setUserId(mobileInfo.getUserid());
        option.setProcessState(0);
        option.setImg(img);
        option.setInfo(info);
        return userOptionService.insert(option);
    }
}
