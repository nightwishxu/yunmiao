package com.api.wxaction;

import com.base.api.ApiBaseController;
import com.base.api.ApiException;
import com.base.api.MobileInfo;
import com.base.api.annotation.ApiMethod;
import com.item.dao.model.*;
import com.item.service.UserBlackService;
import com.item.service.UserFollowService;
import com.item.service.UserMessageService;
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




    @ApiOperation(value = "关注(取消关注)用户", notes = "登陆")
    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    @ApiMethod(isLogin = true)
    public Integer userFollow(MobileInfo mobileInfo,
                              @ApiParam(value = "目标用户id", required = true)Integer followUserId,
                              @ApiParam(value = "操作类型0取消关注1关注", required = true)Integer type){
        //获取关注状态
        Map<String,Object> map = userFollowService.getFollowStatus(mobileInfo.getUserid(),followUserId);
        Integer status=(Integer) map.get("status");
        UserFollow entity=(UserFollow)map.get("userFollow");
        UserFollowExample example=new UserFollowExample();
        UserFollow follow=new UserFollow();
        if (type==0){
            //取消关注
            example.createCriteria().andUserIdEqualTo(entity.getUserId()).andOperateObjectEqualTo(entity.getOperateObject());
            if (status==3){
                follow.setStatus(2);
                return userFollowService.updateByExampleSelective(follow,example);
            }else if (status==4){
                follow.setStatus(1);
                return userFollowService.updateByExampleSelective(follow,example);
            }else if (status==1){
                return userFollowService.deleteByExample(example);
            }
        }else if (type==1){
            if (userBlackService.isBlackUser(mobileInfo.getUserid(),followUserId)>0){
                throw new ApiException("已被拉黑无法关注");
            }
            //关注
            if (status==0){
                follow.setUserId(mobileInfo.getUserid());
                follow.setOperateObject(followUserId);
                follow.setStatus(1);
                follow.setCreateTime(new Date());
                return userFollowService.insert(follow);
            }else if (status==2){
                example.createCriteria().andUserIdEqualTo(entity.getUserId()).andOperateObjectEqualTo(entity.getOperateObject());
                follow.setStatus(3);
                return userFollowService.updateByExampleSelective(follow,example);
            }
        }else {
            throw new ApiException("参数非法");
        }
        return null;
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
            example1.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andOperateObjectEqualTo(blackUserId);
            example1.or().andUserIdEqualTo(blackUserId).andUserIdEqualTo(mobileInfo.getUserid());
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

}
