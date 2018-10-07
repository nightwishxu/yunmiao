package com.paidang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.PawnCateMapper;
import com.paidang.dao.model.PawnCate;
import com.paidang.dao.model.PawnCateExample;

@Service
public class PawnCateService {
	@Autowired
	private PawnCateMapper pawnCateMapper;

	public int countByExample(PawnCateExample example) {
		return this.pawnCateMapper.countByExample(example);
	}

	public PawnCate selectByPrimaryKey(Integer id) {
		return this.pawnCateMapper.selectByPrimaryKey(id);
	}

	public List<PawnCate> selectByExample(PawnCateExample example) {
		return this.pawnCateMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.pawnCateMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PawnCate record) {
		return this.pawnCateMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PawnCate record) {
		return this.pawnCateMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PawnCateExample example) {
		return this.pawnCateMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PawnCate record, PawnCateExample example) {
		return this.pawnCateMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PawnCate record, PawnCateExample example) {
		return this.pawnCateMapper.updateByExample(record, example);
	}

	public int insert(PawnCate record) {
		return this.pawnCateMapper.insert(record);
	}

	public int insertSelective(PawnCate record) {
		return this.pawnCateMapper.insertSelective(record);
	}

}
