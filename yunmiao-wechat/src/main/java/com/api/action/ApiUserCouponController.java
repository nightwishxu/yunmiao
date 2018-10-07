//package com.api.action;
//
//import com.api.util.PageLimit;
//import com.api.view.user.AppUserCoupon;
//import com.base.api.ApiBaseController;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dialect.PaginationSupport;
//import com.base.util.DateUtil;
//import com.paidang.dao.model.UserCoupon;
//import com.paidang.dao.model.UserCouponExample;
//import com.paidang.daoEx.model.UserCouponEx;
//import com.paidang.service.UserCouponService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.*;
//
//import static com.base.util.DateUtil.YYMMDD;
//
//@RestController
//@RequestMapping(value = "/api/userCoupon", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "我的优惠券(用户端)")
//public class ApiUserCouponController extends ApiBaseController {
//    @Autowired
//    private UserCouponService userCouponService;
//
//    @ApiOperation(value = "我的优惠券列表", notes = "分页")
//    @RequestMapping("/userCouponList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppUserCoupon> userCouponList(MobileInfo mobileInfo,
//                                              PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
////        UserCouponExample example = new UserCouponExample();
////        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andStateEqualTo(1).andEndTimeGreaterThanOrEqualTo(new Date());
////        List<UserCoupon> list = userCouponService.selectByExample(example);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        List<UserCouponEx> list = userCouponService.selectByGoods(map);
//        List<AppUserCoupon> list2 = new ArrayList<AppUserCoupon>();
//        if(list.size() == 0 || list == null){
//            return list2;
//        }
//        for(UserCouponEx ex : list){
//            AppUserCoupon record = new AppUserCoupon();
//            record.setId(ex.getId());
//            record.setCouponId(ex.getCouponId());
//            //record.setFull(ex.getFull()+"");
//            record.setValue(ex.getFull()+"");
//            record.setEndTime(DateUtil.dateToStr(ex.getEndTime()));
//            record.setInfo(ex.getGoodsName());
//            record.setSource(ex.getSource());
//            record.setPrice(ex.getGoodsPrice());
//            list2.add(record);
//        }
//
//        return list2;
//    }
//}
