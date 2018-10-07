package com.h5.action;

import com.base.dao.model.Ret;
import com.base.date.DateUtil;
import com.base.util.JSONUtils;
import com.h5.view.PawnTicketModel;
import com.h5.view.RepawnTicketModel;
import com.paidang.daoEx.model.PawnContinueEx;
import com.paidang.daoEx.model.UserPawnEx;
import com.paidang.service.PawnContinueService;
import com.paidang.service.UserPawnService;
import com.util.NumberToCN;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2017/11/9.
 *
 * 查看当票
 *
 */
@RequestMapping("/m/pawn")
@Controller
public class PawnTicketController extends H5BaseController {

    @Autowired
    UserPawnService userPawnService;
    @Autowired
    PawnContinueService pawnContinueService;

    @RequestMapping("/toPawnTicket/{id}")
    public String toPage(@PathVariable(value = "id") String pawnId, ModelMap map){
        map.put("pawnId",pawnId);
        return BASE_PATH+"/pawnTicket";
    }

/*    @RequestMapping("/toPawnTicket")
    public void toView(HttpServletRequest request,HttpServletResponse response){
       //String pawnId = request.getParameter("pawnId");
        try {
            request.getRequestDispatcher("/WEB-INF/page/h5/pawnTicket.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @RequestMapping("/loadTicketData")
    @ResponseBody
    public String loadTicketData(String pawnId){
        if (StringUtils.isEmpty(pawnId)){
            return JSONUtils.serialize(new Ret(0,"典当id不能为空"));
        }
        Integer pid ;
        try{
            pid = Integer.valueOf(pawnId);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return JSONUtils.serialize(new Ret(0,"请输入正确的典当id"));
        }
        UserPawnEx userPawnEx = userPawnService.getUserPawnExById(pid.toString());
        if (userPawnEx == null){
            return JSONUtils.serialize(new Ret(0,"请输入正确的典当id"));
        }
        List<Object> ret = new ArrayList<>();
        BigDecimal beginMoney = userPawnEx.getBeginMoney();
        BigDecimal pawnMoney = userPawnEx.getPawnMoney();// 首期综合费
        BigDecimal userMoney;
        PawnTicketModel pawnTicketModel = new PawnTicketModel();
        pawnTicketModel.setPawnTicketCode(userPawnEx.getPawnTicketCode()!=null?userPawnEx.getPawnTicketCode():"");
        pawnTicketModel.setAuthPrice(userPawnEx.getAuthPrice()!=null?userPawnEx.getAuthPrice().toString():"");
        pawnTicketModel.setAuthPriceTest(userPawnEx.getAuthPrice()!=null?userPawnEx.getAuthPrice().toString():"");
        pawnTicketModel.setBusinessLicense(userPawnEx.getOrgLicense()!=null?userPawnEx.getOrgLicense():"");
        pawnTicketModel.setContactor(userPawnEx.getUserName()!=null?userPawnEx.getUserName():"");
        pawnTicketModel.setEquivalentRatio("100%");
        pawnTicketModel.setGoodsName(userPawnEx.getGoodsName1()!=null?userPawnEx.getGoodsName1():"");
        pawnTicketModel.setLoanMoney(beginMoney!=null?beginMoney.toString():"");
        pawnTicketModel.setPawnMoney(pawnMoney!=null?pawnMoney.toString():"");
        if(beginMoney!=null && pawnMoney!=null){
            userMoney = beginMoney.subtract(pawnMoney);
            pawnTicketModel.setUserMoney(userMoney.toString());
            pawnTicketModel.setUserMoneyCN(NumberToCN.number2CNMontrayUnit(userMoney));
        }else{
            pawnTicketModel.setUserMoney("");
            pawnTicketModel.setUserMoneyCN("");
        }
        pawnTicketModel.setRate(userPawnEx.getRate()!=null?userPawnEx.getRate().toString():"");
        pawnTicketModel.setMoneyRate(userPawnEx.getMoneyRate()!=null?userPawnEx.getMoneyRate().toString():"");
        pawnTicketModel.setOrgName(userPawnEx.getOrgName()!=null?userPawnEx.getOrgName():"");
        pawnTicketModel.setOrgAddr(userPawnEx.getOrgAddress()!=null?userPawnEx.getOrgAddress():"");
        pawnTicketModel.setOrgTel(userPawnEx.getOrgTel()!=null?userPawnEx.getOrgTel():"");
        pawnTicketModel.setBusinessLicense(userPawnEx.getOrgLicense()!=null?userPawnEx.getOrgLicense():"");
        pawnTicketModel.setOrgSeal(userPawnEx.getOrgSeal()!=null?userPawnEx.getOrgSeal():"");
        pawnTicketModel.setPawnerName(userPawnEx.getUserName()!=null?userPawnEx.getUserName().toString():"");
        pawnTicketModel.setContactor(userPawnEx.getUserName()!=null?userPawnEx.getUserName().toString():"");
        pawnTicketModel.setPawnerTel(userPawnEx.getUserPhone()!=null?userPawnEx.getUserPhone().toString():"");
        pawnTicketModel.setPawnerAddr(userPawnEx.getUserAddress()!=null?userPawnEx.getUserAddress():"");
        pawnTicketModel.setPawnerIdCard(userPawnEx.getUserIdCard()!=null?userPawnEx.getUserIdCard():"");
        pawnTicketModel.setPawnerCert("身份证");
        pawnTicketModel.setPawnBeginTime(userPawnEx.getPawnBeginTime()!=null? DateUtil.format(userPawnEx.getPawnBeginTime(),"yyyy-MM-dd HH:mm"):"");
        pawnTicketModel.setPawnEndTime(userPawnEx.getPawnEndTime()!=null?DateUtil.format(userPawnEx.getPawnEndTime(),"yyyy-MM-dd HH:mm"):"");
        pawnTicketModel.setBeginPawnEndTime(userPawnEx.getBeginPawnEndTime()!=null?DateUtil.format(userPawnEx.getBeginPawnEndTime(),"yyyy-MM-dd HH:mm"):"");
        pawnTicketModel.setLoanMoneyCN(beginMoney!=null?NumberToCN.number2CNMontrayUnit(beginMoney):"");
        pawnTicketModel.setPawnMoneyCN(pawnMoney!=null?NumberToCN.number2CNMontrayUnit(pawnMoney):"");
        ret.add(pawnTicketModel);
        //所有续当票
        List<PawnContinueEx> list = pawnContinueService.getRepawnTickInfo(pawnId);
        List<RepawnTicketModel> repanRetList = new ArrayList<>();
        if (list.size() != 0){
            for (int i = 0 ; i < list.size() ; i++){
                RepawnTicketModel repawnTicketModel = new RepawnTicketModel();
                repawnTicketModel.setContactor(list.get(i).getUserName()!=null?list.get(i).getUserName():"");
                repawnTicketModel.setMoneyRate(list.get(i).getMoneyRate()!=null?list.get(0).getMoneyRate().toString():"");
                repawnTicketModel.setRate(list.get(i).getRate()!=null?list.get(i).getRate().toString():"");
                repawnTicketModel.setLoanMoney(list.get(i).getLoanMoney()!=null?list.get(i).getLoanMoney().toString():"");
                repawnTicketModel.setCost(list.get(i).getPawnMoney()!=null?list.get(i).getPawnMoney().toString():"");
                repawnTicketModel.setMoneyCost(list.get(i).getPawnInterest()!=null?list.get(i).getPawnInterest().toString():"");
                repawnTicketModel.setOrgName(list.get(i).getOrgName()!=null?list.get(i).getOrgName():"");
                repawnTicketModel.setOrgSeal(list.get(i).getOrgSeal()!=null?list.get(i).getOrgSeal():"");
                repawnTicketModel.setPawnerName(list.get(i).getPawnerName()!=null?list.get(i).getPawnerName():"");
                repawnTicketModel.setPawnTicketCode(list.get(i).getPawnTicketCode()!=null?list.get(i).getPawnTicketCode():"");
                repawnTicketModel.setRepawnBeginTime(list.get(i).getPawnLastEndTime()!=null?DateUtil.format(list.get(i).getPawnLastEndTime(),"yyyy-MM-dd HH:mm"):"");
                repawnTicketModel.setRepawnEndTime(list.get(i).getPawnEndTime()!=null?DateUtil.format(list.get(i).getPawnEndTime(),"yyyy-MM-dd HH:mm"):"");
                repawnTicketModel.setLoanMoneyCN(list.get(i).getLoanMoney()!=null?NumberToCN.number2CNMontrayUnit(list.get(i).getLoanMoney()):"");
                repawnTicketModel.setCostCN(list.get(i).getPawnMoney()!=null?NumberToCN.number2CNMontrayUnit(list.get(i).getPawnMoney()):"");
                repawnTicketModel.setMoneyCostCN(list.get(i).getPawnInterest()!=null?NumberToCN.number2CNMontrayUnit(list.get(i).getPawnInterest()):"");
                if (list.get(i).getPawnMoney()==null || list.get(i).getPawnInterest()==null){
                    repawnTicketModel.setRepawnTotal("");
                    repawnTicketModel.setRepawnTotalCN("");
                }else {
                    BigDecimal repawnTotal = list.get(i).getPawnMoney().add(list.get(i).getPawnInterest());
                    repawnTicketModel.setRepawnTotal(repawnTotal.toString());
                    repawnTicketModel.setRepawnTotalCN(NumberToCN.number2CNMontrayUnit(repawnTotal));
                }
                repanRetList.add(repawnTicketModel);
            }
            ret.add(repanRetList);
        }
        return JSONUtils.serialize(ret);
    }



}
