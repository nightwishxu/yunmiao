package com.paidang.service;

import com.base.util.DateUtil;
import com.item.service.MessageService;
import com.paidang.dao.ExpressMapper;
import com.paidang.dao.OrderMapper;
import com.paidang.dao.UserGoodsMapper;
import com.paidang.dao.model.*;
import com.paidang.daoEx.ExpressMapperEx;
import com.paidang.daoEx.model.ExpressEx;
import com.util.PaidangConst;
import com.util.KuaidiApiUtil;
import com.util.express.core.KuaidiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpressService {
	@Autowired
	private ExpressMapper expressMapper;
	@Autowired
	private ExpressMapperEx expressMapperEx;
	@Autowired
	private UserGoodsMapper userGoodsMapper;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserGoodsService userGoodsService;
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private MessageService messageService;

	public int countByExample(ExpressExample example) {
		return this.expressMapper.countByExample(example);
	}

	public Express selectByPrimaryKey(Integer id) {
		return this.expressMapper.selectByPrimaryKey(id);
	}

	public List<Express> selectByExample(ExpressExample example) {
		return this.expressMapper.selectByExample(example);
	}

	public List<Express> selectByExampleWithBLOBs(ExpressExample example) {
		return this.expressMapper.selectByExampleWithBLOBs(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.expressMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Express record) {
		return this.expressMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(Express record) {
		return this.expressMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(Express record) {
		return this.expressMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(ExpressExample example) {
		return this.expressMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(Express record, ExpressExample example) {
		return this.expressMapper.updateByExampleSelective(record, example);
	}

	public int updateByExampleWithBLOBs(Express record, ExpressExample example) {
		return this.expressMapper.updateByExampleWithBLOBs(record, example);
	}

	public int updateByExample(Express record, ExpressExample example) {
		return this.expressMapper.updateByExample(record, example);
	}

	public int insert(Express record) {
		return this.expressMapper.insert(record);
	}

	public int insertSelective(Express record) {
		return this.expressMapper.insertSelective(record);
	}

	/**
	 * 未签收快递
	 * @return
	 */
	public List<ExpressEx> selectUnReceive(){
//		ExpressExample example = new ExpressExample();
//		example.or().andExpressStateNotBetween(3,4).andModifyTimeLessThanOrEqualTo(DateUtil.addMinute(new Date(),-PaidangConst.EXPRESS_QUERY_TIME));
//		example.or().andExpressStateNotBetween(3,4).andModifyTimeIsNull();
//		example.setOrderByClause("create_time desc");
//		return this.expressMapper.selectByExample(example);
		Map<String,Object> map=new HashMap<>();
		map.put("modifyTime",DateUtil.addMinute(new Date(),-PaidangConst.EXPRESS_QUERY_TIME));
		return expressMapperEx.findUnReceived(map);
	}

	/**
	 * 定时查询
	 */
	public void queryAuto(){
		//TODO 签收或者派送中，推送消息
		List<ExpressEx> expresses = this.selectUnReceive();
		for (ExpressEx express : expresses){
			KuaidiResult result = KuaidiApiUtil.query(express.getExpressName(),express.getExpressCode());
			express.setModifyTime(new Date());
			if (result != null){

				express.setExpressState(result.getState());
				express.setExpressData(result.toString());
				List<Integer> userId=new ArrayList<>();
				userId.add(express.getSourceId());
				if (result.getState() == 3){
					//已签收
					expressOk(express);
					//messageService.pushToList(userId,"您的快递已经被签收",1,"");
				}else if (result.getState()==5){

					//订单正在派件中
					//messageService.pushToSingleAccount();
					// messageService.pushToList(userId,"您的快递正在派送过程中",1,"");
				}
			}
			//更新快递状态
			expressMapper.updateByPrimaryKeySelective(express);

		}
	}

	public void expressOk(Express express){
		switch (express.getType()){
			case 1:
				//确认平台收货
				UserGoods post = new UserGoods();
				post.setId(express.getFid());
				post.setPostState(4);
				post.setLocation(1);
				userGoodsMapper.updateByPrimaryKeySelective(post);
				break;
			case 2:
				//确认取回
				UserGoods back = new UserGoods();
				back.setId(express.getFid());
				back.setBackState(3);
				back.setLocation(0);
				userGoodsMapper.updateByPrimaryKeySelective(back);
				break;
			case 3:
				//商城
				orderService.confirmOrder(express.getFid());
				break;
//			case 6:
//				Order record = new Order();
//				record.setPlatOrgState(3);
//				goodsMapper.updateByPrimaryKeySelective(record);
//				break;
			default:
				break;
		}
	}

	public Express queryByCode(String code){
		ExpressExample expressExample = new ExpressExample();
		expressExample.createCriteria().andExpressCodeEqualTo(code);
		List<Express> list = expressMapper.selectByExample(expressExample);
		return list.size() > 0? list.get(0):null;
	}

	public List<ExpressEx> selectByGoods(Map<String, Object> map) {
		return this.expressMapperEx.selectByGoods(map);
	}

	//搜索
	public List<ExpressEx> searchByName(String keyword,String orgId){
		return  expressMapperEx.searchByName(keyword,orgId);
	}

	//查询机构从平台处取回它的绝当品的快递数据，并更新对应字段
	public void updateOrgFetchBackExpress(){
		ExpressExample expressExample = new ExpressExample();
		expressExample.createCriteria().andTypeEqualTo(6);//所有的机构申请取回快递
		List<Express> expresses = this.selectByExample(expressExample);
		for (Express express:expresses) {
			KuaidiResult result = KuaidiApiUtil.query(express.getExpressName(),express.getExpressCode());
			if (result != null){
				express.setExpressState(result.getState());
				express.setExpressData(result.toString());
				if (result.getState() == 3){//如果快递查询接口出来表明机构已经签收，顺带更新p_user_goods表的对应状态
					UserGoods record = userGoodsService.selectByPrimaryKey(express.getFid());
					record.setPlatOrgState(3);
					userGoodsService.updateByPrimaryKey(record);
				}
			}
			expressMapper.updateByPrimaryKeySelective(express);
		}
	}

	//更新快递表机构/平台寄给当户的数据，并更新相应字段
	public void updateSendToWinnerExpress(){
		ExpressExample expressExample = new ExpressExample();
		expressExample.createCriteria().andTypeIn(new ArrayList<Integer>(){{add(4);add(5);}});//所有寄给当户的快递记录
		List<Express> expresses = this.selectByExample(expressExample);
		for (Express express:expresses) {
			KuaidiResult result = KuaidiApiUtil.query(express.getExpressName(),express.getExpressCode());
			if (result != null){
				express.setExpressState(result.getState());
				express.setExpressData(result.toString());
			}
			expressMapper.updateByPrimaryKeySelective(express);
		}
	}


}
