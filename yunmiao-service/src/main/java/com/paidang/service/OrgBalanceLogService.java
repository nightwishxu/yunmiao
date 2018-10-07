package com.paidang.service;

import com.base.util.DateUtil;
import com.paidang.dao.OrgBalanceLogMapper;
import com.paidang.dao.model.OrgBalanceLog;
import com.paidang.dao.model.OrgBalanceLogExample;
import com.paidang.daoEx.OrgBalanceLogMapperEx;
import com.paidang.daoEx.model.OrgBalanceLogEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrgBalanceLogService {
	@Autowired
	private OrgBalanceLogMapper orgBalanceLogMapper;

	@Autowired
	private OrgBalanceLogMapperEx orgBalanceLogMapperEx;

	public int countByExample(OrgBalanceLogExample example) {
		return this.orgBalanceLogMapper.countByExample(example);
	}

	public OrgBalanceLog selectByPrimaryKey(Integer id) {
		return this.orgBalanceLogMapper.selectByPrimaryKey(id);
	}

	public List<OrgBalanceLog> selectByExample(OrgBalanceLogExample example) {
		return this.orgBalanceLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.orgBalanceLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(OrgBalanceLog record) {
		return this.orgBalanceLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(OrgBalanceLog record) {
		return this.orgBalanceLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(OrgBalanceLogExample example) {
		return this.orgBalanceLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(OrgBalanceLog record, OrgBalanceLogExample example) {
		return this.orgBalanceLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(OrgBalanceLog record, OrgBalanceLogExample example) {
		return this.orgBalanceLogMapper.updateByExample(record, example);
	}

	public int insert(OrgBalanceLog record) {
		return this.orgBalanceLogMapper.insert(record);
	}

	public int insertSelective(OrgBalanceLog record) {
		return this.orgBalanceLogMapper.insertSelective(record);
	}

	public List<OrgBalanceLogEx> getCapitalRunningAccountList(Integer orgId,Date beginDate,Date endDate){
		return orgBalanceLogMapperEx.getCapitalRunningAccountList(orgId,beginDate,endDate);
	}

	/**
	 * 机构资金流水记录插入信息
	 * @param orgId  机构id
	 * @param totalMoeny    金额
	 * @param type  1支出  2收入
	 * @param item  1用户典当  2用户续当
	 * @param pawnTicketCode    当号
	 * @param fid  典当表id
	 * @param tradeType  0余额1支付宝2微信10线下银行卡 --10
	 * @param bankCardName  银行名称
	 * @param bankCardNo    银行卡
	 * @param platformImage     用户续当凭证
	 * @param userid    用户id
	 * @param userName  用户姓名
	 * @param userPhone 用户手机号
	 * @param date  续当开始时间--上一期结束时间
	 * @param pawnTime  续当时间
	 */
	public void updateOrgBalanceLog(Integer orgId,
												BigDecimal totalMoeny,
												int type,
												int item,
												String pawnTicketCode,
												Integer fid,
												int tradeType,
												String bankCardName,
												String bankCardNo,
												String platformImage,
												Integer userid,
												String userName,
												String userPhone,
												Date date,
												Integer pawnTime) {
		OrgBalanceLog orgBalanceLog = new OrgBalanceLog();
		orgBalanceLog.setOrgId(orgId);
		orgBalanceLog.setMoney(totalMoeny);
		orgBalanceLog.setType(type);
		orgBalanceLog.setItem(item+"");
		orgBalanceLog.setPawnCode(pawnTicketCode);
		orgBalanceLog.setFid(fid);
		orgBalanceLog.setTradeType(tradeType);
		orgBalanceLog.setTradeCardBank(bankCardName);
		orgBalanceLog.setTradeCardCode(bankCardNo);
		orgBalanceLog.setTradeTicket(platformImage);
		orgBalanceLog.setUserId(userid);
		orgBalanceLog.setUserName(userName);
		orgBalanceLog.setUserPhone(userPhone);
		orgBalanceLog.setBeginTime(date);

		//计算续当时间
		int continueTime = pawnTime * 15;
		orgBalanceLog.setEndTime(DateUtil.strToDate(DateUtil.getAddDaysDate(date,continueTime)));
		insert(orgBalanceLog);
	}
}
