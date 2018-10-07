package com.item.service;

import com.base.support.LogKit;
import com.base.support.PropertySupport;
import com.base.util.JPushOrgUtil;
import com.base.util.JPushUtil;
import com.item.dao.MessageMapper;
import com.item.dao.model.Message;
import com.item.dao.model.MessageExample;
import com.item.dao.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MobileVerifyService verifyService;
    @Autowired
    private UserService userService;

    public int countByExample(MessageExample example) {
        return this.messageMapper.countByExample(example);
    }

    public Message selectByPrimaryKey(Integer id) {
        return this.messageMapper.selectByPrimaryKey(id);
    }

    public List<Message> selectByExample(MessageExample example) {
        return this.messageMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.messageMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Message record) {
        return this.messageMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Message record) {
        return this.messageMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MessageExample example) {
        return this.messageMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Message record, MessageExample example) {
        return this.messageMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Message record, MessageExample example) {
        return this.messageMapper.updateByExample(record, example);
    }

    public int insert(Message record) {
        return this.messageMapper.insert(record);
    }

    public int insertSelective(Message record) {
        return this.messageMapper.insertSelective(record);
    }
    
    public String pushToApp(String msg,int redirectType,String redirectContent){
    	if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey")))return null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put("redirectType", redirectType+"");
    	params.put("redirectContent", redirectContent);
		params.put("msg", msg);
		return JPushUtil.pushMessageToApp(params, msg);
    }
    
    public String pushToList(List<Integer> userId, String msg,int redirectType,String redirectContent){
    	if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey")))return null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put("redirectType", redirectType+"");
    	params.put("redirectContent", redirectContent);
		params.put("msg", msg);
		List<String> cids = verifyService.getCid(userId);
		return JPushUtil.pushMessageToList(params, msg, cids);
    }
    
    public String pushToList(List<Integer> userId, String content,int redirectType,Map<String, String> extra){
    	if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey")))return null;
		Map<String, String> params = new HashMap<String, String>();
    	params.put("redirectType", redirectType+"");
		params.put("msg", content);
		if (extra != null){
			params.putAll(extra);
		}
		List<String> cids = verifyService.getCid(userId);
		return JPushUtil.pushMessageToList(params, content, cids);
    }
    
    public String pushToSingleAccount(String account, String msg,int redirectType,String redirectContent){
    	if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey")))return null;
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("redirectType", redirectType+"");
		params.put("msg", msg);
		params.put("redirectContent", redirectContent);
		List<String> cids = verifyService.getCid(userService.selectIdByAccount(account));
		return JPushUtil.pushMessageToList(params, msg, cids);
    }

    //推送，机构端用或者用户端向机构推送用该方法
  /*  public String pushToSingleOrgSide(Integer userId, String msg,int redirectType,String redirectContent){
        LogKit.debug("=========================进入==MessageService/pushToSingleOrgSide=====================");
        if(StringUtils.isBlank(PropertySupport.getProperty("jpush.org.appkey")))return null;
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("redirectType", redirectType+"");
		params.put("msg", msg);
		params.put("redirectContent", redirectContent);
        List<String> cids = verifyService.getCid(userId);
        System.out.println(cids ==null || cids.size()==0?"cids为空或null":"cids大小："+cids.size());
        for (String cid:cids) {
            LogKit.debug("===================MessageService/pushToSingleOrgSide======推送到的机构人员id:"+userId+"对应cid:"+cid+"====================");
        }
        if (cids == null || cids.size() == 0) return null;//表示该用户id从未登陆过，不推送
        LogKit.debug("===============MessageService/pushToSingleOrgSide return："+JPushOrgUtil.pushMessageToList(params, msg, cids)+"===============");
		return JPushOrgUtil.pushMessageToList(params, msg, cids);
    }*/

    public String pushToOrgUsers(List<User> users,String msg,int redirectType,String redirectContent){
        if(StringUtils.isBlank(PropertySupport.getProperty("jpush.org.appkey")))return null;
        Map<String, String> params = new HashMap<String, String>();
        params.put("redirectType", redirectType+"");
        params.put("msg", msg);
        params.put("redirectContent", redirectContent);
        List<Integer> userIds = new ArrayList<>();
        for (User user:users) {
            userIds.add(user.getId());
        }
        List<String> cids = verifyService.getCid(userIds);
        LogKit.debug("=================== 【 print  target  cids 】==========================");
        for (String cid:cids) {
            LogKit.debug("===================MessageService.pushToOrgUsers cid:======"+cid+"====================");
        }
        if (cids == null || cids.size() == 0){
            LogKit.debug("===================MessageService.pushToOrgUsers:推送cids为空==========================");
            return null;
        }
        return JPushOrgUtil.pushMessageToList(params, msg, cids);
    }



    //推送，用户端用或者机构端向用户端推送用该方法
    public String pushToSingleUserSide(Integer userId, String msg,int redirectType,String redirectContent){
        if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey")))return null;
        Map<String, String> params = new HashMap<String, String>();
        params.put("redirectType", redirectType+"");
        params.put("msg", msg);
        params.put("redirectContent", redirectContent);
        List<String> cids = verifyService.getCid(userId);
        return JPushUtil.pushMessageToList(params, msg, cids);
    }

  /*  public String pushToSingle(Integer userId, String msg,int redirectType,Map<String, String> extra){
    	if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey")))return null;
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("redirectType", redirectType+"");
		params.put("msg", msg);
		if (extra != null){
			params.putAll(extra);
		}
		List<String> cids = verifyService.getCid(userId);
		return JPushUtil.pushMessageToList(params, msg, cids);
    }*/
}