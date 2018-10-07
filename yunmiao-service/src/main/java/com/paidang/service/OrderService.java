package com.paidang.service;

import com.base.entity.QueryParams;
import com.item.service.BaseService;
import com.paidang.dao.OrderMapper;
import com.paidang.dao.OrgBalanceLogMapper;
import com.paidang.dao.PlatformBalanceLogMapper;
import com.paidang.dao.model.Order;
import com.paidang.dao.model.OrderExample;
import com.paidang.dao.model.OrgBalanceLog;
import com.paidang.dao.model.PlatformBalanceLog;
import com.paidang.daoEx.OrderMapperEx;
import com.paidang.daoEx.model.OrderEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderMapperEx orderMapperEx;
	@Autowired
	private BaseService baseService;
	@Autowired
	private OrgBalanceLogMapper orgBalanceLogMapper;
	@Autowired
	private PlatformBalanceLogMapper platformBalanceLogMapper;


	public int countByExample(OrderExample example) {
		return this.orderMapper.countByExample(example);
	}

	public Order selectByPrimaryKey(Integer id) {
		return this.orderMapper.selectByPrimaryKey(id);
	}

	public List<Order> selectByExample(OrderExample example) { return this.orderMapper.selectByExample(example); }

	public int deleteByPrimaryKey(Integer id) {
		return this.orderMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Order record) {
		return this.orderMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Order record) {
		return this.orderMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(OrderExample example) {
		return this.orderMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Order record, OrderExample example) {
		return this.orderMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(Order record, OrderExample example) {
		return this.orderMapper.updateByExample(record, example);
	}

	public int insert(Order record) {
		return this.orderMapper.insert(record);
	}

	public int insertSelective(Order record) {
		return this.orderMapper.insertSelective(record);
	}

	public List<OrderEx> selectOrderList(QueryParams.Builder builder){
		return this.orderMapperEx.selectOrderList(builder);
	}
	//机构端后台绝当订单
	public List<OrderEx> getOrgOrderList(QueryParams.Builder builder){
		return this.orderMapperEx.getOrgOrderList(builder);
	}

	public int updateState(Order order) {
		return this.orderMapperEx.updateState(order);
	}

	public OrderEx selectByKey(Integer id) {
		return this.orderMapperEx.selectByKey(id);
	}

	/**
	 * 确认收货
	 * @param id
	 * @return
	 */
	public void confirmOrder(int id){
		Order order = orderMapper.selectByPrimaryKey(id);
		if (order == null){
			return;
		}
		if (order.getState() != 3){
			return;
		}
		//更新状态
		Order update = new Order();
		update.setId(id);
		update.setState(4);
		orderMapper.updateByPrimaryKeySelective(update);
		BigDecimal platform = BigDecimal.ZERO;
		//如果是机构或服务商
		if (order.getGoodsSource() != 1){
			BigDecimal money = BigDecimal.ZERO;
			if (order.getGoodsSource()  == 2){
				money = order.getPrice();
			}else if (order.getGoodsSource() == 3){
				money = order.getGoodsCost();
				//平台收入
//				if(order.getCouponValue() != null){
//					platform = order.getPrice().subtract(money).subtract(order.getCouponValue());
//				}else{
//					platform = order.getPrice().subtract(money);
//				}
				platform = order.getPrice().subtract(money);

				if (platform.compareTo(BigDecimal.ZERO) < 0){
					platform = BigDecimal.ZERO;
				}
				PlatformBalanceLog balanceLog = new PlatformBalanceLog();
				balanceLog.setAmount(platform);
				balanceLog.setItem("认证商城");
				balanceLog.setInfo("认证商城发生交易,收入:"+platform.toString());
				balanceLog.setFid(order.getId());
				platformBalanceLogMapper.insert(balanceLog);
			}
			//更新余额
			baseService.updateNumById("p_pawn_org","balance",money,id);
			//机构余额日志
			OrgBalanceLog balanceLog = new OrgBalanceLog();
			balanceLog.setFid(order.getId());
			balanceLog.setType(2);
			balanceLog.setItem("3");
			balanceLog.setInfo("用户确认收货");
			balanceLog.setMoney(money);
			balanceLog.setTradeType(0);
			balanceLog.setUserId(order.getUserId());
			balanceLog.setOrgId(order.getOrgId());
			this.orgBalanceLogMapper.insertSelective(balanceLog);
		}else{

		}

	}

    public List<OrderEx> selectMyStoreOrderList(Map<String, Object> map) {
		return this.orderMapperEx.selectMyStoreOrderList(map);
    }

    public List<OrderEx> selectByTask(Map<String, Object> map) {
		return this.orderMapperEx.selectByTask(map);
    }

	public List<OrderEx> selectOrderAdminList(Map<String, Object> map) {
		return this.orderMapperEx.selectOrderAdminList(map);
	}

	public List<OrderEx> selectRelease() {
		return this.orderMapperEx.selectRelease();
	}

	public int updateOrderList(List<OrderEx> list) {
		return this.orderMapperEx.updateOrderList(list);
	}

	public int updateGoodsList(List<OrderEx> list) {
		return this.orderMapperEx.updateGoodsList(list);
	}
}
