package com.paidang.action;

import com.api.view.orgDeadPawnage.DeadPawnDetail;
import com.api.view.orgHome.myPawners.MyPawnerDetail;
import com.api.view.orgHome.myPawners.PawnedDetail;
import com.api.view.orgHome.myPawners.PawnedMini;
import com.api.view.orgRedeem.RedeemDetail;
import com.api.view.orgRepawn.RepawnDetail;
import com.api.view.orgRepawn.RepawnMini;
import com.base.action.CoreController;
import com.base.date.DateUtil;
import com.base.dialect.PaginationSupport;
import com.base.exception.SystemException;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.User;
import com.item.service.UserService;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.UserPawnEx;
import com.paidang.service.*;
import com.paidang.utils.CostGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

import static com.paidang.utils.CostGenerator.getInterest;
import static com.paidang.utils.CostGenerator.getOverdue;

/**
@author sun
*/
@RequestMapping("userPawn")
@Controller
@LoginFilter
public class UserPawnController extends CoreController{

    @Autowired
    private UserPawnService userPawnService;
    @Autowired
	private PawnContinueService pawnContinueService;
    @Autowired
	private UserGoodsService userGoodsService;
    @Autowired
	private UserService userService;
    @Autowired
	private UserAddressService userAddressService;
    @Autowired
	private PawnOrgService pawnOrgService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserPawnExample example = new UserPawnExample();
    	
    	List<UserPawn> list = userPawnService.selectByExample(example);
      	return page(list);
    }

    //宝祥兜底
	@RequestMapping("/baoxiangGet")
	@ResponseBody
	public String baoxiangGet(Integer page, Integer rows, String pawnTicketCode){
		PaginationSupport.byPage(page, rows);
//		UserPawnExample example = new UserPawnExample();
//
//		if(null != pawnTicketCode){
//			example.createCriteria().andStateEqualTo(5).andPawnTicketLike("%"+pawnTicketCode+"%");
//		}else {
//			example.createCriteria().andStateEqualTo(5);
//		}
//
//		example.setOrderByClause("create_time desc");
//		List<UserPawn> list = userPawnService.selectByExample(example);
		Map<String, Object> map = new HashMap<>();
		map.put("pawnTicketCode",pawnTicketCode);
		List<UserPawnEx> list = userPawnService.selectBxGet(map);
		return page(list);
	}
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserPawn userPawn){
    	if (userPawn.getId() == null){
    		userPawnService.insert(userPawn);
    	}else{
    		userPawnService.updateByPrimaryKeySelective(userPawn);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserPawn userPawn = userPawnService.selectByPrimaryKey(id);
       	return ok(userPawn);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userPawnService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

    /*
    * 机构后台
    */
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

	//我的当户列表(本机构所属当户)
	@RequestMapping("/getMypawners")
	@ResponseBody
	public String getMypawners(Integer page, Integer rows){
		String orgId = getSessionParameter("id");
		PaginationSupport.byPage(page, rows);
		List<UserPawnEx> list = userPawnService.getMyPawnersList(orgId);
		return page(list);
	}

	// 当户的当品列表
	@RequestMapping("/getPawnerzPawnList")
	@ResponseBody
	public String getPawnerzPawnList(Integer page, Integer rows,String pawnerId){
		String orgId = getSessionParameter("id");
		PaginationSupport.byPage(page, rows);
		List<UserPawnEx> userPawnExList = userPawnService.getPawnerzPawnList(orgId.toString(),pawnerId.toString());
		List<PawnedMini> pawnedMiniList = new ArrayList<>();
		for (UserPawnEx element:userPawnExList){
			PawnedMini pawnedMini = new PawnedMini();
			pawnedMini.setId(element.getId().toString());//典当表id
			pawnedMini.setTitle(element.getGoodsName1());
			pawnedMini.setPawnTicketCode(element.getPawnTicketCode()!=null?element.getPawnTicketCode():"");
			pawnedMini.setAuthPrice(element.getAuthPrice()!=null?element.getAuthPrice().toString():"");
			pawnedMini.setImage(element.getImages());
			pawnedMini.setLoanMoney(element.getBeginMoney()!=null?element.getBeginMoney().toString():"");
			Map<String,String> map = userPawnService.getPawnState(element.getId());
			if (map == null){
				return msg(-1,"系统出错了，请联系开发人员");
			}
			if (map.get("pawnState").equals("0")){
				pawnedMini.setPawnState("0");
				pawnedMini.setDays(map.get("days"));
			}
			if (map.get("pawnState").equals("1")){
				pawnedMini.setPawnState("1");
				pawnedMini.setDays(map.get("days"));
			}
			if (map.get("pawnState").equals("2")){
				pawnedMini.setPawnState("2");
			}
			pawnedMiniList.add(pawnedMini);
		}
		MyPawnerDetail myPawnerDetail = new MyPawnerDetail();
		myPawnerDetail.setList(pawnedMiniList);
		return page(pawnedMiniList);
	}

	//获取当户某一当品详情
	@RequestMapping("/getPawnerPawnDetail")
	@ResponseBody
	public String getPawnerPawnDetail(String pawnId){
		if(StringUtils.isEmpty(pawnId)){
			return msg(-1,"典当id为空");
		}
		UserPawnEx userPawnEx = userPawnService.getUserPawnExById(pawnId);
		if (userPawnEx == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		PawnedDetail pawnedDetail = new PawnedDetail();
		pawnedDetail.setId(userPawnEx.getId().toString());//典当表id
		pawnedDetail.setCollecterId(userPawnEx.getUserId().toString());//当户id
		pawnedDetail.setPawnTicketCode(userPawnEx.getPawnTicketCode()!=null?userPawnEx.getPawnTicketCode():"");//当号
		pawnedDetail.setTitle(userPawnEx.getGoodsName1()!=null?userPawnEx.getGoodsName1():"");//当品名称
		pawnedDetail.setImage(userPawnEx.getImages()!=null?userPawnEx.getImages():"");//当品图片
		pawnedDetail.setAuthPrice(userPawnEx.getAuthPrice()!=null?userPawnEx.getAuthPrice().toString():"");
		BigDecimal moneyRate = userPawnEx.getMoneyRate();//赎当利率
		if (moneyRate == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		pawnedDetail.setMoneyRate(moneyRate.toString());
		pawnedDetail.setRate(userPawnEx.getRate()!=null?userPawnEx.getRate().toString():"");//综合利率
		//贷款开始时间
		pawnedDetail.setLoanBeginTime(userPawnEx.getPawnBeginTime()!=null?DateUtil.format(userPawnEx.getPawnBeginTime(),"yyyy-MM-dd HH:mm"):"");
		//用户地址
		String pawnerAddress="";
		UserAddressExample userAddressExample = new UserAddressExample();
		userAddressExample.createCriteria().andUserIdEqualTo(userPawnEx.getUserId()).andIsDefaultEqualTo(1);
		List<UserAddress> userAddresses = userAddressService.selectByExample(userAddressExample);
		if(userAddresses.size() != 0){
			pawnerAddress = userAddresses.get(0).getAddress()!=null&&userAddresses.get(0).getArea()!=null?userAddresses.get(0).getArea()+userAddresses.get(0).getAddress():"";
		}
		pawnedDetail.setPawnerAddress(pawnerAddress);
		pawnedDetail.setPawnerName(userPawnEx.getUserName()!=null?userPawnEx.getUserName():"");
		pawnedDetail.setPawnerTelNum(userPawnEx.getUserPhone()!=null?userPawnEx.getUserPhone():"");
		//本金
		BigDecimal beginMoney = userPawnEx.getBeginMoney();
		if (beginMoney == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		pawnedDetail.setLoanMoney(beginMoney.toString());
		//首期综合费
		BigDecimal first = userPawnEx.getPawnMoney();
		if (first == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		pawnedDetail.setFirstCost(first.toString());
		//已发放当金 = 本金 - 首期综合费
		if(beginMoney!=null && first!=null){
			pawnedDetail.setUserMoney(beginMoney.subtract(first).toString());
		}else{
			pawnedDetail.setUserMoney("");
		}

		BigDecimal redeem_interest ;//赎当利息
		BigDecimal overdue;//逾期滞纳金
		BigDecimal payBack ;//到期应还款总额
		PawnContinueExample example = new PawnContinueExample();
		example.createCriteria().andPawnIdEqualTo(userPawnEx.getId()).andStateEqualTo(4);
		example.setOrderByClause("create_time desc");
		//被机构确认的续当
		List<PawnContinue> confirmedContinueList = pawnContinueService.selectByExample(example);
		if (confirmedContinueList.size() == 0){
			//已缴综合费(页面)
			pawnedDetail.setCost(first.toString());
			//赎当利息
			redeem_interest = CostGenerator.getInterest(beginMoney,moneyRate,userPawnEx.getBeginPawnMonth());
			//逾期费
			overdue = CostGenerator.getOverdue(beginMoney,userPawnEx.getBeginPawnEndTime(),getRedeemOverrate(userPawnEx.getId()));
			//到期应还款额
			payBack = beginMoney.add(redeem_interest).add(overdue);
			//页面应还款日期,即典当结束日期
			pawnedDetail.setLoanCurrentRepayTime(userPawnEx.getPawnEndTime()!=null?DateUtil.format(userPawnEx.getPawnEndTime(),"yyyy-MM-dd HH:mm"):"");
			//当品状态和到期/逾期天数
			Map<String,String> map =  userPawnService.getPawnState(userPawnEx.getId());
			if (map == null){
				return msg(-1,"系统出错了，请联系开发人员");
			}
			if (map.get("pawnState").equals("0")){
				pawnedDetail.setPawnState("0");
				pawnedDetail.setDays(map.get("days"));
			}
			if (map.get("pawnState").equals("1")){
				pawnedDetail.setPawnState("1");
				pawnedDetail.setDays(map.get("days"));
			}
			if (map.get("pawnState").equals("2")){
				pawnedDetail.setPawnState("2");
			}
		}else{
				PawnContinue newestOne = confirmedContinueList.get(0);
				//已缴综合费(页面)
				pawnedDetail.setCost(newestOne.getPawnMoney()!=null?newestOne.getPawnMoney().toString():"");
				//赎当利息
				redeem_interest = CostGenerator.getInterest(beginMoney,moneyRate,newestOne.getPawnMonth());
				//逾期费
				overdue = CostGenerator.getOverdue(beginMoney,newestOne.getPawnEndTime(),getRedeemOverrate(userPawnEx.getId()));
				//到期应还款额
				payBack = beginMoney.add(redeem_interest).add(overdue);
				//页面应还款日期,即典当结束日期
				pawnedDetail.setLoanCurrentRepayTime(newestOne.getPawnEndTime()!=null?DateUtil.format(newestOne.getPawnEndTime(),"yyyy-MM-dd HH:mm"):"");
				//当品状态和到期/逾期天数
				Map<String,String> map =  userPawnService.getPawnState(newestOne.getPawnId());
				if (map == null){
					return msg(-1,"系统出错了，请联系开发人员");
				}
				if (map.get("pawnState").equals("0")){
					pawnedDetail.setPawnState("0");
					pawnedDetail.setDays(map.get("days"));
				}
				if (map.get("pawnState").equals("1")){
					pawnedDetail.setPawnState("1");
					pawnedDetail.setDays(map.get("days"));
				}
				if (map.get("pawnState").equals("2")){
					pawnedDetail.setPawnState("2");
			}
		}
		pawnedDetail.setMoneyCost(redeem_interest.toString());
		pawnedDetail.setPayBack(payBack.toString());
		return ok(pawnedDetail);
	}


	//获取我的续当列表
	@RequestMapping("/getRepawnList")
	@ResponseBody
	public String getRepawnList(Integer page, Integer rows){
		PaginationSupport.byPage(page, rows);
		String orgId = getSessionParameter("id");
		//获得本机构所有正处于典当中的记录
		UserPawnExample userPawnExample = new UserPawnExample();
		userPawnExample.createCriteria().andOrgIdEqualTo(Integer.valueOf(orgId)).andStateEqualTo(2);
		List<UserPawn> userPawnList = userPawnService.selectByExample(userPawnExample);
		List<RepawnMini> retList = new ArrayList<>();
		for (UserPawn userPawn : userPawnList){
			RepawnMini repawnMini = new RepawnMini();
			if(userPawn.getGoodsId()==null){
				throw new SystemException("当品id为空");
			}
			Integer goodId = userPawn.getGoodsId();
			UserGoods userGoods = userGoodsService.selectByPrimaryKey(goodId);
			String pawnTicketCode = StringUtils.isNotEmpty(userPawn.getPawnTicketCode())?userPawn.getPawnTicketCode():"";
			String goodName = StringUtils.isNotEmpty(userGoods.getName())?userGoods.getName():"";
			String authPrice = userGoods.getAuthPrice()!=null?userGoods.getAuthPrice().toString():"";
			String images = StringUtils.isNotEmpty(userGoods.getImages())?userGoods.getImages():"";
			repawnMini.setId(userPawn.getId().toString());//典当表id
			repawnMini.setGoodsid(userPawn.getGoodsId().toString());//当品id
			repawnMini.setGoodsName(goodName);//当品名称
			repawnMini.setAuthPrice(authPrice);//鉴定价格
			//已贷金额(本金)
			repawnMini.setLoanMoney(userPawn.getBeginMoney()!=null?userPawn.getBeginMoney().toString():"");
			//已发放当金 = 本金 - 首期综合费 若数据库已保存则取数据库，否则计算得到
			String userMoney = "";
			boolean isGo = true;
			if(userPawn.getUserMoney()!=null){
				userMoney = userPawn.getUserMoney().toString();
				isGo = false;
			}else if (isGo && userPawn.getPawnMoney()!=null && userPawn.getBeginMoney()!=null){
				BigDecimal um = userPawn.getBeginMoney().subtract(userPawn.getPawnMoney());
				if(um.compareTo(new BigDecimal("0"))== -1){
					userMoney = "";
				}else{
					userMoney = um.toString();
				}
			}
			repawnMini.setUserMoney(userMoney);//已发放当金
			repawnMini.setPawnCode(pawnTicketCode);//当号
			repawnMini.setImages(images);//图
			//列表分家 pawnId的续当所有记录（申请中的和确认的），按create_time降序排列，取第一个即为最新提交的续当申请信息
			PawnContinueExample pawnContinueExample = new PawnContinueExample();
			pawnContinueExample.createCriteria().andPawnIdEqualTo(userPawn.getId());
			pawnContinueExample.setOrderByClause("create_time desc");
			List<PawnContinue> pawnContinueList = pawnContinueService.selectByExample(pawnContinueExample);
			if (pawnContinueList.size() == 0){ //此pawnid没有续当申请
				//set 典当日期至字段
				repawnMini.setDateRepawnTo(userPawn.getBeginPawnEndTime()!=null?DateUtil.format(userPawn.getBeginPawnEndTime(),"yyyy-MM-dd hh:mm"):"");
			}else{
				PawnContinue newestOne = pawnContinueList.get(0);//时间倒序取最新一次续当申请
				if (newestOne.getState() == 1){ //申请中
					//最新续当id，set了repawnId后点击进入详情页面与未set的不同
					repawnMini.setRepawnId(newestOne.getId().toString());
					//续当日期至
					repawnMini.setDateRepawnTo(newestOne.getPawnEndTime()!=null?DateUtil.format(newestOne.getPawnEndTime(),"yyyy-MM-dd hh:mm"):"");
				}else{
					repawnMini.setRepawnId(newestOne.getId().toString());
					repawnMini.setDateRepawnTo(newestOne.getPawnEndTime()!=null?DateUtil.format(newestOne.getPawnEndTime(),"yyyy-MM-dd hh:mm"):"");
				}
			}
			retList.add(repawnMini);
		}
		return page(retList);
	}

	//获取续当当品详情
	@RequestMapping("/repawnDetail")
	@ResponseBody
	public String getRepawnDetail(String pawnId,String repawnId){
		Integer pid;
		Integer rpId;
		if(StringUtils.isEmpty(pawnId)){
			return msg(-1,"典当id为空");
		}
		try{
			pid = Integer.valueOf(pawnId);
		}catch (NumberFormatException e){
			e.printStackTrace();
			return msg(-1,"输入字符不合法");
		}
		UserPawn userPawn = userPawnService.selectByPrimaryKey(pid);
		if (userPawn == null) {
			return msg(-1,"系统出错了，请联系开发人员");
		}
		Integer goodId = userPawn.getGoodsId();
		if(goodId == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		/*User user = userService.selectByPrimaryKey(mobileInfo.getUserid());//登陆机构端用户
		if(user == null){
			throw new ApiException(MEnumError.USER_NOEXIST_ERROR);
		}*/
		UserGoods userGoods = userGoodsService.selectByPrimaryKey(goodId);
		if (userGoods == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		/*//取机构的银行卡，竞拍判断有没有绑定，没有跳转绑卡页面，机构卡现在只能有一张。
		OrgBankCardExample example = new OrgBankCardExample();
		example.createCriteria().andOrgIdEqualTo(user.getOrgId()).andBankCardTypeEqualTo(1);
		List<OrgBankCard> cards = orgBankCardService.selectByExample(example);
		if (cards.size() == 0){
			throw new ApiException("该机构还没有绑定自己的银行卡，请先去绑卡");
		}
		OrgBankCard card = cards.get(0);*/
		String goodName = StringUtils.isNotEmpty(userGoods.getName())?userGoods.getName():"";
		String pawnTicketCode = StringUtils.isNotEmpty(userPawn.getPawnTicketCode())?userPawn.getPawnTicketCode():"";
		String authPrice = userGoods.getAuthPrice()!=null?userGoods.getAuthPrice().toString():"";
		String images = StringUtils.isNotEmpty(userGoods.getImages())?userGoods.getImages():"";

		Integer pawnerUserId = userPawn.getUserId();//当户id
		if(pawnerUserId==null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		User pawner = userService.selectByPrimaryKey(pawnerUserId);//当户
		if(pawner == null){
			return msg(-1,"系统出错了，请联系开发人员");
		}
		//详情用户地址
		String pawnerAddress="";
		UserAddressExample userAddressExample = new UserAddressExample();
		userAddressExample.createCriteria().andUserIdEqualTo(pawnerUserId).andIsDefaultEqualTo(1);
		List<UserAddress> userAddresses = userAddressService.selectByExample(userAddressExample);
		if(userAddresses.size() != 0){
			pawnerAddress = userAddresses.get(0).getAddress()!=null&&userAddresses.get(0).getArea()!=null?userAddresses.get(0).getArea()+userAddresses.get(0).getAddress():"";
		}
//      String pawnerAddress = userPawn.getUserAddress()!=null?userPawn.getUserAddress():"";
		String pawnerName = pawner.getName()!=null?pawner.getName():"";
		String pawnerTelNum = StringUtils.isNotEmpty(pawner.getPhone())?pawner.getPhone():pawner.getAccount();
		String loanMoney = userPawn.getBeginMoney()!=null?userPawn.getBeginMoney().toString():"";//本金
		String firstCost = userPawn.getPawnMoney()!=null?userPawn.getPawnMoney().toString():"";//首期综合费
		String userMoney = "";//本金-综合费实际贷给用户金额
		String bankCardName;  // 收款银行卡银行名称
		String bankCardUserName ;//收款人
		String bankCardNo;       //收款银行卡
		String currentPayTicket;//打款凭证（机构打款给用户，或者用户打款给机构）
		boolean isGo = true;
		//已发放当金 = 贷款金额 - 首期综合费 若数据库已保存则取数据库，否则计算得到
		if(userPawn.getUserMoney()!=null){
			userMoney = userPawn.getUserMoney().toString();
			isGo = false;
		}else if (isGo && userPawn.getPawnMoney()!=null && userPawn.getBeginMoney()!=null){
			BigDecimal um = userPawn.getBeginMoney().subtract(userPawn.getPawnMoney());
			if(um.compareTo(new BigDecimal("0"))== -1){
				userMoney = "";
			}else{
				userMoney = um.toString();
			}
		}
		String rate = userPawn.getRate()!=null?userPawn.getRate().toString():"";// 综合费率
		String moneyRate = userPawn.getMoneyRate()!=null?userPawn.getMoneyRate().toString():"";//赎当利率
		// 当前应还款日期是指现在所处当期结束日期
		Date pawn_begin_time = userPawn.getPawnBeginTime();
		Date pawn_end_time = userPawn.getPawnEndTime();
		String pawnBeginTime = DateUtil.dateToStr(pawn_begin_time,"yyyy-MM-dd HH:mm");//典当开始
		String pawnEndTime =  DateUtil.dateToStr(pawn_end_time,"yyyy-MM-dd HH:mm");//典当结束

		BigDecimal preInterest; //上期利息费 由用户端计算并写入续当表
		BigDecimal cost ;    //下个续当周期综合费 由用户端计算并写入续当表
		BigDecimal overdue ; //逾期滞纳金 由用户端计算并写入续当表
      /*
        到期应还款额度payBack = 本金 + 滞纳金（若有）+当前当期对应的赎当利息【赎当利息=本金*月数或者天数(是指本当期包含月/天数，并不包括可能的下一个续当周期)*赎当利率】
        如果时间未到本当期截止时间而用户赎当，也按照当期包含天数计算赎当利息
        */
		String payBack;
		BigDecimal repawnMoney;
		BigDecimal loan_money = new BigDecimal(loanMoney);//本金
		RepawnDetail repawnDetail = new RepawnDetail();

        /*//pawnId的续当所有记录（申请中的和确认的），按create_time降序排列，取第一个即为最新提交的续当申请信息
        PawnContinueExample pawnContinueExample = new PawnContinueExample();
        pawnContinueExample.createCriteria().andPawnIdEqualTo(Integer.valueOf(pawnId));
        pawnContinueExample.setOrderByClause("create_time desc");
        List<PawnContinue> pawnContinueList = pawnContinueService.selectByExample(pawnContinueExample);
        Integer times = pawnContinueService.getRepawnTimes(userPawn.getId());//办理过多少次续当，set到返回model*/

		if(StringUtils.isEmpty(repawnId)){//从未续当过
			//计算赎当利息，如果从未续当过，当前所处当期即为首次办理典当的当期，赎当利息需要机构端来计算
			if(userPawn.getBeginPawnMonth()==null){//初始当期
				return msg(-1,"系统出错了，请联系开发人员");
			}
			Integer beginPawnMonth = userPawn.getBeginPawnMonth();//初次典当当期
			BigDecimal redeem_interest = getInterest(loan_money,userPawn.getMoneyRate(),beginPawnMonth);
			//计算滞纳金
			overdue = getOverdue(loan_money,pawn_end_time,getRedeemOverrate(userPawn.getId())) ;
			BigDecimal redeem_money = loan_money.add(redeem_interest).add(overdue);
			payBack = redeem_money.toString();
			repawnDetail.setPayBack(payBack);
			repawnDetail.setFirstCost(firstCost);//典当处理页面：本期综合利息字段，实际上是首期综合费
			repawnDetail.setLoanCurrentRepayTime(DateUtil.dateToStr(userPawn.getBeginPawnEndTime(),"yyyy-MM-dd HH:mm"));
			//首次典当的收款人，这个收款人是用户
			bankCardName = userPawn.getPayeeBankName()!=null?userPawn.getPayeeBankName():"";
			bankCardUserName = userPawn.getPayeeName()!=null?userPawn.getPayeeName():"";
			bankCardNo = userPawn.getPayeeBankCardCode()!=null?userPawn.getPayeeBankCardCode():"";
			currentPayTicket = userPawn.getPayeeTicket()!=null?userPawn.getPayeeTicket():"";
			repawnDetail.setIsPayFirst(userPawn.getPayeeTicket()!=null?"1":"0");//是否已经缴纳本期综合费 0-否 1-已缴
			repawnDetail.setIsPayPlatMoney(userPawn.getPlatformState()==null?"0":userPawn.getPlatformState()==1?"1":"0");
		}else {
			//从续当表获得该repawnId的本期续当综合费，上一期的利息（赎当）费，上一期逾期费（如果逾期）
			//这些数据在用户端提交了续当申请时由用户端计算写入数据库字段，机构端读取他们计算和展示
			try{
				rpId = Integer.valueOf(repawnId);
			}catch (NumberFormatException e){
				e.printStackTrace();
				return msg(-1,"输入的字符不合法");
			}
			PawnContinue pawnContinue = pawnContinueService.selectByPrimaryKey(rpId);
			preInterest = pawnContinue.getPawnInterest();
			cost = pawnContinue.getPawnMoney();
			overdue =pawnContinue.getPawnOverdue();
			/*//续当的收款人,账号,银行名称(由于是续当,所以显示的是机构收款的银行名和账号)
			bankCardName = card.getBankCardName()!=null?card.getBankCardName():"";
			bankCardUserName = card.getBankCardUserName()!=null? card.getBankCardUserName():"";
			bankCardNo = userPawn.getPayBacnkCardCode()!=null?userPawn.getPayBacnkCardCode():"";*/
			currentPayTicket = pawnContinue.getPayTicket();//用户续当打款凭证
			//计算续当至日期
			String dateRepawnToStr ;  //续当至日期 字符串形式
			Date dateRepawnTo;//续当至日期
			//如果数据库保存了续当至日期，则使用数据库该字段，否则根据用户续当当期多长，计算得到
			if (pawnContinue.getPawnEndTime()!=null){
				dateRepawnTo = pawnContinue.getPawnEndTime();
				dateRepawnToStr = dateRepawnTo!=null ? DateUtil.dateToStr(dateRepawnTo,"yyyy-MM-dd HH:mm"):"";
			}else{
				Integer pawnMonth = pawnContinue.getPawnMonth();//用户最新一期续当，想续多少个当期
				if (pawnMonth == null){ //若续当表续当月份字段为null，抛异常
					return msg(-1,"系统出错了，请联系开发人员");
				}else {
					if(pawnMonth % 2 == 0 ){//如果续当当期换算成月数正好是整数，直接pawn_end_time 的日期 + 该月数 得到 续当至日期
						dateRepawnTo = DateUtil.addMonth(pawn_end_time,pawnMonth / 2);
					}else{//否则先加整数个月数，不足一个月部分加15天
						int i = pawnMonth/2;
						Date d = DateUtil.addMonth(pawn_end_time,i);
						dateRepawnTo = DateUtil.add(d,15);
					}
					dateRepawnToStr = DateUtil.dateToStr(dateRepawnTo,"yyyy-MM-dd HH:mm");
				}
			}
			//到期应还款金额=本金+上期赎当利息+滞纳金（若有）
			payBack = loan_money.add(preInterest).add(overdue).toString();
			//续当费用合计=本期综合费（本期指准备续当的那个当期）+上期利息+逾期滞纳金（若逾期，否则为0）
			repawnMoney = cost.add(preInterest).add(overdue);
			repawnDetail.setPayBack(payBack);
			//当前应还款日期：总是上一期结束时间
			repawnDetail.setLoanCurrentRepayTime(DateUtil.dateToStr(pawnContinue.getPawnLastEndTime(),"yyyy-MM-dd HH:mm"));
			repawnDetail.setRepawnMoney(repawnMoney.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
			//提交的这一期结束时间
			repawnDetail.setDateRepawnTo(dateRepawnToStr);
			repawnDetail.setCost(cost.toString());//续当处理页面，本期（下期）综合费
			repawnDetail.setPreInterest(preInterest.toString());//上期利息
			repawnDetail.setDemurrage(overdue.toString());//逾期滞纳金
//			repawnDetail.setDemurrageRate(PaidangConst.REDEEM_OVERRATE.toString());
			repawnDetail.setDemurrageRate(getRedeemOverrate(userPawn.getId()).toString());
			repawnDetail.setIsPayRepawnMoney(pawnContinue.getState()==4?"1":"0");//是否已经缴纳续当费 0-否 1-已缴
			repawnDetail.setIsPayPlatMoney(pawnContinue.getPlatformState()==null?"0":pawnContinue.getPlatformState()==1?"1":"0");//是否已经缴纳平台利息 0-否 1-已缴
		}
		repawnDetail.setCollecterId(pawnerUserId.toString());
		repawnDetail.setLoanBeginTime(pawnBeginTime);
		repawnDetail.setMoneyRate(moneyRate);
		repawnDetail.setRate(rate);
		repawnDetail.setPawnerAddress(pawnerAddress);
		repawnDetail.setPawnerTelNum(pawnerTelNum);
		repawnDetail.setPawnerName(pawnerName);
		repawnDetail.setUserMoney(userMoney);//已发放当金
		repawnDetail.setLoanMoney(loanMoney);
		repawnDetail.setAuthPrice(authPrice);
		repawnDetail.setPawnCode(pawnTicketCode);
		repawnDetail.setGoodsid(goodId.toString());
		repawnDetail.setGoodsName(goodName);
		repawnDetail.setImages(images);
		repawnDetail.setId(userPawn.getId().toString());
		repawnDetail.setCurrentPayTicket(currentPayTicket);
//		repawnDetail.setBankCardUserName(bankCardUserName);
//		repawnDetail.setBankCardName(bankCardName);
//		repawnDetail.setBankCardCode(bankCardNo);
		return ok(repawnDetail);
	}


	//赎当列表
	@RequestMapping("/getRedeemList")
	@ResponseBody
	public String getRedeemList(Integer page, Integer rows ){
		PaginationSupport.byPage(page, rows);
		String orgId = getSessionParameter("id");
		List<UserPawnEx> userPawnExList = userPawnService.getOrgRedeemList(orgId.toString());
		return page(userPawnExList);
	}

	//赎当详情
	@RequestMapping("/getRedeemDetail")
	@ResponseBody
	public String getRedeemDetail(String pawnId){
		UserPawnEx userPawnEx = userPawnService.getUserPawnExById(pawnId);
		RedeemDetail redeemDetail = new RedeemDetail();

		redeemDetail.setPawnId(userPawnEx.getId().toString());
		redeemDetail.setGoodsId(userPawnEx.getGoodsId().toString());
		redeemDetail.setTitle(userPawnEx.getGoodsName1()!=null?userPawnEx.getGoodsName1():"");
		redeemDetail.setAuthPrice(userPawnEx.getAuthPrice()!=null?userPawnEx.getAuthPrice().toString():"");
		redeemDetail.setImages(userPawnEx.getImages()!=null?userPawnEx.getImages():"");
		redeemDetail.setCollecterId(userPawnEx.getUserId().toString());
		redeemDetail.setPawnerName(userPawnEx.getUserName()!=null?userPawnEx.getUserName():"");
		redeemDetail.setPawnTicketCode(userPawnEx.getPawnTicketCode()!=null?userPawnEx.getPawnTicketCode():"");
		redeemDetail.setPawnerTelNum(userPawnEx.getUserPhone()!=null?userPawnEx.getUserPhone():"");
		redeemDetail.setLoanBeginTime(userPawnEx.getPawnBeginTime()!=null?DateUtil.dateToStr(userPawnEx.getPawnBeginTime(),"yyyy-MM-dd HH:mm") :"");
		//当前应还款时期
		redeemDetail.setLoanCurrentEndTime(userPawnEx.getPawnEndTime()!=null?DateUtil.dateToStr(userPawnEx.getPawnEndTime(),"yyyy-MM-dd HH:mm") :"");
		//用户地址
		String pawnerAddress="";
		UserAddressExample userAddressExample = new UserAddressExample();
		userAddressExample.createCriteria().andUserIdEqualTo(userPawnEx.getUserId()).andIsDefaultEqualTo(1);
		List<UserAddress> userAddresses = userAddressService.selectByExample(userAddressExample);
		if(userAddresses.size() != 0){
			pawnerAddress = userAddresses.get(0).getAddress()!=null&&userAddresses.get(0).getArea()!=null?userAddresses.get(0).getArea()+userAddresses.get(0).getAddress():"";
		}
		redeemDetail.setPawnerAddress(pawnerAddress);
		//已发放当金 = 贷款金额 - 首期综合费 若数据库已保存则取数据库，否则计算得到
		if(userPawnEx.getUserMoney()!=null){
			redeemDetail.setUserMoney(userPawnEx.getUserMoney().toString());
		}else if (userPawnEx.getPawnMoney()!=null && userPawnEx.getBeginMoney()!=null){
			redeemDetail.setUserMoney(userPawnEx.getBeginMoney().subtract(userPawnEx.getPawnMoney()).toString());
		}else {
			redeemDetail.setUserMoney("0");
		}

		BigDecimal loan_money = userPawnEx.getBeginMoney();//本金
		if(loan_money==null){
			throw new SystemException("系统错误，请联系开发人员");
		}
		redeemDetail.setLoanMoney(loan_money.toString());
		BigDecimal moneyRate = userPawnEx.getMoneyRate();//利息利率
		if(moneyRate==null){
			throw new SystemException("系统错误，请联系开发人员");
		}
		redeemDetail.setMoneyRate(moneyRate.toString());
//		redeemDetail.setRedeemOverRate(PaidangConst.REDEEM_OVERRATE.toString());//逾期滞纳利率
		redeemDetail.setRedeemOverRate(getRedeemOverrate(userPawnEx.getId()).toString());
		//计算赎当利息
		Integer times = pawnContinueService.getRepawnTimes(userPawnEx.getId());//办理过多少次续当
		BigDecimal redeem_interest ;
		BigDecimal payBack ;
		if(times == null || times == 0){//用户并没有续当过,计算赎当利息的时长就是首次典当约定的当期长
			if(userPawnEx.getBeginPawnMonth()==null){
				throw new SystemException("系统错误，请联系开发人员");
			}
			if(userPawnEx.getRedeemInterest()==null){
				redeem_interest = CostGenerator.getInterest(loan_money,moneyRate,userPawnEx.getBeginPawnMonth());
			}else{
				redeem_interest = userPawnEx.getRedeemInterest();
			}
			redeemDetail.setMoneyCost(redeem_interest.setScale(2,BigDecimal.ROUND_HALF_UP).toString());//赎当利息
		}else{
			//用户续当过至少一次,计算赎当利息的时长就是上一个续当的当期
			PawnContinueExample pawnContinueExample = new PawnContinueExample();
			pawnContinueExample.createCriteria().andPawnIdEqualTo(Integer.valueOf(pawnId)).andStateEqualTo(4);
			List<PawnContinue> pawnContinueList = pawnContinueService.selectByExample(pawnContinueExample);
			PawnContinue pawnContinue = pawnContinueList.get(0);// 有此pawnId的续当记录，取第一个，最新的
			Integer pawnMonth = pawnContinue.getPawnMonth();//续当表保存的该续当周期长(当前时期所在续当周期)
			//计算赎当利息
			if(userPawnEx.getRedeemInterest()==null){
				redeem_interest = CostGenerator.getInterest(loan_money,moneyRate,userPawnEx.getBeginPawnMonth());
			}else{
				redeem_interest = userPawnEx.getRedeemInterest();
			}
			redeemDetail.setMoneyCost(redeem_interest.setScale(2,BigDecimal.ROUND_HALF_UP).toString());//赎当利息
		}
		//计算逾期利息(可能产生)
		BigDecimal redeemOverdue ;
		Date pawnEndTime = userPawnEx.getPawnEndTime();
		if (userPawnEx.getRedeemOverdue() == null){
			redeemOverdue = CostGenerator.getOverdue(loan_money,pawnEndTime,getRedeemOverrate(userPawnEx.getId()));
		}else{
			redeemOverdue = userPawnEx.getRedeemOverdue();
		}

		redeemDetail.setRedeemOverdue(redeemOverdue.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		//到期应还款金额 = 本金 + 本期利息 + 逾期利息(可能产生)
		payBack = loan_money.add(redeem_interest).add(redeemOverdue);
		redeemDetail.setPayBack(payBack.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		String bankCardName = userPawnEx.getPayBankName()!=null?userPawnEx.getPayBankName():"";
		String bankCardUserName = userPawnEx.getPayName()!=null? userPawnEx.getPayName():"";
		String bankCardNo = userPawnEx.getPayBacnkCardCode()!=null?userPawnEx.getPayBacnkCardCode():"";
		String currentPayTicket = userPawnEx.getRedeemTicket();//用户赎当打款凭证
		redeemDetail.setBankCardName(bankCardName);
		redeemDetail.setBankCardCode(bankCardNo);
		redeemDetail.setBankCardUserName(bankCardUserName);
		redeemDetail.setCurrentPayTicket(currentPayTicket);
		return ok(redeemDetail);
	}


	//绝当列表
	@RequestMapping("/getDeadPawnList")
	@ResponseBody
	public String getDeadPawnList(Integer page, Integer rows){
		PaginationSupport.byPage(page, rows);
		String orgId = getSessionParameter("id");
		List<UserPawnEx> userPawnExList = userPawnService.getOrgDeadPawnList(orgId.toString());
		return page(userPawnExList);
	}

	//绝当详情
	@RequestMapping("/getDeadPawnDetail")
	@ResponseBody
	public String getDeadPawnDetail(String pawnId){
		UserPawnEx userPawnEx = userPawnService.getUserPawnExById(pawnId);
		DeadPawnDetail deadPawnDetail = new DeadPawnDetail();

		deadPawnDetail.setPawnId(userPawnEx.getId().toString());
		deadPawnDetail.setGoodsId(userPawnEx.getGoodsId().toString());
		deadPawnDetail.setTitle(userPawnEx.getGoodsName1()!=null?userPawnEx.getGoodsName1():"");
		deadPawnDetail.setAuthPrice(userPawnEx.getAuthPrice()!=null?userPawnEx.getAuthPrice().toString():"");
		deadPawnDetail.setImages(userPawnEx.getImages()!=null?userPawnEx.getImages():"");
		deadPawnDetail.setCollecterId(userPawnEx.getUserId().toString());
		deadPawnDetail.setPawnerName(userPawnEx.getUserName()!=null?userPawnEx.getUserName():"");
		deadPawnDetail.setPawnTicketCode(userPawnEx.getPawnTicketCode()!=null?userPawnEx.getPawnTicketCode():"");
		deadPawnDetail.setPawnerTelNum(userPawnEx.getUserPhone()!=null?userPawnEx.getUserPhone():"");
		deadPawnDetail.setLoanBeginTime(userPawnEx.getPawnBeginTime()!=null?DateUtil.dateToStr(userPawnEx.getPawnBeginTime(),"yyyy-MM-dd HH:mm") :"");
		//当前应还款时期
		deadPawnDetail.setLoanCurrentEndTime(userPawnEx.getPawnEndTime()!=null?DateUtil.dateToStr(userPawnEx.getPawnEndTime(),"yyyy-MM-dd HH:mm") :"");
		//用户地址
		String pawnerAddress="";
		UserAddressExample userAddressExample = new UserAddressExample();
		userAddressExample.createCriteria().andUserIdEqualTo(userPawnEx.getUserId()).andIsDefaultEqualTo(1);
		List<UserAddress> userAddresses = userAddressService.selectByExample(userAddressExample);
		if(userAddresses.size() != 0){
			pawnerAddress = userAddresses.get(0).getAddress()!=null&&userAddresses.get(0).getArea()!=null?userAddresses.get(0).getArea()+userAddresses.get(0).getAddress():"";
		}
		deadPawnDetail.setPawnerAddress(pawnerAddress);

		BigDecimal loan_money = userPawnEx.getBeginMoney();//本金
		if(loan_money==null){
			throw new SystemException("系统错误，请联系开发人员");
		}
		deadPawnDetail.setLoanMoney(loan_money.toString());
		BigDecimal moneyRate = userPawnEx.getMoneyRate();//利息利率
		if(moneyRate==null){
			throw new SystemException("系统错误，请联系开发人员");
		}
		deadPawnDetail.setMoneyRate(moneyRate.toString());
//		deadPawnDetail.setRedeemOverRate(PaidangConst.REDEEM_OVERRATE.toString());//逾期滞纳利率
		deadPawnDetail.setRedeemOverRate(getRedeemOverrate(userPawnEx.getId()).toString());
		//已发放当金 = 贷款金额 - 首期综合费 若数据库已保存则取数据库，否则计算得到
		if(userPawnEx.getUserMoney()!=null){
			deadPawnDetail.setUserMoney(userPawnEx.getUserMoney().toString());
		}else if (userPawnEx.getPawnMoney()!=null && userPawnEx.getBeginMoney()!=null){
			deadPawnDetail.setUserMoney(userPawnEx.getBeginMoney().subtract(userPawnEx.getPawnMoney()).toString());
		}else {
			deadPawnDetail.setUserMoney("0");
		}
		//计算赎当利息
		Integer times = pawnContinueService.getRepawnTimes(userPawnEx.getId());//办理过多少次续当

		BigDecimal redeem_interest ;
		BigDecimal payBack ;
		if(times == null || times == 0){//用户并没有续当过,计算赎当利息的时长就是首次典当约定的当期长
			if(userPawnEx.getBeginPawnMonth()==null){
				throw new SystemException("系统错误，请联系开发人员");
			}
			redeem_interest = CostGenerator.getInterest(loan_money,moneyRate,userPawnEx.getBeginPawnMonth());
			deadPawnDetail.setMoneyCost(redeem_interest.setScale(2,BigDecimal.ROUND_HALF_UP).toString());//赎当利息
		}else{
			//用户续当过至少一次,计算赎当利息的时长就是上一个续当约定的当期长
			PawnContinueExample pawnContinueExample = new PawnContinueExample();
			pawnContinueExample.createCriteria().andPawnIdEqualTo(Integer.valueOf(pawnId));
			List<PawnContinue> pawnContinueList = pawnContinueService.selectByExample(pawnContinueExample);
			PawnContinue pawnContinue = pawnContinueList.get(0);// 有此pawnId的续当记录，取第一个，最新的
			Integer pawnMonth = pawnContinue.getPawnMonth();//续当表保存的该续当周期时长(当前时期所在续当周期)
			//计算赎当利息
			redeem_interest = CostGenerator.getInterest(loan_money,moneyRate,pawnMonth);
			deadPawnDetail.setMoneyCost(redeem_interest.setScale(2,BigDecimal.ROUND_HALF_UP).toString());//赎当利息
		}
		//计算逾期费
		BigDecimal redeemOverdue;
		Date pawnEndTime = userPawnEx.getPawnEndTime();
		redeemOverdue = CostGenerator.getOverdue(loan_money,pawnEndTime,getRedeemOverrate(userPawnEx.getId()));
		deadPawnDetail.setRedeemOverdue(redeemOverdue.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		//到期应还款金额 = 本金 + 本期利息 + 逾期费（如果逾期）
		payBack = loan_money.add(redeem_interest).add(redeemOverdue);
		deadPawnDetail.setPayBack(payBack.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
		return ok(deadPawnDetail);
	}


	//典当详情--平台查看
	@RequestMapping("/pawnRecord")
	@ResponseBody
	public String pawnRecord(Integer page, Integer rows, String goodsName, String orgId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsName",goodsName);
		map.put("orgId",orgId);
		List<UserPawnEx> list = userPawnService.selectPawnRecord(map);
		return ok(list);
	}





}