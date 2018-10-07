package com.h5.action;

import com.api.view.myPawn.AppMyPawnConinue;
import com.api.view.myPawn.AppMyPawnGetBack;
import com.base.dao.model.Ret;
import com.base.exception.SystemException;
import com.base.util.DateUtil;
import com.h5.view.CertificateLogModel;
import com.h5.view.ContractInfo;
import com.item.dao.model.Code;
import com.item.dao.model.CodeExample;
import com.item.service.CodeService;
import com.item.service.SinglePageService;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.ExperterInfoEx;
import com.paidang.daoEx.model.UserPawnEx;
import com.paidang.service.*;
import com.paidang.utils.CostGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/m/pawn")
@Controller
public class H5CertificateController extends H5BaseController {
    @Autowired
    private CertificateService certificateService;
    @Autowired
    private CertificateLogService certificateLogService;
    @Autowired
    private PawnContinueService pawnContinueService;
    @Autowired
    private UserPawnService userPawnService;
    @Autowired
    private UserGoodsService userGoodsService;
    @Autowired
    private PawnOrgService pawnOrgService;
    @Autowired
    private SinglePageService singlePageService;
    @Autowired
    private  ExperterInfoService experterInfoService;
    @Autowired
    private CodeService codeService;

    private BigDecimal getRedeemOverrate(Integer pawnId){
        UserPawn record = userPawnService.selectByPrimaryKey(pawnId);
        if (record == null){
            throw new SystemException("参数错误");
        }
        //获取本次典当成交时约定的逾期滞纳利率
        BigDecimal redeem_overrate = record.getOverdueRate();
        if (redeem_overrate == null){
            throw new SystemException("缺少参数：逾期费率");
        }
        return redeem_overrate;
    }
    /**
     * 获取证书详情
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/getCertificate")
    public String toPage(Integer id, ModelMap map){
        if (null == id){
            return "common/404";
        }
        Certificate certificate = certificateService.selectByPrimaryKey(id);
        if(null == certificate){
            return "common/404";
        }
        CertificateLogExample certificateLogExample = new CertificateLogExample();
        certificateLogExample.createCriteria().andCertificateIdEqualTo(id);
        certificateLogExample.setOrderByClause("create_time desc");

        List<CertificateLog> certificateLog = certificateLogService.selectByExample(certificateLogExample);

        map.put("certificate",certificate);
        List<CertificateLogModel> ret = new ArrayList<>();
        for(CertificateLog ex : certificateLog){
            CertificateLogModel c = new CertificateLogModel();
            c.setId(ex.getId());
            c.setCertificateId(ex.getCertificateId());
            c.setLogTime(DateUtil.dateToStr(ex.getLogTime()).substring(0,10));
            c.setPrice(ex.getPrice());
            ret.add(c);

        }

        map.put("certificateLog",ret);
        return BASE_PATH+"/certificate/certificate-dt";
    }

    /**
     * 外观鉴定样式
     * @return
     */
    @RequestMapping("/getWatchdemo")
    public String getWatchdemo(Integer type){
        if(1 == type){
            //手表
            return BASE_PATH+"/watch/watchdemo";
        }else if(2 == type){
            //和田玉
            return BASE_PATH+"/watch/yudemo";
        }else{
            return "common/404";
        }

    }


    /**
     * 续当H5
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/getPawnContinue")
    public String getPawnContinue(Integer id,Integer userId, ModelMap map){
//判断用户是否有过续当，并且此次续当机构端没有确认收款
        PawnContinueExample example = new PawnContinueExample();
        example.createCriteria().andPawnIdEqualTo(id).andStateEqualTo(1);
        List<PawnContinue> list = pawnContinueService.selectByExample(example);
        if(list.size() != 0 && null != list){
            return "common/404";
        }


        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("id",id);
        map2.put("userId",userId);
        UserPawnEx ex = userPawnService.selectByPawnConinueDetail(map2);
        if(null == ex){
            return "common/404";
        }
        AppMyPawnConinue record = new AppMyPawnConinue();
        record.setTitle(ex.getGoodsName());
        record.setAuthPrice(ex.getAuthPrice()+"");
        record.setGoodsId(ex.getPawnTicketCode());
        record.setImages(ex.getImages());
        record.setOrgName(ex.getOrgName());
        record.setRate(ex.getRate()+"");
        record.setMoneyRate(ex.getMoneyRate()+"");
        record.setBeginTime(DateUtil.dateToStr(ex.getPawnBeginTime()));
        record.setEndTime(DateUtil.dateToStr(ex.getPawnEndTime()));
        record.setMoney(ex.getBeginMoney()+"");
        map.put("info",record);
        return BASE_PATH+"/pawn/continue";

    }

    /**
     * 用户赎当H5
     * @param user_id
     * @param id
     * @return
     */
    @RequestMapping("/H5GetMyGoods")
    public String H5GetMyGoods(Integer user_id,
                               Integer id,
                               ModelMap map2){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",id);
        map.put("user_id",user_id);
        UserPawnEx ex = userPawnService.selectPawningDetail(map);
        if(null == ex){
            return "common/404";
        }
        AppMyPawnGetBack record = new AppMyPawnGetBack();
        record.setId(ex.getId());
        record.setName(ex.getGoodsName());
        record.setAuthPrice(ex.getAuthPrice().toString());
        record.setImages(ex.getImages());
        record.setMoney(ex.getMoney()+"");
        record.setPawnTime(ex.getPawnTime());
        record.setRate(ex.getRate()+"");
        record.setMonetRate(ex.getMoneyRate()+"");
//        record.setRedeemRate(PaidangConst.REDEEM_OVERRATE+"");
        record.setRedeemRate(getRedeemOverrate(ex.getId())+"");
        record.setBeginDate(com.base.date.DateUtil.dateToStr(ex.getPawnBeginTime()));
        record.setEndDate(com.base.date.DateUtil.dateToStr(ex.getPawnEndTime()));

        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Date endDate= new Date();
        long outTime = endDate.getTime() - ex.getPawnEndTime().getTime();
        //综合利息
        //BigDecimal totalMoney = ex.getBeginMoney().multiply(ex.getRate()).divide(new BigDecimal(ex.getPawnTime())).divide(new BigDecimal(100));
        BigDecimal totalMoney = CostGenerator.getInterest(ex.getBeginMoney(),ex.getRate(),ex.getPawnTime());
        record.setTotalMoney(totalMoney+"");

        long day=(outTime/(24*60*60*1000));
        if(day > 0){
            record.setOutTime((int) Math.ceil(day));
            //逾期滞纳金
            //BigDecimal yqMoney = ex.getBeginMoney().multiply(PaidangConst.REDEEM_OVERRATE).divide(new BigDecimal(day)).divide(new BigDecimal(100)).multiply(new BigDecimal(15));
            BigDecimal yqMoney = CostGenerator.getOverdue(ex.getBeginMoney(),ex.getPawnEndTime(),getRedeemOverrate(ex.getId()));
            record.setRedeemOverdue(yqMoney+"");
            //合计
            record.setAllMoney(totalMoney.add(yqMoney).add(ex.getMoney())+"");
        }else{
            //合计
            record.setAllMoney(totalMoney.add(ex.getMoney())+"");
            record.setRedeemOverdue("0");
        }
        //record.setTotalBackMoney("");
        record.setBeginMoney(ex.getBeginMoney()+"");
        //record.setRedeemOverdue(ex.getRedeemOverdue()+"");
        record.setPayeeName(ex.getPayName());
        record.setPayeeBankName(ex.getPayBankName());
        record.setPayeeBankCardCode(ex.getPayBacnkCardCode());
        record.setPawnticketCode(ex.getPawnTicketCode());
        map2.put("info",record);
        return BASE_PATH+"/pawn/ransom";

    }

    /**
     * 合同详情
     * @param id
     * @param type
     * @return
     */
    @RequestMapping("/H5GetContract")
    public String H5GetContract(Integer id,
                               Integer type,
                               ModelMap map2){
        ContractInfo c = new ContractInfo();
        if(1 == type){
            //典当
            UserPawn ex = userPawnService.selectByPrimaryKey(id);
            c.setId(ex.getId());
            c.setCode(ex.getPawnTicketCode());
            c.setTitle(ex.getGoodsName());
            c.setUserName(ex.getUserName());
            c.setAuthPrice(userGoodsService.selectByPrimaryKey(ex.getGoodsId()).getAuthPrice()+"");
            c.setOrgName(ex.getOrgName());
            PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(ex.getOrgId());
            c.setLegalPerson(pawnOrg.getLegalPerson());
            c.setRegisteredCapital(pawnOrg.getRegisteredCapital());
            c.setAddress(ex.getOrgAddress());
            c.setMoney(ex.getBeginMoney()+"");
            c.setPawnBeginTime(DateUtil.dateToStr(ex.getPawnBeginTime()));
            c.setPawnEndTime(DateUtil.dateToStr(ex.getPawnEndTime()));
            c.setRate(ex.getRate()+"");
            c.setServerRate(ex.getMoneyRate()+"");
            c.setOverdueRate(ex.getOverdueRate()+"");
            c.setBankName(ex.getPayeeBankName());
            c.setBankCodeNo(ex.getPayeeBankCardCode());
            c.setTime(DateUtil.dateToStr(ex.getPawnBeginTime()));
            c.setState(-1);
        }else if(2 == type){
            //续当
            PawnContinue ex = pawnContinueService.selectByPrimaryKey(id);
            c.setId(ex.getId());
            c.setCode(ex.getPawnTicketCode());

            UserPawn userPawn = userPawnService.selectByPrimaryKey(ex.getPawnId());

            c.setTitle(userPawn.getGoodsName());
            c.setUserName(ex.getUserName());
            c.setAuthPrice(userGoodsService.selectByPrimaryKey(userPawn.getGoodsId()).getAuthPrice()+"");
            c.setOrgName(userPawn.getOrgName());
            PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(userPawn.getOrgId());
            c.setLegalPerson(pawnOrg.getLegalPerson());
            c.setRegisteredCapital(pawnOrg.getRegisteredCapital());
            c.setAddress(userPawn.getOrgAddress());
            c.setMoney(ex.getPawnMoney()+"");
            c.setPawnBeginTime(DateUtil.dateToStr(ex.getPawnLastEndTime()));
            c.setPawnEndTime(DateUtil.dateToStr(ex.getPawnEndTime()));
            c.setRate(userPawn.getRate()+"");
            c.setServerRate(userPawn.getMoneyRate()+"");
            c.setOverdueRate(userPawn.getOverdueRate()+"");
            c.setBankName(userPawn.getPayeeBankName());
            c.setBankCodeNo(userPawn.getPayeeBankCardCode());
            c.setTime(DateUtil.dateToStr(ex.getCreateTime()));
            if(4 == ex.getState()){
                //机构确认续当费用已经收到
                c.setState(1);
            }else{
                //机构未确认续当费用
                c.setState(0);
            }
        }
        map2.put("info",c);

        //法律条文链接
        CodeExample example = new CodeExample();
        example.createCriteria().andCodeLike("%@law");
        List<Code> list = codeService.selectByExample(example);
        if (list!=null && list.size()!=0){
            for (Code code:list){
                //典当管理法
                if (StringUtils.contains(code.getCode(),"ddgl")){
                    map2.put("ddglfUrl", code.getValue());
                }
                //合同法
                if (StringUtils.contains(code.getCode(),"htf")){
                    map2.put("htfUrl", code.getValue());
                }
                //民法总则
                if (StringUtils.contains(code.getCode(),"mfzz")){
                    map2.put("msfUrl", code.getValue());
                }
            }
        }
//        map2.put("htfUrl", ConstantsCode.SERVER_URL+"singlePage/htf");
//        map2.put("msfUrl", ConstantsCode.SERVER_URL+"singlePage/msf");
//        map2.put("ddglfUrl", ConstantsCode.SERVER_URL+"singlePage/ddgl");

        return BASE_PATH+"/contract/contract";

    }

    /**
     * 专家鉴定页面
     * @param id
     * @return
     */
    @RequestMapping("/H5GetExperterInfo")
    public String H5GetExperterInfo(Integer id,
                                    ModelMap map){
        //ExperterInfo info = experterInfoService.selectByPrimaryKey(id);
        ExperterInfoEx info = experterInfoService.selectH5List(id);
        map.put("info",info);
        return BASE_PATH+"/experter/appraisal";
    }

    //专家鉴定保存
    @RequestMapping("/saveExperterInfo")
    @ResponseBody
    public Ret saveExperterInfo(ExperterInfo experterInfo){
        ExperterInfo experterInfo2 = experterInfoService.selectByPrimaryKey(experterInfo.getId());
        if(1 == experterInfo2.getState()){
            return new Ret(-1,"鉴定结果不可修改 ");
        }
        experterInfo.setState(1);
        experterInfoService.updateByPrimaryKeySelective(experterInfo);
        return new Ret(1,"鉴定成功");
    }

    //在线鉴定简介图片
    @RequestMapping("/getReference")
    public String  getReference(Integer code,ModelMap map){

        map.put("code",code);
        return BASE_PATH+"/introduce/reference";
    }

    //典当须知
    @RequestMapping("/popup")
    public String  getPopup(){
        return BASE_PATH+"/popup/popup";
    }

    /**
     * 注册协议
     * @return
     */
    @RequestMapping("/getRegistrations")
    public String getRegistrations(){
        return BASE_PATH+"/registration";
    }
}
