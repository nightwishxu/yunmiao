package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.PawnContinueMapperEx;
import com.paidang.daoEx.model.PawnContinueEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.PawnContinueMapper;
import com.paidang.dao.model.PawnContinue;
import com.paidang.dao.model.PawnContinueExample;

@Service
public class PawnContinueService {
	@Autowired
	private PawnContinueMapper pawnContinueMapper;
	@Autowired
	private PawnContinueMapperEx pawnContinueMapperEx;

	public int countByExample(PawnContinueExample example) {
		return this.pawnContinueMapper.countByExample(example);
	}

	public PawnContinue selectByPrimaryKey(Integer id1) {
		return this.pawnContinueMapper.selectByPrimaryKey(id1);
	}

	public List<PawnContinue> selectByExample(PawnContinueExample example) {
		return this.pawnContinueMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id1) {
		return this.pawnContinueMapper.deleteByPrimaryKey(id1);
	}

	public int updateByPrimaryKeySelective(PawnContinue record) {
		return this.pawnContinueMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PawnContinue record) {
		return this.pawnContinueMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PawnContinueExample example) {
		return this.pawnContinueMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PawnContinue record, PawnContinueExample example) {
		return this.pawnContinueMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PawnContinue record, PawnContinueExample example) {
		return this.pawnContinueMapper.updateByExample(record, example);
	}

	public int insert(PawnContinue record) {
		return this.pawnContinueMapper.insert(record);
	}

	public int insertSelective(PawnContinue record) {
		return this.pawnContinueMapper.insertSelective(record);
	}

	//查看 续当当票
	public List<PawnContinueEx> getRepawnTickInfo(String pawnId){
		return this.pawnContinueMapperEx.getRepawnTickInfo(pawnId);
	}

	//返回指定pawnId办理过的续当次数(办理过:机构确认过用户打款凭证)
	public int getRepawnTimes(Integer pawnId){
		PawnContinueExample pawnContinueExample = new PawnContinueExample();
	//	pawnContinueExample.createCriteria().andPawnIdEqualTo(pawnId);
		pawnContinueExample.createCriteria().andPawnIdEqualTo(pawnId).andStateEqualTo(4);
		return pawnContinueMapper.countByExample(pawnContinueExample);
	}
}
