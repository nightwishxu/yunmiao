package com.item.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.OpenImUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.web.annotation.LoginMethod;
import com.item.dao.MobileVerifyMapper;
import com.item.dao.UserMapper;
import com.item.dao.model.User;
import com.item.dao.model.UserExample;
import com.item.daoEx.UserMapperEx;
import com.item.daoEx.model.UserEx;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserMapperEx userMapperEx;
	@Autowired
	private MobileVerifyMapper verifyMapper;
	@Autowired
	private NotifyService notifyService;

	public int countByExample(UserExample example) {
		return this.userMapper.countByExample(example);
	}

	public User selectByPrimaryKey(Integer id) {
		return this.userMapper.selectByPrimaryKey(id);
	}

	public List<User> selectByExample(UserExample example) {
		return this.userMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(User record) {
		return this.userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return this.userMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserExample example) {
		return this.userMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(User record, UserExample example) {
		return this.userMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(User record, UserExample example) {
		return this.userMapper.updateByExample(record, example);
	}

	public int insert(User record) {
		int i = this.userMapper.insert(record);
		notifyService.insertNewUser(record.getId());
		//OpenImUtil.add(record.getId()+"",record.getId()+"");
		return i;
	}

	public int insertSelective(User record) {
		int i =  this.userMapper.insertSelective(record);
		notifyService.insertNewUser(record.getId());
		//OpenImUtil.add(record.getId()+"",record.getId()+"");
		return i;
	}

	public void updateBalance(String userId, BigDecimal goodsTotal) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", userId);
		map.put("num", goodsTotal);
		userMapperEx.updateBalance(map);
	}

	public List<UserEx> selectList(Map<String, Object> map) {
		return userMapperEx.selectList(map);
	}
	
	public List<Integer> selectIdByAccounts(List<String> accounts){
		return userMapperEx.selectIdByAccounts(accounts);
	}
	
	public Integer selectIdByAccount(String account){
		return userMapperEx.selectIdByAccount(account);
	}
	
	public String selectAccountById(String id){
		return userMapperEx.selectAccountById(id);
	}
	
    public boolean autoH5Login(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		Cookie c = null;
		String account = "";
		String pwd = "";
		for (int i = 0; cookies!=null && i < cookies.length; i++){
			c = cookies[i];
			if (c.getName().equals("account")){
				account = c.getValue();
			}else if(c.getName().equals("pwd")){
				pwd = c.getValue();
			}
		}
		if(account.length()>0 && pwd.length()>0){
			UserExample example = new UserExample();
			example.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(pwd);
			List<User> list = this.selectByExample(example);
			if(list.size()>0){
				User user = list.get(0);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", user.getId());
				map.put("account", user.getAccount());
				request.getSession().setAttribute(LoginMethod.PHONE.getName(), map);
				return true;
			}
		}
    	return false;
    }


    public User queryByOpenId(String openId){
		UserExample example=new UserExample();
		example.createCriteria().andXcxIdEqualTo(openId).andStatusNotEqualTo(0);
		List<User> list=userMapper.selectByExample(example);
		if (list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 查看用户粉丝
	 * @param userId
	 * @return
	 */
	public List<UserEx> getUserFollow(Integer userId){
		return userMapperEx.getUserFollow(userId);
	}



	/**
	 * 返回自己关注人也关注的人
	 * @param userId
	 * @return
	 */
	public List<UserEx> getUserFollowInterest(Integer userId){
		return userMapperEx.getUserFollowInterest(userId);
	}


	/**
	 * 根据粉丝数量排序
	 * @param userId
	 * @return
	 */
	public List<UserEx> getUserFollowInterestByFans(Integer userId){
		return userMapperEx.getUserFollowInterestByFans(userId);
	}

}