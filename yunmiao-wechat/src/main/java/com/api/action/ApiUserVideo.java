//package com.api.action;
//
//import com.api.MErrorEnum;
//import com.api.util.PageLimit;
//import com.api.view.myPawn.AppMyPawnList;
//import com.api.view.video.AppMyVideo;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.date.DateUtil;
//import com.base.dialect.PaginationSupport;
//import com.paidang.dao.model.UserGoods;
//import com.paidang.dao.model.UserGoodsExample;
//import com.paidang.dao.model.UserPawn;
//import com.paidang.daoEx.model.UserGoodsEx;
//import com.paidang.service.UserGoodsService;
//import com.paidang.service.UserPawnService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.omg.CORBA.OBJECT_NOT_EXIST;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping(value = "/api/userPawn", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "典当监控(用户端)")
//public class ApiUserVideo extends ApiBaseController {
//    @Autowired
//    private UserGoodsService userGoodsService;
//
//    /**
//     * 典当监控列表
//     */
//    @ApiOperation(value = "典当监控列表", notes = "分页,登陆")
//    @RequestMapping("/myVideoList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppMyVideo> myVideoList(MobileInfo mobileInfo,
//                                        PageLimit pageLimit) {
//        PaginationSupport.byPage(pageLimit.getPage(),pageLimit.getLimit(),false);
//        List<AppMyVideo> ret = new ArrayList<AppMyVideo>();
//        UserGoodsExample example = new UserGoodsExample();
//        example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid());
//        example.setOrderByClause("create_time desc");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        List<UserGoodsEx> list = userGoodsService.selectMyVideo(map);
//        for(UserGoodsEx ex : list){
//            AppMyVideo c = new AppMyVideo();
//            c.setId(ex.getId());
//            c.setAuthPrice(ex.getAuthPrice() == null? "" : ex.getAuthPrice()+"");
//            c.setCode(ex.getPawnTicketCode() == null? "" : ex.getPawnTicketCode());
//            c.setOrgName(ex.getOrgName() == null? "" : ex.getOrgName());
//            if(null == ex.getName()){
//                if(ApiUserGoodsController.MGoodsCateList.SCPZB.equals(ex.getCateCode())){
//                    c.setGoodName("奢侈品珠宝");
//                }else if(ApiUserGoodsController.MGoodsCateList.sb.equals(ex.getCateCode())){
//                    c.setGoodName("钻石");
//                }else if(ApiUserGoodsController.MGoodsCateList.zs.equals(ex.getCateCode())){
//                    c.setGoodName("贵金属");
//                }else if(ApiUserGoodsController.MGoodsCateList.gjs.equals(ex.getCateCode())){
//                    c.setGoodName("翡翠玉石");
//                }else if(ApiUserGoodsController.MGoodsCateList.fcys.equals(ex.getCateCode())){
//                    c.setGoodName("和田玉");
//                }else if(ApiUserGoodsController.MGoodsCateList.hty.equals(ex.getCateCode())){
//                    c.setGoodName("其他");
//                }else if(ApiUserGoodsController.MGoodsCateList.qt.equals(ex.getCateCode())){
//                    c.setGoodName("奢侈品珠宝");
//                }
//            }else{
//                c.setGoodName(ex.getName() == null? "" : ex.getName());
//            }
//
//            String [] str = new String[]{ex.getImages()};
//            c.setImg(str[0]);
//            ret.add(c);
//        }
//        return ret;
//    }
//
//    /**
//     * 典当监控详情
//     */
//    @ApiOperation(value = "典当监控详情", notes = "分页,登陆")
//    @RequestMapping("/myVideoDetail")
//    @ApiMethod(isPage = false, isLogin = true)
//    public AppMyVideo myVideoDetail(MobileInfo mobileInfo,
//                                    @ApiParam(value = "视频id",required = true)Integer id ) {
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(id);
//        if(null == userGoods){
//            throw new ApiException(MErrorEnum.VIDEO_NOTEXISTS_ERROR);
//        }
//        AppMyVideo c = new AppMyVideo();
//        c.setGoVideo(userGoods.getGoVideo() == null? "" : userGoods.getGoVideo());
//        c.setOpenVideo(userGoods.getOpenGoodsVideo() == null? "" : userGoods.getOpenGoodsVideo());
//        c.setPlatGoodsAuthVideo(userGoods.getPlatGoodsAuthVideo() == null? "" : userGoods.getPlatGoodsAuthVideo());
//        c.setTime(DateUtil.dateToStr(userGoods.getCreateTime()));
//        return c;
//    }
//}
