package com.item.service;

import java.util.List;

import com.item.daoEx.ArticleMapperEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.WxUserInfoMapper;
import com.item.dao.model.WxUserInfo;
import com.item.dao.model.WxUserInfoExample;

@Service
public class WxUserInfoService {
	@Autowired
	private WxUserInfoMapper wxUserInfoMapper;
	@Autowired
	private ArticleMapperEx articleMapperEx;

	public int countByExample(WxUserInfoExample example) {
		return this.wxUserInfoMapper.countByExample(example);
	}

	public WxUserInfo selectByPrimaryKey(Integer user_id) {
		return this.wxUserInfoMapper.selectByPrimaryKey(user_id);
	}

	public List<WxUserInfo> selectByExample(WxUserInfoExample example) {
		return this.wxUserInfoMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer user_id) {
		return this.wxUserInfoMapper.deleteByPrimaryKey(user_id);
	}

	public int updateByPrimaryKeySelective(WxUserInfo record) {
		return this.wxUserInfoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(WxUserInfo record) {
		return this.wxUserInfoMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(WxUserInfoExample example) {
		return this.wxUserInfoMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(WxUserInfo record, WxUserInfoExample example) {
		return this.wxUserInfoMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(WxUserInfo record, WxUserInfoExample example) {
		return this.wxUserInfoMapper.updateByExample(record, example);
	}

	public int insert(WxUserInfo record) {
		return this.wxUserInfoMapper.insert(record);
	}

	public int insertSelective(WxUserInfo record) {
		return this.wxUserInfoMapper.insertSelective(record);
	}

	/**
	 * 更新动态数量
	 * @param userId
	 * @return
	 */
	public Integer updateArticleCount(Integer userId){
		WxUserInfo info=new WxUserInfo();
		info.setUserId(userId);
		info.setArticleCount(articleMapperEx.getArticleCount(userId));
		return wxUserInfoMapper.updateByPrimaryKeySelective(info);
	}
}
