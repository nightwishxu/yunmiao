//package com.api.action;
//
//import com.api.MEnumError;
//import com.api.MErrorEnum;
//import com.api.view.myPawn.AppMyPawnConinue;
//import com.base.api.ApiBaseController;
//import com.base.api.ApiException;
//import com.base.api.MobileInfo;
//import com.base.api.annotation.ApiMethod;
//import com.base.dao.model.Ret;
//import com.base.date.DateUnit;
//import com.base.support.LogKit;
//import com.base.util.DateUtil;
//import com.item.service.UserNotifyService;
//import com.paidang.dao.model.PawnContinue;
//import com.paidang.dao.model.PawnContinueExample;
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
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@RestController
//@RequestMapping(value = "/api/userGoods", produces = { "application/json;charset=UTF-8" }, method = RequestMethod.POST)
//@Api(tags = "用户续当(用户端)")
//public class ApiUserPawnConinueController extends ApiBaseController {
//    @Autowired
//    private PawnContinueService pawnContinueService;
//    @Autowired
//    private UserPawnService userPawnService;
//    @Autowired
//    private UserBalanceLogService userBalanceLogService;
//    @Autowired
//    private OrgBalanceLogService orgBalanceLogService;
//    @Autowired
//    private PawnLogService pawnLogService;
//    @Autowired
//    private UserNotifyService userNotifyService;
//    @Autowired
//    private OrgNotifyService orgNotifyService;
//
//    @ApiOperation(value="续当办理详情--第一个页面",notes = "登录")
//    @RequestMapping("pawnConinueDetailFirst")
//    @ApiMethod(isPage = false, isLogin = true)
//    public AppMyPawnConinue pawnConinueDetailFirst(MobileInfo mobileInfo,
//                                              @ApiParam(value="id",required = true) Integer id)throws Exception{
//
////        UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
////        if(null != userPawn.getLastPawnContinueId()){
////            //用户续当过
////            //并且此次续当机构端没有确认收款
////            PawnContinueExample example = new PawnContinueExample();
////            example.createCriteria().andPawnIdEqualTo(id).andStateNotEqualTo(4);
////            List<PawnContinue> list = pawnContinueService.selectByExample(example);
////            if(list.size() != 0 || null != list || !list.isEmpty()){
////                throw new ApiException(MErrorEnum.ORG_NOT_VERIFY);
////            }
////        }
//
//
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",id);
//        map.put("userId",mobileInfo.getUserid());
//        UserPawnEx ex = userPawnService.selectByPawnConinueDetail(map);
//        if(null == ex){
//            throw new ApiException(MErrorEnum.GOODS_NOTEXISTS_ERROR);
//        }
//        AppMyPawnConinue record = new AppMyPawnConinue();
//        record.setTitle(ex.getGoodsName());
//        record.setAuthPrice(ex.getAuthPrice()+"");
//        record.setGoodsId(ex.getPawnTicketCode());
//        record.setImages(ex.getImages());
//        record.setOrgName(ex.getOrgName());
//        record.setRate(ex.getRate()+"");
//        record.setMoneyRate(ex.getMoneyRate()+"");
//        record.setBeginTime(DateUtil.dateToStr(ex.getPawnBeginTime()));
//        record.setEndTime(DateUtil.dateToStr(ex.getPawnEndTime()));
//        record.setMoney(ex.getBeginMoney()+"");
//        return record;
//
//    }
//
//    @ApiOperation(value="续当办理详情--第二个页面",notes = "登录")
//    @RequestMapping("pawnConinueDetailSecond")
//    @ApiMethod(isLogin = true)
//    public AppMyPawnConinue pawnConinueDetailSecond(MobileInfo mobileInfo,
//                                                    @ApiParam(value="id",required = true) Integer id,
//                                                    @ApiParam(value="续当档期",required = true) Integer pawnTime){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",id);
//        map.put("userId",mobileInfo.getUserid());
//        UserPawnEx ex = userPawnService.selectByPawnConinueDetail(map);
//        AppMyPawnConinue record = new AppMyPawnConinue();
//
//        record.setTitle(ex.getGoodsName());
//        record.setAuthPrice(ex.getAuthPrice()+"");
//        record.setGoodsId(ex.getPawnTicketCode());
//        record.setImages(ex.getImages());
//        record.setOrgName(ex.getOrgName());
//        record.setRate(ex.getRate()+"");
//        record.setMoneyRate(ex.getMoneyRate()+"");
//        record.setBeginTime(DateUtil.dateToStr(ex.getPawnBeginTime(),"yyyy-MM-dd"));
//        //当前还款日期
//        String endTime = DateUtil.getAddDaysDate(ex.getPawnEndTime(),ex.getPawnTime()*15);
//        record.setEndTime(endTime);
//        record.setMoney(ex.getBeginMoney()+"");
//        //初始化综合利息
//        BigDecimal totalMoney = null;
//        BigDecimal lxMoeny = null;
//
// /*       //续当综合利息+利息
//        //续当档期的份数除以15，是不是整数
//        if((pawnTime * 15) % 30 == 0){
//            //整数
//            //综合利息
//            totalMoney = ex.getBeginMoney().multiply(ex.getRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//            record.setZhlxMoney(totalMoney+"");
//
//            //整数
//            //利息利率
//            lxMoeny = ex.getBeginMoney().multiply(ex.getMoneyRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//            record.setLxMoney(lxMoeny + "");
//        }else{
//            //不能整除--先取能整除的部分--然后取不能整除的不部分算法
//            if(1 == pawnTime){
//                //当15天
//                totalMoney = ex.getBeginMoney().multiply(ex.getRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//                record.setZhlxMoney(totalMoney+"");
//                //利息利率
//                lxMoeny = ex.getBeginMoney().multiply(ex.getMoneyRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//                record.setLxMoney(lxMoeny + "");
//            }else{
//                //超过15天
//                int t = (int) Math.floor((pawnTime * 15) % 30);
//                totalMoney = (ex.getBeginMoney().multiply(ex.getRate())).add(ex.getBeginMoney().multiply(ex.getRate()).multiply(new BigDecimal(15)).divide(new BigDecimal(30))).divide(new BigDecimal(100));
//                record.setZhlxMoney(totalMoney+"");
//                //利息利率
//                lxMoeny = (ex.getBeginMoney().multiply(ex.getMoneyRate())).add(ex.getBeginMoney().multiply(ex.getMoneyRate()).multiply(new BigDecimal(15)).divide(new BigDecimal(30))).divide(new BigDecimal(100));
//                record.setLxMoney(lxMoeny+"");
//            }
//        }*/
//
//        BigDecimal principal = ex.getBeginMoney();
//        if (pawnTime == null)
//            throw new ApiException(MEnumError.SERVER_BUSY_ERROR);
//        totalMoney=CostGenerator.getInterest(principal,ex.getRate(),pawnTime);
//        record.setZhlxMoney(totalMoney.toString());
//        //
//        PawnContinueExample pawnContinueExample = new PawnContinueExample();
//        pawnContinueExample.setOrderByClause("create_time desc");
//        pawnContinueExample.createCriteria().andPawnIdEqualTo(ex.getId());
//        List<PawnContinue> pawnContinues = pawnContinueService.selectByExample(pawnContinueExample);
//        if (pawnContinues == null || pawnContinues.size()==0){//首次续当
//
//            record.setLxMoney(CostGenerator.getInterest(principal,ex.getMoneyRate(),ex.getBeginPawnMonth()).toString());
//            lxMoeny = CostGenerator.getInterest(principal,ex.getMoneyRate(),ex.getBeginPawnMonth());
//
//        }else {
//            PawnContinue lastPawnContinue = pawnContinues.get(0);
//            record.setLxMoney(CostGenerator.getInterest(principal,ex.getMoneyRate(),lastPawnContinue.getPawnMonth()).toString());
//            lxMoeny = CostGenerator.getInterest(principal,ex.getMoneyRate(),lastPawnContinue.getPawnMonth());
//        }
//
//
//        //查找典当商品还有多久到期
//        int betTime = Integer.parseInt(com.base.date.DateUtil.between(new Date(),ex.getPawnEndTime(), DateUnit.DAY)+"");
//
//        //如果逾期了--在五天范围内，计算逾期滞纳金
//        if((betTime - (PaidangConst.BUFFER_DAYS)) >= 0){
//            //没有逾期
//            //record.setOverdueRate(PaidangConst.REDEEM_OVERRATE + "");
//            record.setOverdueRate(ex.getOverdueRate()+"");
//            //滞纳金
//            record.setRedeemOverdue("0");
//            //费用总计
//            record.setTotalMoney(totalMoney.add(lxMoeny)+"");
//        }else{
//            //逾期了，并且还在典当中
//            //record.setOverdueRate(PaidangConst.REDEEM_OVERRATE + "");
//            record.setOverdueRate(ex.getOverdueRate()+"");
//            //滞纳金
//            record.setRedeemOverdue(new BigDecimal(betTime - (PaidangConst.BUFFER_DAYS)).multiply(ex.getOverdueRate()).divide(new BigDecimal(100))+"");
//            //费用总计
//            record.setTotalMoney(totalMoney.add(lxMoeny).add(new BigDecimal(betTime - (PaidangConst.BUFFER_DAYS)).multiply(ex.getOverdueRate())).divide(new BigDecimal(100))+"");
//        }
//
//        record.setPayeeName(ex.getPayName());
//        record.setPayeeBankName(ex.getPayBankName());
//        record.setPayeeBankCardCode(ex.getPayBacnkCardCode());
//        return record;
//
//    }
//
//
//    @ApiOperation(value="续当",notes = "登录")
//    @RequestMapping("/goPawnContinue")
//    @ApiMethod(isPage = false, isLogin =  true)
//    public Ret goPawnContinue(MobileInfo mobileInfo,
//                              @ApiParam(value="id",required = true) Integer id,
//                              @ApiParam(value="续当时间",required = true)Integer pawnTime,
//                              @ApiParam(value="打款凭证",required = true)String platformImage){
//        Map<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("id",id);
//        map2.put("userId",mobileInfo.getUserid());
//        UserPawnEx ex = userPawnService.selectByPawnConinueDetail(map2);
//        BigDecimal totalMoney = null;
//        BigDecimal lxMoeny = null;
//        if((pawnTime * 15) % 30 == 0){
//            //整数
//            //综合利息
//            totalMoney = ex.getBeginMoney().multiply(ex.getRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//
//            //整数
//            //利息利率
//            lxMoeny = ex.getBeginMoney().multiply(ex.getMoneyRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//        }else{
//            //不能整除--先取能整除的部分--然后取不能整除的不部分算法
//            if(1 == pawnTime){
//                //当15天
//                totalMoney = ex.getBeginMoney().multiply(ex.getRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//                //利息利率
//                lxMoeny = ex.getBeginMoney().multiply(ex.getMoneyRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//            }else{
//                //超过15天
//                int t = (int) Math.floor((pawnTime * 15) % 30);
//                totalMoney = (ex.getBeginMoney().multiply(ex.getRate())).add(ex.getBeginMoney().multiply(ex.getRate()).multiply(new BigDecimal(15)).divide(new BigDecimal(30))).divide(new BigDecimal(100));
//                //利息利率
//                lxMoeny = (ex.getBeginMoney().multiply(ex.getMoneyRate())).add(ex.getBeginMoney().multiply(ex.getMoneyRate()).multiply(new BigDecimal(15)).divide(new BigDecimal(30))).divide(new BigDecimal(100));
//            }
//        }
//
//        //查找典当商品还有多久到期
//        int betTime = Integer.parseInt(com.base.date.DateUtil.between(new Date(),ex.getPawnEndTime(), DateUnit.DAY)+"");
//        //如果逾期了--在五天范围内，计算逾期滞纳金
//        if((betTime - (PaidangConst.BUFFER_DAYS)) < 0){
//            throw new ApiException(MErrorEnum.GOODS_OUT_TIME);
//        }
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("id",id);
//        map.put("user_id",mobileInfo.getUserid());
//        UserPawnEx userPawn = userPawnService.selectUserName(map);
//
//        PawnContinue pawnContinue = new PawnContinue();
//        pawnContinue.setPawnId(userPawn.getId());
//        pawnContinue.setPawnTicketCode(userPawn.getPawnTicketCode());
//        pawnContinue.setPawnMonth(pawnTime);
//
//        BigDecimal beginMoney = userPawn.getBeginMoney();
//        BigDecimal rate = userPawn.getRate();
//
//        BigDecimal result2;
//
//        //判断续当时间份数是不是整月
//        if((pawnTime * 15) % 30 == 0){
//            //整数
//            //续当费用
//            //result2 = beginMoney.multiply(userPawn.getRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//            result2 = totalMoney.add(lxMoeny);
//        }else{
//            //不能整除--先取能整除的部分--然后取不能整除的不部分算法
//            if(1 == pawnTime){
//                //当15天
//                //续当费用
//                //result2 = beginMoney.multiply(userPawn.getRate()).multiply(new BigDecimal(pawnTime * 15)).divide(new BigDecimal(30)).divide(new BigDecimal(100));
//                result2 = totalMoney.add(lxMoeny);
//            }else{
//                //超过15天
//                //续当费用
//                int t = (int) Math.floor((pawnTime * 15) % 30);
//                //result2 = (beginMoney.multiply(userPawn.getRate())).add(userPawn.getBeginMoney().multiply(userPawn.getRate()).multiply(new BigDecimal(15)).divide(new BigDecimal(30))).divide(new BigDecimal(100));
//                result2 = totalMoney.add(lxMoeny);
//            }
//        }
// //     pawnContinue.setPawnMoney(result2);
//
//        pawnContinue.setPawnLastEndTime(userPawn.getPawnEndTime());
//        pawnContinue.setPawnEndTime(DateUtil.add(userPawn.getPawnEndTime(),pawnTime*15));
//
//
//        //计算上一期利息和上期滞纳金（若逾期）
//        Integer prePawnMonth;
//        BigDecimal thisPeriodPawnMoney;//本期综合费
//        BigDecimal preInterest;//上期利息
//        BigDecimal overdue;//上期逾期滞纳金
//        PawnContinueExample pawnContinueExample = new PawnContinueExample();
//        pawnContinueExample.createCriteria().andPawnIdEqualTo(userPawn.getId());
//        pawnContinueExample.setOrderByClause("create_time desc");
//        List<PawnContinue> pawnContinues = pawnContinueService.selectByExample(pawnContinueExample);
//        if (pawnContinues == null || pawnContinues.size() == 0){
//            prePawnMonth = userPawn.getBeginPawnMonth();
//            overdue = CostGenerator.getOverdue(userPawn.getBeginMoney(),userPawn.getBeginPawnEndTime(),userPawn.getOverdueRate());
//        }else{
//            prePawnMonth = pawnContinues.get(0).getPawnMonth();
//            overdue = CostGenerator.getOverdue(userPawn.getBeginMoney(),pawnContinues.get(0).getPawnLastEndTime(),userPawn.getOverdueRate());
//        }
//        thisPeriodPawnMoney = CostGenerator.getInterest(userPawn.getBeginMoney(),userPawn.getRate(),pawnTime);
//        preInterest = CostGenerator.getInterest(userPawn.getBeginMoney(),userPawn.getMoneyRate(),prePawnMonth);
//        pawnContinue.setPawnMoney(thisPeriodPawnMoney);
//        pawnContinue.setPawnInterest(preInterest);
//        pawnContinue.setPawnOverdue(overdue);
//        //本次续当平台服务费
//        BigDecimal platformFee = CostGenerator.getPlatformFee(thisPeriodPawnMoney);
//        pawnContinue.setPlatformMoney(platformFee);
//        pawnContinue.setPlatformState(0);//0未缴纳1已缴纳平台服务费
//
//
//
////       pawnContinue.setPawnInterest(userPawn.getRate());
////       pawnContinue.setPawnOverdue(new BigDecimal(0));
//        //pawnContinue.setPlatformMoney(userPawn.getPawnMoney().multiply(userPawn.getPlatformRate()));
//        pawnContinue.setState(1);
//        //pawnContinue.setPlatformState(1);
//        pawnContinue.setPayTicket(platformImage);
//        pawnContinue.setPawnTicket(userPawn.getPawnTicket());
//        pawnContinue.setPayTime(new Date());
//        pawnContinue.setUserName(userPawn.getUserName());
//        pawnContinue.setUserBank(userPawn.getPayeeBankName());
//        pawnContinue.setUserBankCard(userPawn.getPayeeBankCardCode());
//
//        //用户余额日志插入信息
////        userBalanceLogService.updateUserBalanceLog(
////                mobileInfo.getUserid(),
////                id,
////                result2,
////                1,
////                2,
////                10,
////                userPawn.getPawnTicketCode(),
////                platformImage,
////                userPawn.getBankCardName(),
////                userPawn.getBankCardNo(),
////                userPawn.getOrgId(),
////                userPawn.getOrgName(),
////                userPawn.getOrgTel());
//
//        //机构资金流水记录插入信息
////        orgBalanceLogService.updateOrgBalanceLog(
////                userPawn.getOrgId(),
////                result2,
////                2,
////                2,
////                userPawn.getPawnTicketCode(),
////                userPawn.getId(),
////                10,
////                userPawn.getBankCardName(),
////                userPawn.getBankCardNo(),
////                platformImage,mobileInfo.getUserid(),
////                userPawn.getUserName(),
////                userPawn.getUserPhone(),
////                userPawn.getPawnEndTime(),
////                pawnTime);
//
//        //典当记录表插入信息
////        pawnLogService.updatePawnlog(
////                userPawn.getGoodsId(),
////                userPawn.getUserId(),
////                userPawn.getOrgId(),
////                userPawn.getGoodsName(),
////                userPawn.getAuthPrice(),
////                userPawn.getCateCode()+"",
////                userPawn.getCateId(),
////                userPawn.getOrgName(),
////                result2,
////                pawnTime,
////                2,
////                userPawn.getUserName(),
////                userPawn.getBankCardName(),
////                userPawn.getBankCardNo());
//
//
////        if(userPawn.getLastPawnContinueId()!=null){
////            //如果已经续当，则update
////            PawnContinue c = pawnContinueService.selectByPrimaryKey(userPawn.getLastPawnContinueId());
////            c.setPawnLastEndTime(userPawn.getPawnEndTime());
////            c.setPawnEndTime(DateUtil.add(userPawn.getPawnEndTime(),pawnTime*15));
////            pawnContinueService.updateByPrimaryKeySelective(c);
////        }else{
////            int result3 = pawnContinueService.insert(pawnContinue);
////            if(result3 == 0){
////                throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
////            }
////        }
//        pawnContinue.setPawnLastEndTime(userPawn.getPawnEndTime());
//        pawnContinue.setPawnEndTime(DateUtil.add(userPawn.getPawnEndTime(),pawnTime*15));
//        int result3 = pawnContinueService.insert(pawnContinue);
//        if(result3 == 0){
//                throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//            }
//
//
//        //修改典当最新档期
////        UserPawn userPawn1 = userPawnService.selectByPrimaryKey(id);
////        userPawn1.setLastPawnMonth(pawnTime);
////        userPawn1.setLastPawnTime(DateUtil.add(new Date(),pawnTime*15));
////        userPawn1.setLastPawnContinueId(pawnContinue.getId());
////        userPawnService.updateByPrimaryKeySelective(userPawn1);
//
//        //map.put("last_pawn_month",pawnTime);
//        map.put("pawnTime",userPawn.getBeginPawnMonth()+pawnTime);
//        map.put("PayeeBankCardCode",userPawn.getBankCardNo());
//        map.put("PayeeBankName",userPawn.getBankCardName());
//        //续当的时候更新典当结束档期
//        map.put("pawn_end_time",DateUtil.dateToStr((DateUtil.add(userPawn.getPawnEndTime(),pawnTime*15)),"yyyy-MM-dd"));
//        map.put("last_pawn_continue_id",pawnContinue.getId());
//        int result = userPawnService.updatebyPawnContinue(map);
//
//
//        //int result = userPawnService.updateByExampleSelective(record,example);
//        if(result == 0){
//            throw new ApiException(MErrorEnum.OPERATION_FAILURE_ERROR);
//        }
//        Ret ret = new Ret();
//        ret.setCode(1);
//        String time = "";
//        if(pawnTime == 1){
//            //15天
//            time += 0.5;
//        }else{
//            //超过15天
//            if(pawnTime % 2 != 0){
//                //偶数
//                time += pawnTime/2;
//            }else{
//                time += pawnTime/2 + 1;
//            }
//        }
//        //推送
//        LogKit.debug("========================方法goPawnContinue 参数orgId："+userPawn.getOrgId()+"===================");
//        orgNotifyService.insertByTemplate(userPawn.getOrgId(), "1",PaidangMessage.USER_REPAWN_NOTIFY,
//                userPawn.getUserName(),time,result2.setScale(2)+"");
//        return ret;
//    }
//
//    /**
//     *用户余额日志插入信息
//     * @param userid
//     * @param totalMoeny  金额
//     * @param type 1增 2减
//     * @param item 项目 1典当  2续当  3赎当
//     * @param tradeType 0余额1支付宝2微信10线下银行卡
//     * @param platformImage 线下打款凭证
//     * @param bankName  银行名称
//     * @param bankCard  银行卡号
//     * @param orgId  机构id
//     * @param orgName  机构名称
//     * @param orgPhone  机构联系电话
//     * @param pawnTicketCode  当号
//     */
////    protected void SendMsgToUserBalanceLog(Integer userid, BigDecimal totalMoeny, int type, int item, int tradeType, String platformImage, String bankName, String bankCard, Integer orgId, String orgName, String orgPhone,String pawnTicketCode) {
////        UserBalanceLog userBalanceLog = new UserBalanceLog();
////        userBalanceLog.setUserId(userid);
////        userBalanceLog.setAmount(totalMoeny);
////        userBalanceLog.setType(type);
////        userBalanceLog.setItem(item+"");
////        userBalanceLog.setTradeType(tradeType);
////        userBalanceLog.setTradeTicket(platformImage);
////        userBalanceLog.setTradeCardBank(bankName);
////        userBalanceLog.setTradeCardCode(bankCard);
////        userBalanceLog.setOrgId(orgId);
////        userBalanceLog.setOrgName(orgName);
////        userBalanceLog.setOrgPhone(orgPhone);
////        userBalanceLog.setTradeCardCode(pawnTicketCode);
////        int result = userBalanceLogService.insert(userBalanceLog);
////        if(result == 0){
////            throw new ApiException(MErrorEnum.APPID_FAIL_ERROR);
////        }
////    }
//
//    /**
//     * 机构资金流水记录插入信息
//     * @param orgId  机构id
//     * @param totalMoeny    金额
//     * @param type  1支出  2收入
//     * @param item  1用户典当  2用户续当
//     * @param pawnTicketCode    当号
//     * @param fid  典当表id
//     * @param tradeType  0余额1支付宝2微信10线下银行卡 --10
//     * @param bankCardName  银行名称
//     * @param bankCardNo    银行卡
//     * @param platformImage     用户续当凭证
//     * @param userid    用户id
//     * @param userName  用户姓名
//     * @param userPhone 用户手机号
//     * @param date  续当开始时间--上一期结束时间
//     * @param pawnTime  续当时间
//     */
////    protected void SendMsgToOrgBalanceLog(Integer orgId, BigDecimal totalMoeny, int type, int item, String pawnTicketCode, Integer fid, int tradeType, String bankCardName, String bankCardNo, String platformImage, Integer userid, String userName, String userPhone, Date date, Integer pawnTime) {
////        OrgBalanceLog orgBalanceLog = new OrgBalanceLog();
////        orgBalanceLog.setOrgId(orgId);
////        orgBalanceLog.setMoney(totalMoeny);
////        orgBalanceLog.setType(type);
////        orgBalanceLog.setItem(item+"");
////        orgBalanceLog.setPawnCode(pawnTicketCode);
////        orgBalanceLog.setFid(fid);
////        orgBalanceLog.setTradeType(tradeType);
////        orgBalanceLog.setTradeCardBank(bankCardName);
////        orgBalanceLog.setTradeCardCode(bankCardNo);
////        orgBalanceLog.setTradeTicket(platformImage);
////        orgBalanceLog.setUserId(userid);
////        orgBalanceLog.setUserName(userName);
////        orgBalanceLog.setUserPhone(userPhone);
////        orgBalanceLog.setBeginTime(date);
////
////        //计算续当时间
////        int continueTime = pawnTime * 15;
////        orgBalanceLog.setEndTime(DateUtil.strToDate(DateUtil.getAddDaysDate(date,continueTime)));
////        int result = orgBalanceLogService.insert(orgBalanceLog);
////        if(result == 0){
////            throw new ApiException(MErrorEnum.APPID_FAIL_ERROR);
////        }
////    }
//
//    /**
//     * 典当记录表插入信息
//     * @param goodsId 藏品id
//     * @param userId  用户id
//     * @param orgId  机构id
//     * @param goodsName  藏品名称
//     * @param authPrice  鉴定价格
//     * @param cateCode  藏品类别code
//     * @param cateId  藏品类别id
//     * @param orgName  机构名称
//     * @param totalMoeny  金额
//     * @param pawnTime  典当时间份数
//     * @param type  1典当2续当3赎当4绝当5交易
//     * @param userName  用户姓名
//     * @param bankCardName  银行名称
//     * @param bankCardNo  交易所用银行卡卡号
//     */
////    protected void SendMsgToPawnLog(Integer goodsId, Integer userId, Integer orgId, String goodsName, BigDecimal authPrice, Integer cateCode, Integer cateId, String orgName, BigDecimal totalMoeny, Integer pawnTime, int type, String userName, String bankCardName, String bankCardNo) {
////        PawnLog pawnLog = new PawnLog();
////        pawnLog.setGoodsId(goodsId);
////        pawnLog.setUserId(userId);
////        pawnLog.setOrgId(orgId);
////        pawnLog.setGoodsName(goodsName);
////        pawnLog.setAuthPrice(authPrice);
////        pawnLog.setGoodsCate(cateCode+"");
////        pawnLog.setGoodsCateId(cateId);
////        pawnLog.setOrgName(orgName);
////        pawnLog.setMoney(totalMoeny);
////        pawnLog.setPawnMonth(pawnTime);
////        pawnLog.setType(type);
////        pawnLog.setUserName(userName);
////        pawnLog.setTradeCardBank(bankCardName);
////        pawnLog.setTradeCardCode(bankCardNo);
////        int result = pawnLogService.insert(pawnLog);
////        if(result == 0){
////            throw new ApiException(MErrorEnum.APPID_FAIL_ERROR);
////        }
////
////    }
//}
