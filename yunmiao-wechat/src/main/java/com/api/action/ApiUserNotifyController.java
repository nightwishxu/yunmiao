//package com.api.action;
//
//import com.api.MErrorEnum;
//import com.api.util.PageLimit;
//import com.api.view.user.AppUserNotify;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dao.model.Ret;
//import com.base.date.DateUtil;
//import com.base.dialect.PaginationSupport;
//import com.item.dao.model.UserNotify;
//import com.item.dao.model.UserNotifyExample;
//import com.item.service.UserNotifyService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import sun.nio.cs.US_ASCII;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/userNotify", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "消息列表(用户端)")
//public class ApiUserNotifyController extends ApiBaseController {
//
//    @Autowired
//    private UserNotifyService userNotifyService;
//
//    /**
//     * 用户消息列表
//     */
//    @ApiOperation(value = "用户消息列表(用户端)", notes = "登陆")
//    @RequestMapping("/userNotifyList")
//    @ApiMethod(isPage = true,isLogin = true)
//    public List<AppUserNotify> userNotifyList(MobileInfo mobileInfo,
//                                        PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        UserNotifyExample userNotifyExample = new UserNotifyExample();
//        userNotifyExample.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        userNotifyExample.setOrderByClause("create_time desc");
//        List<UserNotify> list = userNotifyService.selectByExample(userNotifyExample);
//
//        List<AppUserNotify> list2 = new ArrayList<AppUserNotify>();
//        for(UserNotify ex : list){
//            AppUserNotify record = new AppUserNotify();
//            record.setId(ex.getId());
//            record.setType(ex.getType());
//            record.setTitle(ex.getTitle());
//            record.setRedirectType(ex.getRedirectType());
//            record.setIsRead(1);
//            record.setContent(ex.getContent());
//            record.setCreateTime(DateUtil.dateToStr(ex.getCreateTime()));
//            list2.add(record);
//        }
//        return list2;
//    }
//
//    /**
//     * 删除用户列表
//     */
//    @ApiOperation(value = "删除用户列表(用户端)", notes = "登陆")
//    @RequestMapping("/delUserNotifyList")
//    @ApiMethod(isPage = false,isLogin = true)
//    public Ret userNotifyList(MobileInfo mobileInfo,
//                              @ApiParam(value="id",required = true) Integer id) {
//        UserNotifyExample userNotifyExample = new UserNotifyExample();
//        userNotifyExample.createCriteria().andIdEqualTo(id).andUserIdEqualTo(mobileInfo.getUserid());
//        int result = userNotifyService.deleteByExample(userNotifyExample);
//        if (result == 0) {
//            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//        }
//        return ok();
//    }
//}
