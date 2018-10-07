package com.paidang.service;

import com.base.api.ApiException;
import com.base.support.LogKit;
import com.base.util.StringUtil;
import com.item.dao.model.User;
import com.item.dao.model.UserExample;
import com.item.service.MessageService;
import com.item.service.UserService;
import com.paidang.dao.OrgNotifyMapper;
import com.paidang.dao.model.OrgNotify;
import com.paidang.dao.model.OrgNotifyExample;
import com.util.PaidangMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgNotifyService {
	@Autowired
	private OrgNotifyMapper orgNotifyMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;


	public int countByExample(OrgNotifyExample example) {
		return this.orgNotifyMapper.countByExample(example);
	}

	public OrgNotify selectByPrimaryKey(Integer id) {
		return this.orgNotifyMapper.selectByPrimaryKey(id);
	}

	public List<OrgNotify> selectByExample(OrgNotifyExample example) {
		return this.orgNotifyMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.orgNotifyMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(OrgNotify record) {
		return this.orgNotifyMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(OrgNotify record) {
		return this.orgNotifyMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(OrgNotifyExample example) {
		return this.orgNotifyMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(OrgNotify record, OrgNotifyExample example) {
		return this.orgNotifyMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(OrgNotify record, OrgNotifyExample example) {
		return this.orgNotifyMapper.updateByExample(record, example);
	}

	/*public int insert(OrgNotify record) {
		Integer orgId = record.getOrgId();
		UserExample userExample = new UserExample();
		userExample.createCriteria().andTypeEqualTo(1).andOrgIdEqualTo(orgId);
		List<User> users = userService.selectByExample(userExample);
		for (User user:users) {
			messageService.pushToSingleOrgSide(user.getId(), record.getContent(), record.getRedirectType(), record.getRedirectContent());
		}
		return this.orgNotifyMapper.insert(record);
	}*/

	public int insert(OrgNotify record) {
		Integer orgId = record.getOrgId();
		UserExample userExample = new UserExample();
//		userExample.createCriteria().andTypeEqualTo(1).andOrgIdEqualTo(orgId);
		List<User> users = userService.selectByExample(userExample);
		if (users == null || users.size() == 0)
			throw new ApiException("该机构下没有人员，无法推送！");
		String result = messageService.pushToOrgUsers(users, record.getContent(), record.getRedirectType(), record.getRedirectContent());
		LogKit.debug("===============OrgNotifyService.insert调用MessageService.pushToSingleOrgSide执行结果："+result+"=====================");
		return this.orgNotifyMapper.insert(record);
	}

	/*public int insertSelective(OrgNotify record) {
//		messageService.pushToSingle(record.getUserId(), record.getContent(), record.getRedirectType(), record.getRedirectContent());
		//推送给机构下每一个人
		Integer orgId = record.getOrgId();
		UserExample userExample = new UserExample();
		userExample.createCriteria().andTypeEqualTo(1).andOrgIdEqualTo(orgId);
		List<User> users = userService.selectByExample(userExample);
		for (User user:users) {
			LogKit.debug("===============OrgNotifyService/insertSelective"+"推送机构人员对象id：userId"+user.getId()+"==================");
			String result = messageService.pushToSingleOrgSide(user.getId(), record.getContent(), record.getRedirectType(), record.getRedirectContent());
			LogKit.debug("===============OrgNotifyService.insertSelective调用messageService.pushToSingleOrgSide执行结果："+result+"=====================");
		}
		return this.orgNotifyMapper.insertSelective(record);
	}*/


	public int insertSelective(OrgNotify record) {
//		messageService.pushToSingle(record.getUserId(), record.getContent(), record.getRedirectType(), record.getRedirectContent());
		//推送给机构下每一个人
		Integer orgId = record.getOrgId();
		UserExample userExample = new UserExample();
//		userExample.createCriteria().andTypeEqualTo(1).andOrgIdEqualTo(orgId);
		List<User> users = userService.selectByExample(userExample);
		if (users == null || users.size() == 0)
			throw new ApiException("该机构下没有人员，无法推送！");
		String result = messageService.pushToOrgUsers(users, record.getContent(), record.getRedirectType(), record.getRedirectContent());
		LogKit.debug("===============OrgNotifyService.insertSelective调用MessageService.pushToSingleOrgSide执行结果："+result+"=====================");
		//insert OrgNotify
		return this.orgNotifyMapper.insertSelective(record);
	}

	/**
	 *
	 * @param orgId
	 * @param message 通知消息模板
	 * @param params
	 * @return
	 */
	public int insertByTemplate(Integer orgId, String redirectContent, PaidangMessage message, String... params){
		OrgNotify userNotify = new OrgNotify();
		userNotify.setIsRead(0);
		userNotify.setRedirectType(message.getRedirectType());
		userNotify.setTitle(message.getTitle());
		userNotify.setType(message.getType());
		userNotify.setOrgId(orgId);
		userNotify.setContent(StringUtil.format(message.getTemplate(),params));
		userNotify.setRedirectContent(redirectContent);
		LogKit.debug("===============OrgNotifyService.insertByTemplate"+"推送机构：机构id="+orgId+"==================");
		return this.insertSelective(userNotify);
	}


	/**
	 *
	 * @param orgId
	 * @param message 通知消息模板
	 * @param params
	 * @return
	 */
	public int insertByTemplate(Integer orgId, PaidangMessage message, String... params){
		return insertByTemplate(orgId,null,message,params);
	}
}
