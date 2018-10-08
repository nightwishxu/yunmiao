package com.item.service;

import java.util.List;

import com.item.dao.model.UserFollow;
import com.item.dao.model.UserFollowExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.UserBlackMapper;
import com.item.dao.model.UserBlack;
import com.item.dao.model.UserBlackExample;

@Service
public class UserBlackService {
	@Autowired
	private UserBlackMapper userBlackMapper;

	public int countByExample(UserBlackExample example) {
		return this.userBlackMapper.countByExample(example);
	}

	public UserBlack selectByPrimaryKey(Integer id) {
		return this.userBlackMapper.selectByPrimaryKey(id);
	}

	public List<UserBlack> selectByExample(UserBlackExample example) {
		return this.userBlackMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userBlackMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserBlack record) {
		return this.userBlackMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserBlack record) {
		return this.userBlackMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserBlackExample example) {
		return this.userBlackMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserBlack record, UserBlackExample example) {
		return this.userBlackMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserBlack record, UserBlackExample example) {
		return this.userBlackMapper.updateByExample(record, example);
	}

	public int insert(UserBlack record) {
		return this.userBlackMapper.insert(record);
	}

	public int insertSelective(UserBlack record) {
		return this.userBlackMapper.insertSelective(record);
	}


	/**
	 * 判断自己是否被拉黑
	 * @param userId
	 * @param operateUserId
	 * @return
	 */
	public Integer isBlackUser(Integer userId,Integer operateUserId){
		UserBlackExample example=new UserBlackExample();
		example.createCriteria().andUserIdEqualTo(operateUserId).andBackUserIdEqualTo(userId);
		List<UserBlack> list=userBlackMapper.selectByExample(example);
		if (list!=null && list.size()>0){
			return list.size();
		}else {
			return 0;
		}
	}
}
