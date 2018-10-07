package com.paidang.service;

import java.math.BigDecimal;
import java.util.List;

import com.paidang.daoEx.model.UserBalanceLogEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.UserBalanceLogMapper;
import com.paidang.dao.model.UserBalanceLog;
import com.paidang.dao.model.UserBalanceLogExample;

@Service
public class UserBalanceLogService {
	@Autowired
	private UserBalanceLogMapper userBalanceLogMapper;

	public int countByExample(UserBalanceLogExample example) {
		return this.userBalanceLogMapper.countByExample(example);
	}

	public UserBalanceLog selectByPrimaryKey(Integer id) {
		return this.userBalanceLogMapper.selectByPrimaryKey(id);
	}

	public List<UserBalanceLog> selectByExample(UserBalanceLogExample example) {
		return this.userBalanceLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userBalanceLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserBalanceLog record) {
		return this.userBalanceLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserBalanceLog record) {
		return this.userBalanceLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserBalanceLogExample example) {
		return this.userBalanceLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserBalanceLog record, UserBalanceLogExample example) {
		return this.userBalanceLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserBalanceLog record, UserBalanceLogExample example) {
		return this.userBalanceLogMapper.updateByExample(record, example);
	}

	public int insert(UserBalanceLog record) {
		return this.userBalanceLogMapper.insert(record);
	}

	public int insertSelective(UserBalanceLog record) {
		return this.userBalanceLogMapper.insertSelective(record);
	}

	/**
	 *用户余额日志插入信息
	 * @param userid
	 * @param cid  藏品或者是典当续当id
	 * @param totalMoeny  金额
	 * @param type 1增 2减
	 * @param item 项目 1典当  2续当  3赎当 4交易 5卖给平台
	 * @param tradeType 0余额1支付宝2微信10线下银行卡
	 * @param tradeNo 支付宝微信流水号(线下打款当号)
	 * @param platformImage 线下打款凭证
	 * @param bankName  银行名称
	 * @param bankCard  交易所用银行卡号
	 * @param orgId  机构id
	 * @param orgName  机构名称
	 * @param orgPhone  机构联系电话
	 */
	public void updateUserBalanceLog(Integer userid,
												 Integer cid,
												 BigDecimal totalMoeny,
												 int type,
												 int item,
												 int tradeType,
												 String tradeNo,
												 String platformImage,
												 String bankName,
												 String bankCard,
												 Integer orgId,
												 String orgName,
												 String orgPhone) {
		UserBalanceLog userBalanceLog = new UserBalanceLog();
		userBalanceLog.setUserId(userid);
		userBalanceLog.setCid(cid);
		userBalanceLog.setAmount(totalMoeny);
		userBalanceLog.setType(type);
		userBalanceLog.setItem(item+"");
		userBalanceLog.setTradeType(tradeType);
		userBalanceLog.setTradeNo(tradeNo);
		userBalanceLog.setTradeTicket(platformImage);
		userBalanceLog.setTradeCardBank(bankName);
		userBalanceLog.setTradeCardCode(bankCard);
		userBalanceLog.setOrgId(orgId);
		userBalanceLog.setOrgName(orgName);
		userBalanceLog.setOrgPhone(orgPhone);
		insert(userBalanceLog);
	}

}
