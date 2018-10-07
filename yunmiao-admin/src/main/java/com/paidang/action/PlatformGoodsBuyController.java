package com.paidang.action;

import java.util.List;
import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import com.base.entity.QueryParams;
import com.base.security.util.UserUtils;
import com.item.dao.model.User;
import com.item.service.UserService;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.PlatformGoodsBuyEx;
import com.paidang.service.*;
import com.util.MPawnMsg;
import com.util.PaidangMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.item.service.UserNotifyService;

/**
@author sun
*/
@RequestMapping("platformGoodsBuy")
@Controller
@LoginFilter
public class PlatformGoodsBuyController extends CoreController{

    @Autowired
    private PlatformGoodsBuyService platformGoodsBuyService;
	@Autowired
	private PawnLogService pawnLogService;
	@Autowired
	private UserGoodsService userGoodsService;
	@Autowired
	private UserPawnService userPawnServiceEx;
	@Autowired
	private UserService userService;
	@Autowired
	private UserBalanceLogService userBalanceLogService;
	@Autowired
	private UserNotifyService userNotifyService;
	@Autowired
	private OrgBalanceLogService orgBalanceLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows,String userName){
		QueryParams.Builder builder = QueryParams.newBuilder();
		builder.put("userName",userName);
    	PaginationSupport.byPage(page, rows);
    	List<PlatformGoodsBuyEx> list = platformGoodsBuyService.selectPlatformGoods(builder);
      	return page(list);
    }
    
//    @RequestMapping("/save")
//	@ResponseBody
//    public String save(PlatformGoodsBuyEx platformGoodsBuy){
//    	if (platformGoodsBuy.getId() == null){
//    		platformGoodsBuy.setState(1);
//    		platformGoodsBuyService.insert(platformGoodsBuy);
//    	}else{
//			platformGoodsBuy.setState(2);
//    		platformGoodsBuyService.updateByPrimaryKeySelective(platformGoodsBuy);
//    	}
//       	return ok();
//    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PlatformGoodsBuy platformGoodsBuy = platformGoodsBuyService.selectByPrimaryKey(id);
       	return ok(platformGoodsBuy);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		platformGoodsBuyService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	@RequestMapping("/changeState")
	@ResponseBody
		public String changeState(Integer id,Integer v,PlatformGoodsBuyEx platform,String refuseInfo){
			platform.setId(id);
			platform.setState(v);
			if(platform.getState() != 2){
				platformGoodsBuyService.changeStateByPrimaryKey(platform);
			}else{
				platform.setState(0);
				platformGoodsBuyService.changeStateByPrimaryKey(platform);
			}
			return ok();
		}
//	@RequestMapping("/saveLog")
//	@ResponseBody
//	public String saveLog(PlatformGoodsBuyEx platformGoodsBuyEx){
//		if (platformGoodsBuyEx.getId() == null){
//			platformGoodsBuyEx.setState(1);
//			platformGoodsBuyService.insert(platformGoodsBuyEx);
//		}else{
//			PlatformGoodsBuy platformGoodsBuy = platformGoodsBuyService.selectByPrimaryKey(platformGoodsBuyEx.getId());
//
//			//UserPawn userPawn = userPawnServiceEx.selectByGoodsId(platformGoodsBuy.getGoodsId());
//			UserPawnExample example1 = new UserPawnExample();
//			example1.createCriteria().andGoodsIdEqualTo(platformGoodsBuy.getGoodsId());
//			example1.setOrderByClause("create_time desc");
//			List<UserPawn> list2 = userPawnServiceEx.selectByExample(example1);
//			User user = userService.selectByAccount(platformGoodsBuy.getUserPhone());
//			UserGoods userGoods = userGoodsService.selectByPrimaryKey(platformGoodsBuy.getGoodsId());
////			userGoods.setBelongId(0);
//			userGoods.setBelongType(0);
//			userGoods.setGoSell(2);
//			userGoodsService.updateByPrimaryKey(userGoods);
//
//			if(0 == list2.size()){
//
//			}
//
//
//			if( userGoods != null & user != null) {
//				if(list2.size() != 0){
//					UserPawn userPawn  = list2.get(0);
//					//插入卖给平台记录表
//					pawnLogService.updatePawnlog(
//							userGoods.getId(),
//							user.getId(),
//							userPawn.getOrgId(),
//							userGoods.getName(),
//							userGoods.getAuthPrice(),
//							userGoods.getCateCode(),
//							userGoods.getCateId(),
//							userPawn.getOrgName(),
//							userPawn.getMoney(),
//							userPawn.getPawnTime(),
//							6,
//							platformGoodsBuyEx.getUserName(),
//							platformGoodsBuyEx.getBankCardName(),
//							platformGoodsBuyEx.getBankCardNo()
//					);
//					if(platformGoodsBuy.getSource() == 1){
//						//用户卖给平台
//						userBalanceLogService.updateUserBalanceLog(
//								user.getId(),
//								userGoods.getId(),
//								userGoods.getAuthPrice(),
//								1,
//								4,
//								10,
//								"",
//								platformGoodsBuyEx.getTicket(),
//								platformGoodsBuyEx.getBankCardName(),
//								platformGoodsBuyEx.getBankCardNo(),
//								0,
//								MPawnMsg.comName,
//								MPawnMsg.phone
//						);
//						UserBalanceLogExample example = new UserBalanceLogExample();
//						example.createCriteria().andCidEqualTo(userGoods.getId());
//						List<UserBalanceLog> list = userBalanceLogService.selectByExample(example);
//						if(null != list && 0 != list.size()){
//							UserBalanceLog c = list.get(0);
//							c.setTradeTicket(platformGoodsBuy.getTicket());
//							int result = userBalanceLogService.updateByPrimaryKeySelective(c);
//							if(0 == result){
//							}
//						}
//					}
//				}else{
//					//插入卖给平台记录表
//					pawnLogService.updatePawnlog(
//							userGoods.getId(),
//							user.getId(),
//							null,
//							userGoods.getName(),
//							userGoods.getAuthPrice(),
//							userGoods.getCateCode(),
//							userGoods.getCateId(),
//							null,
//							null,
//							null,
//							6,
//							platformGoodsBuyEx.getUserName(),
//							platformGoodsBuyEx.getBankCardName(),
//							platformGoodsBuyEx.getBankCardNo()
//					);
//					if(platformGoodsBuy.getSource() == 1){
//						//用户卖给平台
//						userBalanceLogService.updateUserBalanceLog(
//								user.getId(),
//								userGoods.getId(),
//								userGoods.getAuthPrice(),
//								1,
//								4,
//								10,
//								"",
//								platformGoodsBuyEx.getTicket(),
//								platformGoodsBuyEx.getBankCardName(),
//								platformGoodsBuyEx.getBankCardNo(),
//								0,
//								MPawnMsg.comName,
//								MPawnMsg.phone
//						);
//						UserBalanceLogExample example = new UserBalanceLogExample();
//						example.createCriteria().andCidEqualTo(userGoods.getId());
//						List<UserBalanceLog> list = userBalanceLogService.selectByExample(example);
//						if(null != list && 0 != list.size()){
//							UserBalanceLog c = list.get(0);
//							c.setTradeTicket(platformGoodsBuy.getTicket());
//							int result = userBalanceLogService.updateByPrimaryKeySelective(c);
//							if(0 == result){
//							}
//						}
//					}
//				}
//
//				if(user.getId() != null){
//					platformGoodsBuyService.updateByTickect(platformGoodsBuyEx);
//					//推送
//					userNotifyService.insertByTemplate(user.getId(), "7", PaidangMessage.TRADE_SUCCESS_NOTIFY);
//				}
//				}else if(platformGoodsBuy.getSource() == 2){
////					//机构卖给平台
////					orgBalanceLogService.updateOrgBalanceLog(
////							user.getId(),
////							platformGoodsBuyEx.getPrice(),
////							2,
////
////
////					);
//				}
//		}
//
//
//		return ok();
//	}
}