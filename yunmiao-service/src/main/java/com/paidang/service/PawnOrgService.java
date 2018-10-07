package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.api.view.orgHome.OrgIntroduction;
import com.base.des.Md5;
import com.item.dao.model.Admin;
import com.item.dao.model.AdminExample;
import com.paidang.daoEx.PawnOrgMapperEx;
import com.paidang.daoEx.model.PawnOrgEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.PawnOrgMapper;
import com.paidang.dao.model.PawnOrg;
import com.paidang.dao.model.PawnOrgExample;

@Service
public class PawnOrgService {
	@Autowired
	private PawnOrgMapper pawnOrgMapper;
	@Autowired
	private PawnOrgMapperEx pawnOrgMapperEx;

	public int countByExample(PawnOrgExample example) {
		return this.pawnOrgMapper.countByExample(example);
	}

	public PawnOrg selectByPrimaryKey(Integer id) {
		return this.pawnOrgMapper.selectByPrimaryKey(id);
	}

	public List<PawnOrg> selectByExample(PawnOrgExample example) {
		return this.pawnOrgMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.pawnOrgMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(PawnOrg record) {
		return this.pawnOrgMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PawnOrg record) {
		return this.pawnOrgMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(PawnOrgExample example) {
		return this.pawnOrgMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(PawnOrg record, PawnOrgExample example) {
		return this.pawnOrgMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(PawnOrg record, PawnOrgExample example) {
		return this.pawnOrgMapper.updateByExample(record, example);
	}

	public int insert(PawnOrg record) {
		return this.pawnOrgMapper.insert(record);
	}

	public int insertSelective(PawnOrg record) {
		return this.pawnOrgMapper.insertSelective(record);
	}

	public PawnOrg login(String account, String password)throws Exception{
		PawnOrgExample example = new PawnOrgExample();
		example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
		List<PawnOrg> list = pawnOrgMapper.selectByExample(example);
		if (list == null || list.size() == 0){
			return null;
		}else {
			return list.get(0);
		}
	}

	public int changePwd(Integer id, String password) throws Exception {
		PawnOrg admin = new PawnOrg();
		admin.setId(id);
		admin.setPassword(Md5.md5(password));
		return pawnOrgMapper.updateByPrimaryKeySelective(admin);
	}

	//公司（机构）简介
	public OrgIntroduction getOrgIntroduction(Integer orgId){
		PawnOrgEx pawnOrgEx= this.pawnOrgMapperEx.getOrgIntroduction(orgId);
		OrgIntroduction orgIntroduction = new OrgIntroduction();
		orgIntroduction.setOrgId(pawnOrgEx.getId().toString());
		orgIntroduction.setAddress(pawnOrgEx.getAdress());
		orgIntroduction.setOrgImages(pawnOrgEx.getOrgImages());
		orgIntroduction.setLagalPerson(pawnOrgEx.getLegalPerson());
		orgIntroduction.setOrgName(pawnOrgEx.getName());
		orgIntroduction.setRegisteredCapital(pawnOrgEx.getRegisteredCapital());
		orgIntroduction.setIntroduction(pawnOrgEx.getIntroduction());
		orgIntroduction.setDealAmount(pawnOrgEx.getDealAmount());
		return  orgIntroduction;
	}

	public List<PawnOrgEx> selectList(Map<String, Object> map) {
		return pawnOrgMapperEx.selectList(map);
	}

	//机构端个人资料
	public PawnOrgEx selectById(String orgUserId){
		return pawnOrgMapperEx.selectById(orgUserId);
	}

	public Integer changeState(PawnOrg pawnOrg){
		return pawnOrgMapperEx.changeState(pawnOrg);
	}
}
