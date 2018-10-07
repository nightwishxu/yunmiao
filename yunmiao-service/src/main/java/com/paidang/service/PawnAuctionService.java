package com.paidang.service;

import com.paidang.dao.PawnAuctionMapper;
import com.paidang.dao.model.PawnAuction;
import com.paidang.dao.model.PawnAuctionExample;
import com.paidang.daoEx.PawnAuctionMapperEx;
import com.paidang.daoEx.model.PawnAuctionEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PawnAuctionService {
	@Autowired
	private PawnAuctionMapper pawnAuctionMapper;

	@Autowired
	private PawnAuctionMapperEx pawnAuctionMapperEx;

	public int countByExample(PawnAuctionExample example) {
		return this.pawnAuctionMapper.countByExample(example);
	}

	public PawnAuction selectByPrimaryKey(Integer id) {
		return this.pawnAuctionMapper.selectByPrimaryKey(id);
	}

	public List<PawnAuction> selectByExample(PawnAuctionExample example) {
		return this.pawnAuctionMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.pawnAuctionMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PawnAuction record) {
		return this.pawnAuctionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PawnAuction record) {
		return this.pawnAuctionMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PawnAuctionExample example) {
		return this.pawnAuctionMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PawnAuction record, PawnAuctionExample example) {
		return this.pawnAuctionMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PawnAuction record, PawnAuctionExample example) {
		return this.pawnAuctionMapper.updateByExample(record, example);
	}

	public int insert(PawnAuction record) {
		return this.pawnAuctionMapper.insert(record);
	}

	public int insertSelective(PawnAuction record) {
		return this.pawnAuctionMapper.insertSelective(record);
	}

	//获得指定pawnId对应的竞拍记录
	public List<PawnAuctionEx> getAuctionDetailsByPawnId(String pawnId){
		return pawnAuctionMapperEx.getAuctionDetailsByPawnId(pawnId);
	}

	//返回上面接口【getAuctionDetailsByPawnId】结果集中，费率最低的一条记录，费率同样低，选择其中典当成交量多的
	//成交量一样多时，选择利率最低的，利率一样低时，选择最先下单的机构为系统推荐中标机构
	public PawnAuctionEx getSysRecommendOne(String pawnId){
		List<PawnAuctionEx> auction_results = this.getAuctionDetailsByPawnId(pawnId);
		BigDecimal minRate = null;
		List<PawnAuctionEx> minRates = new ArrayList<>();
		for (int i = 0; i < auction_results.size(); i++) {
			PawnAuctionEx temp = auction_results.get(i);
			if (temp.getRate() == null){
				continue;
			}
			if (minRate == null){
				minRate = temp.getRate();
				minRates.add(temp);
				continue;
			}
			if(temp.getRate().compareTo(minRate) < 0){
				minRate = temp.getRate();
				minRates.removeAll(minRates);
				minRates.add(temp);
				continue;
			}
			if(temp.getRate().compareTo(minRate) == 0){
				minRate = temp.getRate();
				minRates.add(temp);
			}
		}
		if (minRates.size() == 1){
			return minRates.get(0);// 费率最低的一个返回
		}

		Integer cnt = null;
		List<PawnAuctionEx> cntBigests = new ArrayList<>();
		for (int j = 0; j < minRates.size(); j++) {
			if ( j == 0){
				cnt = minRates.get(j).getPawnCount();
				cntBigests.add(minRates.get(j));
				continue;
			}
			if (minRates.get(j).getPawnCount() > cnt){
				cnt = minRates.get(j).getPawnCount();
				cntBigests.removeAll(cntBigests);
				cntBigests.add(minRates.get(j));
				continue;
			}
			if (minRates.get(j).getPawnCount() == cnt){
				cnt = minRates.get(j).getPawnCount();
				cntBigests.add(minRates.get(j));
			}
		}
		if (cntBigests.size() == 1){
			return cntBigests.get(0);//费率一样低，返回典当成交订单最多的
		}

		BigDecimal minMoneyRate = null;
		List<PawnAuctionEx> minMoneyRates = new ArrayList<>();
		for (int k = 0; k < cntBigests.size(); k++) {
			PawnAuctionEx temp = auction_results.get(k);
			if (temp.getMoneyRate() == null){
				continue;
			}
			if (minMoneyRate == null){
				minMoneyRate = temp.getMoneyRate();
				minMoneyRates.add(temp);
				continue;
			}
			if(temp.getMoneyRate().compareTo(minMoneyRate) < 0){
				minMoneyRate = temp.getMoneyRate();
				minMoneyRates.removeAll(minMoneyRates);
				minMoneyRates.add(temp);
				continue;
			}
			if(temp.getMoneyRate().compareTo(minMoneyRate) == 0){
				minMoneyRate = temp.getMoneyRate();
				minMoneyRates.add(temp);
			}
		}
		if (minMoneyRates.size() == 1){
			return minMoneyRates.get(0);//典当成交订单一样多，返回利率最低的
		}

		Date bidTime = null;
		List<PawnAuctionEx> firstBids = new ArrayList<>();
		for (int l = 0; l < minMoneyRates.size(); l++) {
			PawnAuctionEx temp = auction_results.get(l);
			if (temp.getCreateTime() == null){
				continue;
			}
			if (bidTime == null){
				bidTime = temp.getCreateTime();
				firstBids.add(temp);
				continue;
			}
			if(temp.getCreateTime().compareTo(bidTime) < 0){
				bidTime = temp.getCreateTime();
				firstBids.removeAll(firstBids);
				firstBids.add(temp);
				continue;
			}
			if(temp.getCreateTime().compareTo(bidTime) == 0){
				bidTime = temp.getCreateTime();
				firstBids.add(temp);
			}
		}
		if (firstBids.size()==1){
			return firstBids.get(0);//利率都一样低，返回最先竞拍的
		}
		return null;
	}

	//获取在对指定id的当品竞拍过程中指定id的机构的出价信息（包括上次出价价格，费率，利率，出价人和我（登陆机构）之前出价次数）
	public PawnAuctionEx getPreviousBidInfo(String pawnId,String orgId){
		return pawnAuctionMapperEx.getPreviousBidInfo(pawnId, orgId);
	}
	//获得给定id的机构所竞拍的 所有 当品id(过滤重复)
	public List<String> getMyBidPawnIdByOrgId(String orgId){
		return pawnAuctionMapperEx.getMyBidPawnIdByOrgId(orgId);
	}

	//参与对pawId竞拍的所有机构总数
	public Integer getAllBidOrgCount(int pawnId){
		return pawnAuctionMapperEx.getAllBidOrgCount(pawnId);
	}

	public Integer selectCount(Integer id) {
		return pawnAuctionMapperEx.selectCount(id);
	}
}
