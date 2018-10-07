package com.item.task;

import com.base.date.DateTime;
import com.base.date.DateUtil;
import com.base.exception.SystemException;
import com.base.service.TaskLogService;
import com.item.service.UserNotifyService;
import com.item.service.UserService;
import com.paidang.dao.model.*;
import com.paidang.daoEx.model.OrderEx;
import com.paidang.daoEx.model.UserPawnEx;
import com.paidang.service.*;
import com.util.PaidangConst;
import com.util.PaidangMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PawnCron{

	private static Logger logger = LoggerFactory.getLogger(PawnCron.class);

	@Autowired
	private UserService userService;
	@Autowired
	private UserPawnService userPawnService;
	@Autowired
	private PawnAuctionService pawnAuctionService;
	@Autowired
	private TaskLogService taskLogService;
	@Autowired
	private UserGoodsService userGoodsService;
//	@Autowired
//	private OrgNotifyService orgNotifyService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsAuctionService goodsAuctionService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserNotifyService userNotifyService;

	/**
	 * 当品竞拍时间结束定时任务
	 */
	//每一分钟执行一次 0 */1 * * * ?
	public void pawn(){
		long start = System.currentTimeMillis();
//		UserPawnExample example = new UserPawnExample();
//		example.createCriteria().andStateEqualTo(1).andCreateTimeLessThanOrEqualTo(DateUtil.offsetSecond(new Date(),-PaidangConst.AUCTION_TIME));
//		List<UserPawn> list = userPawnService.selectByExample(example);

		Map<String, Object> map = new HashMap<>();
		map.put("time",DateUtil.offsetSecond(new Date(),-PaidangConst.AUCTION_TIME));
		List<UserPawnEx> list = userPawnService.selectTask(map);

		/*
		* 竞拍时间结束后，如果该典当在竞拍有效时间内无人出价竞拍，state设置成 -1-已取消
		* 若竞拍有效时间之内有至少一家机构对其发起竞拍，state字段还是保持为 1-竞拍中，竞拍时间结束后，这条典当任何机构将不能进行出价竞拍
		* 但是用户还是可以选择之前竞拍过的机构作为中标机构，或者选择宝祥兜底
		* */
		//竞拍结束
		for (UserPawnEx pawn : list){
			//是否有人竞拍
 			int cnt = pawn.getCnt();
			//TODO
			if(cnt == 0){
				pawn.setState(-1);
				//时间到还在竞拍中--等待用户选择宝祥兜底

			}
			userPawnService.updateByPrimaryKeySelective(pawn);
		}
		logger.debug("典当时间任务时间-------"+(System.currentTimeMillis() - start));
	}

	/*
	* 用户选择中标机构，该机构在接下来的1小时内未支付贷款定时任务
	*
	* 每分钟运行一次
	* */
	public void payLimit(){
		UserPawnExample userPawnExample = new UserPawnExample();
		userPawnExample.createCriteria().andOrgIdIsNotNull().andStateEqualTo(1).andUserStateEqualTo(2);
		List<UserPawn> records = userPawnService.selectByExample(userPawnExample);
		Date now = new Date();
		for (UserPawn element:records) {
			Date orgSelectedTime = element.getOrgSelectedTime();
			if (orgSelectedTime == null){
				throw new SystemException("======支付贷款限时定时任务：典当id是"+element.getId()+"的记录选择中标典当行字段为空======");
			}else {
				Date validTime = DateUtil.offsetMinute(orgSelectedTime,PaidangConst.PAY_LIMIT_TIME);
				if (now.compareTo(validTime) > 0 && element.getPayeeTicket() == null){
					element.setState(-1);
					element.setUserState(4);
					userPawnService.updateByPrimaryKey(element);
					UserGoods userGoods = userGoodsService.selectByPrimaryKey(element.getGoodsId());
					if (userGoods == null){
						throw new SystemException("======支付贷款限时定时任务：典当id是"+element.getId()+"的记录其当品在藏品表为空======");
					}
					userGoods.setGotoPawn(0);
					userGoodsService.updateByPrimaryKey(userGoods);
				}
			}
		}
	}


	/**
	 *  绝当，每天0:00:01运行
	 */
	//1 0 0 1/1 * ?
	public void end(){
		//过期绝当
		UserPawnExample example = new UserPawnExample();
		example.createCriteria().andStateEqualTo(2).andPawnEndTimeLessThan(DateUtil.add(new DateTime(DateUtil.getCurrentTime(DateUtil.YYMMDD),DateUtil.YYMMDD),-PaidangConst.BUFFER_DAYS));
		List<UserPawn> list = userPawnService.selectByExample(example);
		UserPawn userPawn = new UserPawn();
		userPawn.setState(4);
		UserGoods goods = new UserGoods();
		//更新绝当品归属
		for (UserPawn pawn : list){
			goods.setId(pawn.getGoodsId());
			goods.setBelongId(pawn.getOrgId());
			goods.setBelongType(2);
			userGoodsService.updateByPrimaryKeySelective(goods);
			//绝当写推送消息（机构端）,绝当消息对于每个当品只会有一次
//			orgNotifyService.insertByTemplate(pawn.getOrgId(),"5",PaidangMessage.PAWN_DEAD_NOTIFY,pawn.getGoodsName());
			userNotifyService.insertByTemplate(pawn.getUserId(),"9",PaidangMessage.PAWN_DEAD_NOTIFY,pawn.getGoodsName());
		}
		//更新绝当状态
		userPawnService.updateByExampleSelective(userPawn,example);
	}

	/*
	*
	* 典当到期消息
	* */

	public void endLastZero(){
		//查出最后一天
		//发送用户和机构端通知
		List<UserPawn> list = getUserPawnListByDay(0);
		for (UserPawn userPawn :list){
			String pawnerName = userService.selectByPrimaryKey(userPawn.getUserId()).getName();
			setOrgNotify(userPawn,pawnerName,0);
		}
	}

	public void endLastOne(){
		//查出还有1天到期的
		//发送用户和机构端通知
		List<UserPawn> list = getUserPawnListByDay(1);
		for (UserPawn userPawn :list){
			String pawnerName = userService.selectByPrimaryKey(userPawn.getUserId()).getName();
			setOrgNotify(userPawn,pawnerName,1);
		}
	}

	public void endLastTwo(){
		//查出还有2天到期的
		//发送用户和机构端通知
		List<UserPawn> list = getUserPawnListByDay(2);
		for (UserPawn userPawn :list){
			String pawnerName = userService.selectByPrimaryKey(userPawn.getUserId()).getName();
			setOrgNotify(userPawn,pawnerName,2);
		}
	}

	public void endLastThree(){
		//查出还有3天到期的
		//发送用户和机构端通知
		List<UserPawn> list = getUserPawnListByDay(3);
		for (UserPawn userPawn :list){
			String pawnerName = userService.selectByPrimaryKey(userPawn.getUserId()).getName();
			setOrgNotify(userPawn,pawnerName,3);
		}
	}

	public void endLastFour(){
		//查出还有4天到期的
		//发送用户和机构端通知
		List<UserPawn> list = getUserPawnListByDay(4);
		for (UserPawn userPawn :list){
			String pawnerName = userService.selectByPrimaryKey(userPawn.getUserId()).getName();
			setOrgNotify(userPawn,pawnerName,4);
		}
	}

	public void endLastFive(){
		//查出还有5天到期的
		//发送用户和机构端通知
		List<UserPawn> list = getUserPawnListByDay(5);
		for (UserPawn userPawn :list){
			String pawnerName = userService.selectByPrimaryKey(userPawn.getUserId()).getName();
			setOrgNotify(userPawn,pawnerName,5);
		}
	}

	//典当到期提醒消息
	private void setOrgNotify(UserPawn userPawn,String pawnerName,Integer days){
		Integer goodsId = userPawn.getGoodsId();
		Goods record = goodsService.selectByPrimaryKey(goodsId);
		userNotifyService.insertByTemplate(userPawn.getUserId(),"2",PaidangMessage.PAWN_END_NOTIFY,record.getName(),userPawn.getOrgName(),userPawn.getOrgName());
	}

	//查询出所有距离典当到期还有last天的记录（但他们还没到期）
	private List<UserPawn> getUserPawnListByDay(int last){
		Date today = new DateTime(DateUtil.getCurrentTime(DateUtil.YYMMDD),DateUtil.YYMMDD);
		UserPawnExample example = new UserPawnExample();
		example.createCriteria().andStateEqualTo(2).andPawnEndTimeEqualTo(DateUtil.add(today,last));
		return userPawnService.selectByExample(example);
	}

	/*
	*
	* 逾期将要绝当消息 每天00：00：01运行一次
	* */
	public void ExpireOneDay(){
		List<UserPawn> list = getExpirePawnByDays(1);
		for (UserPawn userPawn :list){
			sendExpireMsg(userPawn,"1");
		}
	}

	public void ExpireTwoDay(){
		List<UserPawn> list = getExpirePawnByDays(2);
		for (UserPawn userPawn :list){
			sendExpireMsg(userPawn,"2");
		}
	}

	public void ExpireThreeDay(){
		List<UserPawn> list = getExpirePawnByDays(3);
		for (UserPawn userPawn :list){
			sendExpireMsg(userPawn,"3");
		}
	}

	public void ExpireFourDay(){
		List<UserPawn> list = getExpirePawnByDays(4);
		for (UserPawn userPawn :list){
			sendExpireMsg(userPawn,"4");
		}
	}

	//推送机构逾期消息
	private void sendExpireMsg(UserPawn userPawn,String days){
//		orgNotifyService.insertByTemplate(userPawn.getOrgId(),"2",PaidangMessage.USER_OVERDUE_NOTIFY,userPawn.getUserName(),days);
	}

	//查询已逾期days天的典当
	private List<UserPawn> getExpirePawnByDays(int days){
		Date today = new DateTime(DateUtil.getCurrentTime(DateUtil.YYMMDD),DateUtil.YYMMDD);
		UserPawnExample example = new UserPawnExample();
		example.createCriteria().andStateEqualTo(2).andPawnEndTimeEqualTo(DateUtil.add(today,-days));
		return userPawnService.selectByExample(example);
	}

	//30分钟释放未付款--释放库存--并改为未付款
	public void release(){

		List<OrderEx> list = orderService.selectRelease();
		if (list!=null && list.size()>0){
			//修改成已取消订单
			int updateOrder = orderService.updateOrderList(list);

			//释放商品表库存
			int updateGoods = orderService.updateGoodsList(list);
		}
	}

	/*
	*
	* 绝当商城竞拍，倒计时结束后定时任务，每分钟运行一次
	*
	*/
	//  现机构处理其绝当品，不再使用用户竞拍形式，所以这段代码暂时注掉，cron.properties的任务也一并被注掉

/*	public void goodsAuctionEnd(){
		//p_goods里绝当竞拍倒计时结束的物品
		GoodsExample goodsExample = new GoodsExample();
		goodsExample.createCriteria().andCreateTimeLessThan(DateUtil.offsetSecond(new Date(),-PaidangConst.JD_GOODS_TIME));
		List<Goods> expiredGoods = goodsService.selectByExample(goodsExample);
		for (Goods element:expiredGoods) {
			if (element.getState() != 0){
				element.setState(0); //使竞拍失效
			}
			//有人竞拍，到竞拍结束后自动取价高者为中标者，并插入订单表
			GoodsAuctionExample example = new GoodsAuctionExample();//查找此物品的竞拍记录
			example.createCriteria().andGoodsIdEqualTo(element.getId());
			example.setOrderByClause("create_time desc");
			List<GoodsAuction> auctions = goodsAuctionService.selectByExample(example);
			if (element.getMaxAutionId() != null && auctions.size() != 0){
				//查询出中标的那次竞拍记录
				GoodsAuction record = goodsAuctionService.selectByPrimaryKey(element.getMaxAutionId());
				if (record == null){
					throw new SystemException("绝当竞拍id是【"+element.getMaxAutionId()+"】的记录数据异常");
				}
				Integer userId = record.getUserId();//中标用户
				if (userId == null){
					throw new SystemException("绝当竞拍id是【"+element.getMaxAutionId()+"】的记录数据异常");
				}
				OrderExample orderExample = new OrderExample();
				orderExample.createCriteria().andGoodsIdEqualTo(element.getId()).andUserIdEqualTo(element.getUserId()).andOrgIdEqualTo(element.getOrgId());
				int cnt = orderService.countByExample(orderExample);
				if (cnt == 0){
					Order order = new Order();
					//插入订单号
					order.setCode(UUID.randomUUID().toString().replaceAll("-", ""));
					order.setUserId(element.getUserId());
					order.setGoodsId(element.getId());//这里的goodsId是指p_goods表主键
					order.setGoodsName(element.getName());
					order.setGoodsImg(element.getImg());
					order.setGoodsSource(2);//1平台2机构3服务商
					order.setOrgId(element.getOrgId());
					order.setGoodsCost(element.getCost());// 成本 set起拍价（如果是绝当品来拍卖，起拍价就是鉴定价）
					order.setGoodsPrice(element.getMaxAuction());//价格 set此物品最终中标价
					order.setPrice(element.getMaxAuction());
					order.setState(1);//中标后等待用户付款 订单状态 -1已取消1待付款2已付款3已发货4确认收货5已评价
					order.setIsBalance(0);// 未结算
					orderService.insert(order);
					//更新数量
//					element.setSoldOut(element.getSoldOut()+1);
//					if (element.getTotal() > 0 ){
//						element.setTotal(element.getTotal()-1);
//					}
//					goodsService.updateByPrimaryKey(element);
				}
			}
		}
	}*/



}
