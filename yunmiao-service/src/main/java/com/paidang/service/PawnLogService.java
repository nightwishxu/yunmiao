package com.paidang.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.paidang.daoEx.PawnLogMapperEx;
import com.paidang.daoEx.model.PawnLogEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.PawnLogMapper;
import com.paidang.dao.model.PawnLog;
import com.paidang.dao.model.PawnLogExample;

@Service
public class PawnLogService {
	@Autowired
	private PawnLogMapper pawnLogMapper;
	@Autowired
	private PawnLogMapperEx pawnLogMapperEx;

	public int countByExample(PawnLogExample example) {
		return this.pawnLogMapper.countByExample(example);
	}

	public PawnLog selectByPrimaryKey(Integer id) {
		return this.pawnLogMapper.selectByPrimaryKey(id);
	}

	public List<PawnLog> selectByExample(PawnLogExample example) {
		return this.pawnLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.pawnLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PawnLog record) {
		return this.pawnLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PawnLog record) {
		return this.pawnLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PawnLogExample example) {
		return this.pawnLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PawnLog record, PawnLogExample example) {
		return this.pawnLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PawnLog record, PawnLogExample example) {
		return this.pawnLogMapper.updateByExample(record, example);
	}

	public int insert(PawnLog record) {
		return this.pawnLogMapper.insert(record);
	}
	public int updatePawnByid(PawnLog record) {
		return this.pawnLogMapperEx.updatePawnByid(record);
	}

	public int insertSelective(PawnLog record) {
		return this.pawnLogMapper.insertSelective(record);
	}

	/**
	 *拍档记录表
	 * @param goods_id  藏品id
	 * @param user_id  用户
	 * @param org_id  机构id
	 * @param goods_name  藏品名称
	 * @param auth_price  鉴定价格
	 * @param goods_cate  藏品类别
	 * @param goods_cate_id  藏品类别id
	 * @param org_name  机构名称
	 * @param money  金额
	 * @param pawn_month  时间
	 * @param type  0鉴定真品1典当2续当3赎当4绝当5交易6卖给平台
	 * @param user_name  用户姓名
	 * @param trade_card_bank  银行
	 * @param trade_card_code  交易所用银行卡卡号
	 * @param                            
	 * @return
	 */
	public void updatePawnlog(Integer goods_id,
							  Integer user_id,
							  Integer org_id,
							  String goods_name,
							  BigDecimal auth_price,
							  String goods_cate,
							  Integer goods_cate_id,
							  String org_name,
							  BigDecimal money,
							  Integer pawn_month,
							  Integer type,
							  String user_name,
							  String trade_card_bank,
							  String trade_card_code){
		PawnLog pawnLog = new PawnLog();
		pawnLog.setGoodsId(goods_id);
		pawnLog.setUserId(user_id);
		if(null != org_id){
			pawnLog.setOrgId(org_id);
		}
		pawnLog.setGoodsName(goods_name);
		pawnLog.setAuthPrice(auth_price);
		pawnLog.setGoodsCateId(goods_cate_id);
		pawnLog.setGoodsCate(goods_cate);
		pawnLog.setOrgName(org_name);
		pawnLog.setMoney(money);
		if(null != pawn_month){
			pawnLog.setPawnMonth(pawn_month);
		}
		pawnLog.setType(type);
		pawnLog.setUserName(user_name);
		pawnLog.setTradeCardBank(trade_card_bank);
		pawnLog.setTradeCardCode(trade_card_code);
		insert(pawnLog);
	}

    public List<PawnLogEx> selectTradeRecordList(Map<String, Object> map) {
		return this.pawnLogMapperEx.selectTradeRecordList(map);
    }
}
