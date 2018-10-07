//package com.api.action;
//
//import com.alibaba.fastjson.JSONObject;
//import com.api.MEnumError;
//import com.api.MErrorEnum;
//import com.api.MPawnMsg;
//import com.api.util.PageLimit;
//import com.api.view.myPawn.*;
//import com.api.view.orgAuctionPawn.SysRecommendOrg;
//import com.api.view.orgHome.OrgIntroduction;
//import com.base.ConstantsCode;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dao.model.Ret;
//import com.base.date.DateUnit;
//import com.base.date.DateUtil;
//import com.base.dialect.PaginationSupport;
//import com.base.support.LogKit;
//import com.base.util.StringUtil;
//import com.item.dao.model.Code;
//import com.item.service.CodeService;
//import com.item.service.MobileVerifyService;
//import com.item.service.UserNotifyService;
//import com.item.service.UserService;
//import com.paidang.dao.model.*;
//import com.paidang.daoEx.model.PawnAuctionEx;
//import com.paidang.daoEx.model.UserBankCardEx;
//import com.paidang.daoEx.model.UserGoodsEx;
//import com.paidang.daoEx.model.UserPawnEx;
//import com.paidang.service.*;
//import com.paidang.utils.CostGenerator;
//import com.util.PaidangConst;
//import com.util.PaidangMessage;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@RestController
//@RequestMapping(value = "/api/userPawn", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "典当(用户端)")
//public class ApiUserPawnController extends ApiBaseController {
//    @Autowired
//    private UserPawnService userPawnService;
//    @Autowired
//    private UserGoodsService userGoodsService;
//    @Autowired
//    private PawnContinueService pawnContinueService;
//    @Autowired
//    private PawnAuctionService pawnAuctionService;
//    @Autowired
//    private UserBankCardService userBankCardService;
//    @Autowired
//    private UserNotifyService userNotifyService;
//    @Autowired
//    private UserBalanceLogService userBalanceLogService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PawnOrgService pawnOrgService;
//    @Autowired
//    private PawnLogService pawnLogService;
//    @Autowired
//    private UserAddressService userAddressService;
//    @Autowired
//    private OrgNotifyService orgNotifyService;
//    @Autowired
//    private MobileVerifyService verifyService;
//    @Autowired
//    private CodeService codeService;
////    /**
////     * 我的典当列表--竞拍中，已典当
////     */
////    @ApiOperation(value = "我的典当列表", notes = "分页,登陆")
////    @RequestMapping("/myPawnList")
////    @ApiMethod(isPage = true, isLogin = true)
////    public List<AppMyPawnList> myPawnList(MobileInfo mobileInfo,
////                                          PageLimit pageLimit,
////                                          @ApiParam(value="状态1竞拍中 2已典当",required = true)Integer state) {
////        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),
////                false);
////
////        Map<String, Object> map = new HashMap<String, Object>();
////        map.put("userId",mobileInfo.getUserid());
////        map.put("state",state);
////        //map.put("isVerify",1);
////        //state=-1已取消1竞拍中  2已典当
////            List<UserPawnEx> list = userPawnService.selectAppList(map);
////            return getUserPawnList(list,state);
////    }
////
////    /**
////     * 封装返回我的典当列表返回数据
////     *
////     * @param list
////     * @return
////     */
////    private List<AppMyPawnList> getUserPawnList(List<UserPawnEx> list, Integer type) {
////        List<AppMyPawnList> appMyPawnList = new ArrayList<AppMyPawnList>();
////        //用户选择机构确认后，state不变还是为在竞拍中--1，但是返给app状态需要是已典当状态
////        for (UserPawnEx ex : list) {
////            if(1 == type){
////                if(ex.getCnt() == 0 && (ex.getState() == 1 || ex.getState() == -1)){
////                    appMyPawnList.add(getUserPawningList(ex));
////                }
////            }
////            else{
////                if((ex.getCnt() != 0 && (ex.getState() == 1 || ex.getState() == 2)) || (ex.getCnt() != 0 && )){
////                    appMyPawnList.add(getUserPawnedList(ex));
////                }
////            }
////
////        }
////        return appMyPawnList;
////    }
////
////    /**
////     * 封装返回我的典当列表返回数据--竞拍中
////     *
////     * @param
////     * @return
////     */
////    private AppMyPawnList getUserPawningList(UserPawnEx ex) {
////        AppMyPawnList detail = new AppMyPawnList();
////        detail.setId(ex.getId());
////        detail.setTitle(ex.getGoodsName());
////        detail.setImage(ex.getImages());
////        detail.setAuthPrice(ex.getLoansPrice()+"");
////        int second = DateUtil.secondsAfter(DateUtil.addMinute(ex.getCreateTime(),(PaidangConst.AUCTION_TIME)/60),new Date());
////        if(second > 0 ){
////            detail.setTime(second+"");
////        }else{
////            detail.setTime("0");
////        }
////
////        Integer count  =pawnAuctionService.selectCount(ex.getId());
////        detail.setCount(count);
////        return detail;
////    }
////
////    /**
////     * 封装返回我的典当列表返回数据--已典当
////     *
////     * @param
////     * @return
////     */
////    private AppMyPawnList getUserPawnedList(UserPawnEx ex) {
////        AppMyPawnList detail = new AppMyPawnList();
////        detail.setId(ex.getId());
////        detail.setTitle(ex.getGoodsName());
////        detail.setImage(ex.getImages());
////        detail.setMoney(ex.getMoney()+"");
////        detail.setAuthPrice(ex.getAuthPrice()+"");
////        //detail.setPayeeTicket(ex.getPayeeTicket());
////        detail.setPawnTicket(ConstantsCode.SERVER_URL+"/m/pawn/toPawnTicket/"+ex.getId());
////        detail.setIsVerify(ex.getPayeeState());
////        //判断状态
////        if(null == ex.getPawnContinueState()){
////            //没有续当操作
////            detail.setContinueState(0);
////        }else {
////            if(1 == ex.getPawnContinueState()){
////                //提交续当申请
////                detail.setContinueState(1);
////            }else{
////                detail.setContinueState(0);
////            }
////        }
////
////        if(null == ex.getRedeemState()){
////            //没有赎当操作
////            detail.setRedeemState(0);
////        }else{
////            if(1 == ex.getRedeemState()){
////                //提交赎当申请
////                detail.setRedeemState(1);
////            }else{
////                detail.setContinueState(0);
////            }
////        }
////
////        //查找典当商品还有多久到期
////        int betTime = Integer.parseInt(DateUtil.between(new Date(),ex.getPawnEndTime(), DateUnit.DAY)+"");
////
////        if((betTime - (PaidangConst.BUFFER_DAYS)) >= 0){
////            //未逾期
////            detail.setTime(betTime+"");
////            detail.setType(0);
////        }else{
////            //逾期
////            detail.setTime(((PaidangConst.BUFFER_DAYS) - betTime)+"");
////            detail.setType(1);
////        }
////
////
////        return detail;
////    }
//
//    /**
//     * 我的典当列表--竞拍中
//     */
//    @ApiOperation(value = "我的典当列表--竞拍中", notes = "分页,登陆")
//    @RequestMapping("/myPawnList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppMyPawnList> myPawnList(MobileInfo mobileInfo,
//                                          PageLimit pageLimit) {
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        List<UserPawnEx> list = userPawnService.selectPawningList(map);
//        List<AppMyPawnList> ret = new ArrayList<>();
//        for(UserPawnEx ex : list){
//            AppMyPawnList detail = new AppMyPawnList();
//            detail.setId(ex.getId());
//            detail.setTitle(ex.getGoodsName());
//            detail.setImage(ex.getImages());
//            detail.setAuthPrice(ex.getAuthPrice()+"");
//            int second = DateUtil.secondsAfter(DateUtil.addMinute(ex.getCreateTime(),(PaidangConst.AUCTION_TIME)/60),new Date());
//            if(second > 0 ){
//                detail.setTime(second+"");
//            }else{
//                detail.setTime("0");
//            }
//
//            Integer count  =pawnAuctionService.selectCount(ex.getId());
//            detail.setCount(count);
//            ret.add(detail);
//        }
//
//        return ret;
//
//    }
//
//    /**
//     * 我的典当列表--已典当
//     */
//    @ApiOperation(value = "我的典当列表--已典当", notes = "分页,登陆")
//    @RequestMapping("/myPawnedList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppMyPawnList> myPawnedList(MobileInfo mobileInfo,
//                                          PageLimit pageLimit) {
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),false);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        List<UserPawnEx> list = userPawnService.selectMyPawnedList(map);
//        List<AppMyPawnList> ret = new ArrayList<>();
//        for(UserPawnEx ex : list){
//            AppMyPawnList detail = new AppMyPawnList();
//            detail.setId(ex.getId());
//            detail.setTitle(ex.getGoodsName());
//            detail.setImage(ex.getImages());
//            detail.setMoney(ex.getMoney()+"");
//            detail.setAuthPrice(ex.getAuthPrice()+"");
//            //detail.setPayeeTicket(ex.getPayeeTicket());
//            detail.setPawnTicket(ConstantsCode.SERVER_URL+"/m/pawn/toPawnTicket/"+ex.getId());
//            detail.setIsVerify(ex.getPayeeState());
//            //判断状态
//            if(null == ex.getPawnContinueState()){
//                //没有续当操作
//                detail.setContinueState(0);
//            }else {
//                if(1 == ex.getPawnContinueState()){
//                    //提交续当申请
//                    detail.setContinueState(1);
//                }else{
//                    detail.setContinueState(0);
//                }
//            }
//
//            if(null == ex.getRedeemState()){
//                //没有赎当操作
//                detail.setRedeemState(0);
//            }else{
//                if(2 == ex.getRedeemState()){
//                    //提交赎当申请
//                    detail.setRedeemState(1);
//                }else{
//                    detail.setContinueState(0);
//                }
//            }
//
//            //查找典当商品还有多久到期
//            int betTime = Integer.parseInt(DateUtil.between(new Date(),ex.getPawnEndTime(), DateUnit.DAY)+"");
//
//            if((betTime - (PaidangConst.BUFFER_DAYS)) >= 0){
//                //未逾期
//                detail.setTime(betTime+"");
//                detail.setType(0);
//            }else{
//                //逾期
//                detail.setTime(((PaidangConst.BUFFER_DAYS) - betTime)+"");
//                detail.setType(1);
//            }
//        ret.add(detail);
//        }
//
//        return ret;
//    }
//
//    /**
//     * 查看打款凭证
//     * @param mobileInfo
//     * @return
//     */
//    @ApiOperation(value = "查看打款凭证", notes = "登陆")
//    @RequestMapping("/checkTicket")
//    @ApiMethod(isLogin = true)
//    public List<AppMyPawnTicket> checkTicket(MobileInfo mobileInfo,
//                                             @ApiParam(value="id",required = true)Integer id){
//        List<AppMyPawnTicket> ret = new ArrayList<AppMyPawnTicket>();
//
//        UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
//            //用户典当凭证
//            AppMyPawnTicket c = new AppMyPawnTicket();
//            c.setTicket(userPawn.getPayeeTicket());
//            c.setId(id);
//            c.setState(1);
//            ret.add(c);
//
//        //找出当前当品的状态
//        if(3 == userPawn.getState() || 2 == userPawn.getState()){
//            //续当或者还在典当中
//            PawnContinueExample pawnContinueExample = new PawnContinueExample();
//            pawnContinueExample.createCriteria().andPawnIdEqualTo(id);
//            pawnContinueExample.setOrderByClause("create_time desc");
//            List<PawnContinue> pawnContinueList = pawnContinueService.selectByExample(pawnContinueExample);
//            if(pawnContinueList != null || pawnContinueList.size() != 0){
//                //用户有续当
//                for(PawnContinue ex : pawnContinueList){
//                    AppMyPawnTicket c2 = new AppMyPawnTicket();
//                    c2.setTicket(ex.getPayTicket());
//                    c2.setId(ex.getPawnId());
//                    c2.setState(2);
//                    ret.add(c2);
//                }
//                if(3 == userPawn.getState()){
//                    AppMyPawnTicket c2 = new AppMyPawnTicket();
//                    c2.setTicket(userPawn.getRedeemTicket());
//                    c2.setId(id);
//                    c2.setState(3);
//                    ret.add(c2);
//                }
//            }else{
//                //没有续当
//                AppMyPawnTicket c2 = new AppMyPawnTicket();
//                c2.setTicket(userPawn.getRedeemTicket());
//                c2.setId(id);
//                c2.setState(3);
//                ret.add(c2);
//            }
//        }
//        return ret;
//    }
//
//
//
//    @ApiOperation(value = "未典当列表", notes = "登陆,分页")
//    @RequestMapping("/noPawnList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppMyPawnNoDetail> noPawnList(MobileInfo mobileInfo,
//                                              PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),
//                false);
////        UserGoodsExample example = new UserGoodsExample();
////        example.createCriteria().andAuthResultEqualTo(4).andBelongIdEqualTo(mobileInfo.getUserid()).andGotoPawnEqualTo(0).andPostStateEqualTo(3).andBackStateEqualTo(0);
////        example.setOrderByClause("create_time desc");
////        List<UserGoods> list = userGoodsService.selectByExample(example);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        List<UserGoodsEx> list = userGoodsService.selectNoPawnList(map);
//
//        List<AppMyPawnNoDetail> list2 = new ArrayList<AppMyPawnNoDetail>();
//        if(list.size() == 0){
//            return list2;
//        }
//        for(UserGoodsEx ex :list){
//            AppMyPawnNoDetail detail = new AppMyPawnNoDetail();
//            detail.setId(ex.getId());
//            detail.setTitle(ex.getName());
//            detail.setImage(ex.getImages());
//            detail.setAuthPrice(ex.getAuthPrice()+"");
//            detail.setState(ex.getPostState());
//            if(0 == ex.getGoSell()){
//                detail.setGoSellType(-1);
//            }else if(1 == ex.getGoSell()){
//                detail.setGoSellType(0);
//            }else{
//                detail.setGoSellType(1);
//            }
//
//            //detail.setAuthCnt(ex.getCnt());
//
//            if(ex.getCnt() == 0){
//                //没人竞拍
//                detail.setAuthCnt(0);
//            }else{
//                //有人竞拍
//                if(ex.getIsVerify() == 0){
//                    //没付钱
//                    detail.setAuthCnt(0);
//                }else{
//                    detail.setAuthCnt(1);
//                }
//
//            }
//            detail.setPawnId(ex.getPawnId());
//            list2.add(detail);
//        }
//        return list2;
//    }
//
//    @ApiOperation(value = "已取消列表", notes = "登陆,分页")
//    @RequestMapping("/cancelPawnList")
//    @ApiMethod(isPage = true, isLogin = true)
//    public List<AppMyPawnNoDetail> cancelPawnList(MobileInfo mobileInfo,
//                                                  PageLimit pageLimit){
//        PaginationSupport.byPage(pageLimit.getPage(), pageLimit.getLimit(),
//                false);
//       Map<String, Object> map = new HashMap<String, Object>();
//       map.put("user_id",mobileInfo.getUserid());
//
//       //List<UserPawnEx> list = userPawnService.selectCancelPawnList(map);
//        List<UserGoodsEx> list = userGoodsService.selectCancelPawnList(map);
//       List<AppMyPawnNoDetail> list2 = new ArrayList<AppMyPawnNoDetail>();
//       for(UserGoodsEx ex : list){
//           if(ex.getUserPawnCount() > 1){
//               if(-1 == ex.getUserPawnState() && 1 == ex.getUserPawnUserState()){
//                   AppMyPawnNoDetail c = new AppMyPawnNoDetail();
//                   c.setId(ex.getUserPawnId());
//                   c.setImage(ex.getImages());
//                   c.setTitle(ex.getName());
//                   c.setAuthPrice(ex.getAuthPrice()+"");
//                   c.setState(ex.getPostState());
//                   if(0 == ex.getGoSell()){
//                       c.setGoSellType(-1);
//                   }else if(1 == ex.getGoSell()){
//                       c.setGoSellType(0);
//                   }else{
//                       c.setGoSellType(1);
//                   }
//                   list2.add(c);
//               }
//           }else{
//               AppMyPawnNoDetail c = new AppMyPawnNoDetail();
//               c.setId(ex.getUserPawnId());
//               c.setImage(ex.getImages());
//               c.setTitle(ex.getName());
//               c.setAuthPrice(ex.getAuthPrice()+"");
//               c.setState(ex.getPostState());
//               if(0 == ex.getGoSell()){
//                   c.setGoSellType(-1);
//               }else if(1 == ex.getGoSell()){
//                   c.setGoSellType(0);
//               }else{
//                   c.setGoSellType(1);
//               }
//               list2.add(c);
//           }
//
//
//       }
//
//        return list2;
//    }
//
//    /**
//     * 未典当的商品--去典当
//     */
//    @ApiOperation(value = "未典当的商品--去典当", notes = "登陆")
//    @RequestMapping("/gotoPawn")
//    @ApiMethod(isLogin = true)
//    public Ret gotoPawn(MobileInfo mobileInfo,
//                        @ApiParam(value="id",required = true)Integer id,
//                        @ApiParam(value="贷款额度",required = true)String loansPrice,
//                        @ApiParam(value="期望利率",required = true)String loansRate,
//                        @ApiParam(value="典当时长(半个月为1，一个月为2，两个月为4.以此类推)",required = true)Integer pawnTime) {
//        UserGoodsEx userGoods = userGoodsService.selectGotoPawn(id);
//        userGoods.setGotoPawn(1);
//
//        int result = userGoodsService.updateByPrimaryKeySelective(userGoods);
//        if(result == 0){
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//
//
//        UserPawn userPawn2 = new UserPawn();
//        userPawn2.setUserId(userGoods.getBelongId());
//        userPawn2.setGoodsId(id);
//        userPawn2.setLoansPrice(new BigDecimal(loansPrice));
//        userPawn2.setLoansRate(new BigDecimal(loansRate));
//        userPawn2.setIsVerify(0);
//        userPawn2.setPawnBeginTime(new Date());
//        userPawn2.setPawnEndTime(DateUtil.add(new Date(),pawnTime * 15));
//        userPawn2.setBeginPawnEndTime(DateUtil.add(new Date(),pawnTime * 15));
////        userPawn.setPayeeName(userGoods.getUserName());
////        userPawn.setPayeePhone(userGoods.getUserPhone());
//        userPawn2.setPayeeState(0);
//        userPawn2.setPawnTime(pawnTime);
//        userPawn2.setBeginPawnMonth(pawnTime);
//        userPawn2.setState(1);
//        userPawn2.setUserState(0);
//        userPawn2.setUserName(userGoods.getUserName());
//        userPawn2.setUserPhone(userGoods.getUserPhone());
//        userPawn2.setUserIdCard(userGoods.getIdCard());
//        userPawn2.setGoodsName(userGoods.getName());
//        //userPawn2.setOverdueRate(PaidangConst.REDEEM_OVERRATE);
//        int reuslt2 = userPawnService.insert(userPawn2);
//        if(reuslt2 == 0){
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//
//
//
//        return ok();
//    }
//
//    /**
//     * 已取消的的商品--去典当
//     */
//    @ApiOperation(value = "已取消的的商品--去典当", notes = "登陆")
//    @RequestMapping("/gotoPawn2")
//    @ApiMethod(isLogin = true)
//    public Ret gotoPawn2(MobileInfo mobileInfo,
//                        @ApiParam(value="id",required = true)Integer id,
//                        @ApiParam(value="贷款额度",required = true)String loansPrice,
//                        @ApiParam(value="期望利率",required = true)String loansRate,
//                        @ApiParam(value="典当时长(半个月为1，一个月为2，两个月为4.以此类推)",required = true)Integer pawnTime) {
//        UserPawnExample userPawnExample = new UserPawnExample();
//        userPawnExample.createCriteria().andIdEqualTo(id).andStateEqualTo(-1);
//        List<UserPawn> list = userPawnService.selectByExample(userPawnExample);
//        if(list.size() != 1){
//            throw new ApiException(MErrorEnum.APPID_FAIL_ERROR);
//        }
//        UserPawn userPawn1 = list.get(0);
//        UserGoodsEx userGoods = userGoodsService.selectGotoPawn(userPawn1.getGoodsId());
//        userGoods.setGotoPawn(1);
//        //新增典当表
//        UserPawn userPawn = new UserPawn();
//        userPawn.setUserId(mobileInfo.getUserid());
//        userPawn.setGoodsId(userPawn1.getGoodsId());;
//        userPawn.setLoansPrice(new BigDecimal(loansPrice));
//        userPawn.setLoansRate(new BigDecimal(loansRate));
//        userPawn.setPawnTime(pawnTime);
//        userPawn.setIsVerify(0);
//        userPawn.setPawnBeginTime(new Date());
//        userPawn.setPawnEndTime(DateUtil.add(new Date(),pawnTime*15));
//        userPawn.setBeginPawnEndTime(DateUtil.add(new Date(),pawnTime*15));
//        userPawn.setPayeeState(0);
//        userPawn.setBeginPawnMonth(pawnTime);
//        userPawn.setState(1);
//        userPawn.setUserState(0);
//        userPawn.setUserName(userGoods.getUserName());
//        userPawn.setUserPhone(userGoods.getUserPhone());
//        userPawn.setUserIdCard(userGoods.getIdCard());
//        userPawn.setGoodsName(userGoods.getName());
//        //userPawn.setOverdueRate(userPawn1.getOverdueRate());
//        userPawnService.insert(userPawn);
//
//        return ok();
//    }
//
//
//
//    @ApiOperation(value = "竞拍中典当详情(用户端)", notes = "登陆")
//    @RequestMapping("/pawningDetail")
//    @ApiMethod(isPage = false, isLogin = true)
//    public AppMyPawnList pawningDetail(MobileInfo mobileInfo,
//                        @ApiParam(value="id",required = true)Integer id) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",id);
//        map.put("user_id",mobileInfo.getUserid());
//        UserPawnEx userPawn = userPawnService.selectPawningDetail(map);
//
//        if (null == userPawn) {
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        List<PawnAuctionEx> list = pawnAuctionService.getAuctionDetailsByPawnId(id.toString());
//
//        AppMyPawnList appMyPawnList = new AppMyPawnList();
//        if (null != userPawn.getGoodsId()) {
//            UserGoods userGoods = getGoodsMsg(userPawn.getGoodsId());
//
//            appMyPawnList.setId(userPawn.getId());
//            appMyPawnList.setImage(userGoods.getImages());
//            appMyPawnList.setTitle(userGoods.getName());
//            appMyPawnList.setAuthPrice(userGoods.getAuthPrice() + "");
//            appMyPawnList.setLoansPrice(userPawn.getLoansPrice() + "");
//            appMyPawnList.setLoansRate(userPawn.getLoansRate() + "");
//
//            int second = DateUtil.secondsAfter(DateUtil.addMinute(userPawn.getCreateTime(),(PaidangConst.AUCTION_TIME)/60),new Date());
//            if(second > 0 ){
//                appMyPawnList.setTime(second+"");
//            }else{
//
//                appMyPawnList.setTime("0");
//            }
//
//            //贷款时间
//            appMyPawnList.setPawnTime(userPawn.getPawnTime()+"");
//            appMyPawnList.setCount(list.size());
//            appMyPawnList.setPawnAuctionList(list);
//        }
//
//        return appMyPawnList;
//
//    }
//
//    @ApiOperation(value = "(系统推荐机构)", notes = "登陆")
//    @RequestMapping("/getMax")
//    @ApiMethod(isPage = false, isLogin = true)
//    public SysRecommendOrg getMax(MobileInfo mobileInfo,
//                                  @ApiParam(value="id",required = true)Integer id){
//
//        PawnAuctionEx ex = pawnAuctionService.getSysRecommendOne(id+"");
//        SysRecommendOrg record = new SysRecommendOrg();
//        record.setId(ex.getId()+"");
//        record.setMoneyRate(ex.getMoneyRate()+"");
//        record.setMoney(ex.getMoney()+"");
//        record.setAuctionOrgname(ex.getAuctionOrgname());
//        record.setOrgId(ex.getOrgId()+"");
//        record.setRate(ex.getRate()+"");
//        return record;
//    }
//
//    @ApiOperation(value = "宝祥兜底详情", notes = "登陆")
//    @RequestMapping("/platGetDetail")
//    @ApiMethod(isLogin = true)
//    public APPMyPawnBxGet platGetDetail(MobileInfo mobileInfo,
//                                  @ApiParam(value="id",required = true)Integer id){
//        //User user = userService.selectByPrimaryKey(mobileInfo.getUserid());
//
//        UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
//
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(userPawn.getGoodsId());
//
//        APPMyPawnBxGet c = new APPMyPawnBxGet();
//        c.setId(userPawn.getId());
//        c.setTitle(userGoods.getName());
//        c.setAuthPrice(userGoods.getAuthPrice()+"");
//        c.setImage(userGoods.getImages());
//        c.setLoansPrice(userPawn.getLoansPrice()+"");
//        c.setLoansRate(userPawn.getLoansRate()+"");
//        c.setPawnTime(userPawn.getPawnTime()+"");
//        c.setBxOrgId(0+"");
//        //若期望当金小于等于鉴定价--选期望当金
//        //若期望当金大于鉴定价--选鉴定价
//        if(1 == userPawn.getLoansPrice().compareTo(userGoods.getAuthPrice())){
//            c.setBxMoney(userGoods.getAuthPrice()+"");
//        }else{
//            c.setBxMoney(userPawn.getLoansPrice()+"");
//        }
//        c.setBxRate(userGoods.getRate()+"");
//        c.setBxMoneyRate(userGoods.getMoneyRate()+"");
//        //平台信息
//        c.setComName(MPawnMsg.comName);
//        c.setComaddress(MPawnMsg.comAddress);
//        c.setRegMoney(MPawnMsg.regMoney);
//        c.setManager(MPawnMsg.manager);
//        c.setComPhone(MPawnMsg.comPhone);
//        return c;
//
//    }
//
//    @ApiOperation(value = "竞拍中宝祥兜底提交", notes = "登陆")
//    @RequestMapping("/platGet")
//    @ApiMethod(isLogin = true)
//    public Ret platGet(MobileInfo mobileInfo,
//                                  @ApiParam(value="id",required = true)Integer id,
//                                  @ApiParam(value="银行卡id",required = true)Integer bankCardId,
//                                  @ApiParam(value="机构id--宝祥机构id",required = true)Integer bxId,
//                                  @ApiParam(value="机构id--地址id",required = true)Integer addressId){
//       // UserBankCard userBankCard = userBankCardService.selectByPrimaryKey(bankCardId);
//
//        //UserAddress userAddress = userAddressService.selectByPrimaryKey(0);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        map.put("bankCardId",bankCardId);
//        UserBankCardEx userBankCard = userBankCardService.selectByUser(map);
//
//        UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(userPawn.getGoodsId());
//        //校验
//        //若期望当金小于等于鉴定价--选期望当金
//        //若期望当金大于鉴定价--选鉴定价
//        if(1 == userPawn.getLoansPrice().compareTo(userGoods.getAuthPrice())){
//            userPawn.setMoney(userGoods.getAuthPrice());
//            userPawn.setBeginMoney(userGoods.getAuthPrice());
//            userPawn.setPawnMoney(CostGenerator.getInterest(userGoods.getAuthPrice(),userGoods.getRate(),userPawn.getPawnTime()));
//        }else{
//            userPawn.setMoney(userPawn.getLoansPrice());
//            userPawn.setBeginMoney(userPawn.getLoansPrice());
//            userPawn.setPawnMoney(CostGenerator.getInterest(userPawn.getLoansPrice(),userGoods.getRate(),userPawn.getPawnTime()));
//        }
//        userPawn.setState(5);
//        userPawn.setRate(userGoods.getRate());
//        userPawn.setMoneyRate(userGoods.getMoneyRate());
//        userPawn.setBeginPawnMonth(userPawn.getPawnTime());
//
//        //userPawn.setState(2);
//        //userPawn.setIsVerify(1);
//        userPawn.setOrgId(0);
////        userPawn.setPayeePhone(userBankCard.getUserAccount());
////        userPawn.setPayeeName(userBankCard.getUserName());
////        userPawn.setPayeeState(0);
////        userPawn.setPayeeBankCardCode(userBankCard.getBankCardNo());
//        userPawn.setPayeeState(0);
////        userPawn.setUserAddress(MPawnMsg.comAddress);
////        userPawn.setUserPhone(MPawnMsg.phone);
////        userPawn.setUserName(userBankCard.getUserName());
////        userPawn.setPayeeBankName(userBankCard.getBankCardName());
//        userPawn.setPayeeBankCardCode(userBankCard.getBankCardNo());
//        userPawn.setPayeeBankName(userBankCard.getBankCardName());
//        userPawn.setPayeePhone(userBankCard.getBankCardPhone());
//        userPawn.setPayeeName(userBankCard.getUserName());
//        userPawn.setOrgSelectedTime(new Date());
//
//        userPawn.setUserPhone(userBankCard.getBankCardPhone());
//        userPawn.setUserName(userBankCard.getUserName());
//
//        userPawn.setPayeeBankName(userBankCard.getBankCardName());
//        String DatePawnEndTime = DateUtil.getAddDaysDate(new Date(),userPawn.getPawnTime()*15);
//        userPawn.setPawnBeginTime(new Date());
//        userPawn.setPawnEndTime(DateUtil.strToDate(DatePawnEndTime));
//        //设置宝祥兜底的逾期利率
//        Code code = codeService.selectByPrimaryKey("overRate");
//        if(null == code){
//            throw new ApiException("系统错误");
//        }
//        userPawn.setOverdueRate(new BigDecimal(code.getValue()));
//        int result = userPawnService.updateByPrimaryKeySelective(userPawn);
//
//        //去典当
//        userGoods.setGotoPawn(1);
//        userGoodsService.updateByPrimaryKeySelective(userGoods);
//
//        if(result == 0){
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
//
//        //插入典当记录表
//        pawnLogService.updatePawnlog(
//                userGoods.getId(),
//                mobileInfo.getUserid(),
//                0,
//                userGoods.getName(),
//                userGoods.getAuthPrice(),
//                userGoods.getCateCode(),
//                userGoods.getCateId(),
//                "宝祥典当行",
//                userPawn.getMoney(),
//                userPawn.getPawnTime(),
//                1,
//                userBankCard.getUserName(),
//                userBankCard.getBankCardName(),
//                userBankCard.getBankCardNo());
//
//        //推送
//        userNotifyService.insertByTemplate(mobileInfo.getUserid(),"1", PaidangMessage.PAWN_SUCCESS_NOTIFY,userGoods.getName(),userPawn.getOrgName(),userPawn.getPayeeBankName()+userPawn.getPayeeBankCardCode());
//        LogKit.debug("========================用户端发起推送兜底消息到机构端,orgId = 0 ========================");
//        orgNotifyService.insertByTemplate(0,"3",PaidangMessage.BAOXIANG_DOUDI,userGoods.getName());
//        return ok();
//    }
//
//    //竞拍中典当详情(用户端)--放弃本次竞拍
//    @ApiOperation(value = "竞拍中典当详情(用户端)--放弃本次竞拍", notes = "登陆")
//    @RequestMapping("/giveUpPawn")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret giveUpPawn(MobileInfo mobileInfo,
//                                       @ApiParam(value="id",required = true)Integer id) {
//        UserPawnExample userPawnExample = new UserPawnExample();
//        userPawnExample.or().andIdEqualTo(id).andStateEqualTo(-1);
//        userPawnExample.or().andIdEqualTo(id).andStateEqualTo(1);
//        List<UserPawn> list = userPawnService.selectByExample(userPawnExample);
//        if(list.size() == 0 || null == list){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        UserPawn userPawn = list.get(0);
//        if(1 == userPawn.getIsVerify()){
//            throw new ApiException(MEnumError.ORG_IS_PAY);
//        }
//        if(null == userPawn){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//
////        UserGoods userGoods = userGoodsService.selectByPrimaryKey(userPawn.getGoodsId());
////        userGoods.setGotoPawn(0);
////        userGoodsService.updateByPrimaryKeySelective(userGoods);
//
//        UserPawn ex = new UserPawn();
//        ex.setUserState(1);
//        ex.setState(-1);
//        int reuslt = userPawnService.updateByExampleSelective(ex,userPawnExample);
//        if(reuslt == 0){
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//        PawnAuctionExample example = new PawnAuctionExample();
//        example.createCriteria().andPawnIdEqualTo(id);
//        //删除订单记录
//        pawnAuctionService.deleteByExample(example);
//
//        //改为未典当
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(userPawn.getGoodsId());
//        if(null == userGoods){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        userGoods.setGotoPawn(0);
//        userGoodsService.updateByPrimaryKeySelective(userGoods);
//        return ok();
//
//    }
//
//
//
//    /**
//     * 查找当品信息
//     * @param goodsId
//     * @return
//     */
//    private UserGoods getGoodsMsg(Integer goodsId) {
//        UserGoodsExample example = new UserGoodsExample();
//        example.createCriteria().andIdEqualTo(goodsId);
//        List<UserGoods> list = userGoodsService.selectByExample(example);
//        UserGoods userGoods = list.get(0);
//        return userGoods;
//    }
//
////    //竞拍中的机构列表
////    @ApiOperation(value = "用户操作典当商品选择机构端列表", notes = "登陆")
////    @RequestMapping("/pawnOrgList")
////    @ApiMethod(isPage = false, isLogin = true)
////    public List<BidRecord> pawnOrgList(MobileInfo mobileInfo,
////                                       @ApiParam(value="id",required = true)Integer id){
////        List<PawnAuctionEx> list = pawnAuctionService.getAuctionDetailsByPawnId(id.toString());
////        List<BidRecord> list2 = new ArrayList<BidRecord>();
////        for(PawnAuctionEx ex : list){
////            BidRecord record = new BidRecord();
////            record.setMoneyRate(ex.getMoneyRate().toString());
////            record.setOrgName(ex.getAuctionOrgname());
////            record.setTime(ex.getTimes());
////            list2.add(record);
////        }
////        return list2;
////    }
//
//
//    /**
//     * 用户操作典当商品选择机构端
//     * @param mobileInfo
//     * @param aucId
//     * @param id
//     * @param bankCardId
//     * @return
//     * @throws ClassNotFoundException
//     */
//    @ApiOperation(value = "用户操作典当商品选择机构端", notes = "登陆")
//    @RequestMapping("/choiceOrg")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret choiceOrg(MobileInfo mobileInfo,
//                         @ApiParam(value="aucId",required = true)Integer aucId,
//                         @ApiParam(value="id",required = true)Integer id,
//                         @ApiParam(value="银行卡id",required = true)Integer bankCardId) throws ClassNotFoundException {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("user_id",mobileInfo.getUserid());
//        map.put("bankCardId",bankCardId);
//        UserBankCardEx userBankCard = userBankCardService.selectByUser(map);
//
//        UserPawn ex = userPawnService.selectByPrimaryKey(id);
//
//        UserGoods userGoods = userGoodsService.selectByPrimaryKey(ex.getGoodsId());
//
//        //选择的机构出的价格
//        PawnAuction pawnAuction = pawnAuctionService.selectByPrimaryKey(aucId);
//
//        PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(pawnAuction.getOrgId());
//
////        //选择的机构出的当金价格
////        PawnAuctionExample pawnAuctionExample = new PawnAuctionExample();
////        pawnAuctionExample.createCriteria().andPawnIdEqualTo(id).andOrgIdEqualTo(orgId);
////        List<PawnAuction> list3 = pawnAuctionService.selectByExample(pawnAuctionExample);
////        PawnAuction pawnAuction = list3.get(0);
//
//
//
//        if(null == ex){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        Ret ret = new Ret();
//        ex.setMoney(pawnAuction.getMoney());
//        ex.setBeginMoney(pawnAuction.getMoney());
//        ex.setPawnTicketCode(pawnAuction.getPawnCode());
//        ex.setOrgId(pawnAuction.getOrgId());
//        ex.setOrgUserId(pawnAuction.getOrgUserId());
//
//        //计算首期综合费
//        //MGetPawnMoney.getPawnMoney(pawnAuction.getMoney(),ex.getPawnTime(),pawnAuction.getRate());
//        BigDecimal money = CostGenerator.getInterest(pawnAuction.getMoney(),pawnAuction.getRate(),ex.getPawnTime());
//        ex.setPawnMoney(money);
//        ex.setGoodsName(userGoods.getName());
//        ex.setUserName(userBankCard.getUserName());
//        ex.setUserPhone(userBankCard.getUserAccount());
//        ex.setPayeePhone(userBankCard.getUserAccount());
//        ex.setPayeeName(userBankCard.getUserName());
//        ex.setUserState(2);
//        ex.setPayeeState(0);
//        ex.setBeginPawnMonth(ex.getPawnTime());
//        ex.setPayeeBankCardCode(userBankCard.getBankCardNo());
//        ex.setPayeeBankName(userBankCard.getBankCardName());
//        ex.setRate(pawnAuction.getRate());
//        ex.setMoneyRate(pawnAuction.getMoneyRate());
//        String DatePawnEndTime = DateUtil.getAddDaysDate(new Date(),ex.getPawnTime()*15);
//        ex.setPawnBeginTime(new Date());
//        ex.setPawnEndTime(DateUtil.strToDate(DatePawnEndTime));
//        ex.setOrgSelectedTime(new Date());
//        ex.setOverdueRate(pawnOrg.getRedeemOverrate());
//
//
//        int result = userPawnService.updateByPrimaryKeySelective(ex);
//        if(result == 0){
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        }
////        //插入典当记录表
////        pawnLogService.updatePawnlog(
////                userGoods.getId(),
////                mobileInfo.getUserid(),
////                pawnAuction.getOrgId(),
////                userGoods.getName(),
////                userGoods.getAuthPrice(),
////                userGoods.getCateCode(),
////                userGoods.getCateId(),
////                pawnOrg.getName(),
////                pawnAuction.getMoney(),
////                ex.getPawnTime(),
////                1,
////                userBankCard.getUserName(),
////                userBankCard.getBankCardName(),
////                userBankCard.getBankCardNo());
//        LogKit.debug("========================用户端竞拍成功通知机构端,orgId = "+pawnAuction.getOrgId()+"========================");
//        //推送
//        //userNotifyService.insertByTemplate(mobileInfo.getUserid(), "1", PaidangMessage.PAWN_SUCCESS_NOTIFY, userGoods.getName(), ex.getOrgName(), ex.getPayeeBankName()+ex.getPayeeBankCardCode());
//        orgNotifyService.insertByTemplate(pawnAuction.getOrgId(), "3", PaidangMessage.ORG_BIDWON_NOFIFY, userGoods.getName());
////        Map<String, String> map2 = new HashMap<>();
////        map2.put("PaidangMessage.ORG_BIDWON_NOFIFY","3");
////        JPushOrgUtil.pushMessageToList(map2,userGoods.getName(),verifyService.getCid(pawnAuction.getOrgId()));
//        return ok();
//    }
//
//    @ApiOperation(value = "查看典当行详情(用户端)", notes = "登陆")
//    @RequestMapping("/checkOrgPawnDetail")
//    @ApiMethod(isLogin = true)
//    public OrgIntroduction checkOrgPawnDetail(MobileInfo mobileInfo,
//                                              @ApiParam(value="id",required = true)Integer id){
//
//        OrgIntroduction ex = pawnOrgService.getOrgIntroduction(id);
//        OrgIntroduction c = new OrgIntroduction();
//        c.setOrgName(ex.getOrgName());
//        c.setDealAmount(ex.getDealAmount());
//        c.setRegisteredCapital(ex.getRegisteredCapital());
//        c.setLagalPerson(ex.getLagalPerson());
//        c.setAddress(ex.getAddress());
//        c.setIntroduction(ex.getIntroduction() == null?"":ex.getIntroduction());
//        c.setOrgImages(ex.getOrgImages() == null?"":ex.getOrgImages());
//
//        return c;
//    }
//
//    @ApiOperation(value = "查看当票(用户端)", notes = "登陆")
//    @RequestMapping("/checkPawnTic")
//    @ApiMethod(isPage = false, isLogin = true)
//    public JSONObject checkPawnTic(MobileInfo mobileInfo,
//                                   @ApiParam(value="id",required = true)Integer id){
//        UserPawnExample userPawnExample = new UserPawnExample();
//        userPawnExample.createCriteria().andIdEqualTo(id).andUserIdEqualTo(mobileInfo.getUserid()).andStateEqualTo(2);
//        List<UserPawn> list = userPawnService.selectByExample(userPawnExample);
//        JSONObject object = new JSONObject();
//        String url = ConstantsCode.SERVER_URL+"/m/pawn/toPawnTicket/"+id;
//        object.put("dangpiao",url);
//
////        PawnContinueExample example = new PawnContinueExample();
////        example.createCriteria().andPawnIdEqualTo(id);
////        example.setOrderByClause("create_time desc");
////        List<PawnContinue> list2 = pawnContinueService.selectByExample(example);
////        if(list.size() != 0){
////            for(PawnContinue ex : list2){
////                map.put("续当当票",ConstantsCode.SERVER_URL+"/m/pawn/toPawnTicket/"+id);
////            }
////        }
//        return object;
//
//    }
//
//    //赎当详情
//    @ApiOperation(value = "赎当详情(用户端)", notes = "登陆")
//    @RequestMapping("/getBackGoods")
//    @ApiMethod(isPage = false, isLogin = true)
//    public AppMyPawnGetBack getBackGoods(MobileInfo mobileInfo,
//                                         @ApiParam(value="id",required = true)Integer id){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",id);
//        map.put("user_id",mobileInfo.getUserid());
//        UserPawnEx ex = userPawnService.selectPawningDetail(map);
//        if(null == ex){
//            throw new ApiException(MEnumError.CONTENT_NOEXIST_ERROR);
//        }
//        AppMyPawnGetBack record = new AppMyPawnGetBack();
//        record.setId(ex.getId());
//        record.setName(ex.getGoodsName());
//        record.setAuthPrice(ex.getAuthPrice().toString());
//        record.setImages(ex.getImages());
//        record.setMoney(ex.getMoney()+"");
//        record.setPawnTime(ex.getLastPawnMonth());
//        record.setRate(ex.getRate()+"");
//        record.setMonetRate(ex.getMoneyRate()+"");
//        record.setRedeemRate(ex.getOverdueRate()+"");
//        record.setBeginDate(DateUtil.dateToStr(ex.getPawnBeginTime()));
//        record.setEndDate(DateUtil.dateToStr(ex.getPawnEndTime()));
//
//        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
//        Date endDate= new Date();
//        long outTime = endDate.getTime() - ex.getPawnEndTime().getTime();
//        //综合利息
//        //BigDecimal totalMoney = ex.getBeginMoney().multiply(ex.getRate()).divide(new BigDecimal(ex.getPawnTime())).divide(new BigDecimal(100));
//        BigDecimal totalMoney = CostGenerator.getInterest(ex.getBeginMoney(),ex.getMoneyRate(),ex.getLastPawnMonth());
//        record.setTotalMoney(totalMoney+"");
//
//        long day=(outTime/(24*60*60*1000));
//        if(day > 0){
//            record.setOutTime((int) Math.ceil(day));
//            //逾期滞纳金
//            //BigDecimal yqMoney = ex.getBeginMoney().multiply(PaidangConst.REDEEM_OVERRATE).divide(new BigDecimal(day)).divide(new BigDecimal(100)).multiply(new BigDecimal(15));
//            BigDecimal yqMoney = CostGenerator.getOverdue(ex.getBeginMoney(),ex.getPawnEndTime(),ex.getOverdueRate());
//            record.setRedeemOverdue(yqMoney+"");
//            //合计
//            record.setAllMoney(totalMoney.add(yqMoney).add(ex.getMoney())+"");
//        }else{
//            //合计
//            record.setAllMoney(totalMoney.add(ex.getMoney())+"");
//            record.setRedeemOverdue("0");
//        }
//        //record.setTotalBackMoney("");
//        record.setBeginMoney(ex.getBeginMoney()+"");
//        //record.setRedeemOverdue(ex.getRedeemOverdue()+"");
//        record.setPayeeName(ex.getPayName());
//        record.setPayeeBankName(ex.getPayBankName());
//        record.setPayeeBankCardCode(ex.getPayBacnkCardCode());
//        record.setPawnticketCode(ex.getPawnTicketCode());
//        return record;
//
//    }
//
//
//    //用户赎当申请
//    @ApiOperation(value = "用户赎当申请(用户端)", notes = "登陆")
//    @RequestMapping("/applyGetBack")
//    @ApiMethod(isPage = false, isLogin = true)
//    public Ret applyGetBack(MobileInfo mobileInfo,
//                            @ApiParam(value="id",required = true)Integer id,
//                            @ApiParam(value="用户赎当打款凭证",required = true)String redeemTicket){
//        UserPawnExample userPawnExample = new UserPawnExample();
//        userPawnExample.createCriteria().andIdEqualTo(id);
//        List<UserPawn> list = userPawnService.selectByExample(userPawnExample);
//        UserPawn userPawn = list.get(0);
//
//        userPawn.setRedeemTicket(redeemTicket);
//        userPawn.setRedeemState(2);
//
//
//
//        int result = userPawnService.updateByPrimaryKeySelective(userPawn);
//        if(result == 0){
//            throw new ApiException(MEnumError.OPER_FAILURE_ERROE);
//        }
//        BigDecimal totalMoney = CostGenerator.getInterest(userPawn.getBeginMoney(),userPawn.getMoneyRate(),userPawn.getPawnTime());
//
//
//        LogKit.debug("=================用户端赎当申请的推送，orgId="+userPawn.getOrgId()+"====================");
//        //推送
//        orgNotifyService.insertByTemplate(userPawn.getOrgId(),"4", PaidangMessage.USER_REDEEM_NOTIFY,userPawn.getPayeeName(),DateUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm"),
//                totalMoney+"");
//        return ok();
//    }
//
//}
