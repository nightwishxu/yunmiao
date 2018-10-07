package com.item.service;

import com.base.util.StringUtil;
import com.item.dao.UserNotifyMapper;
import com.item.dao.model.UserNotify;
import com.item.dao.model.UserNotifyExample;
import com.item.daoEx.UserNotifyMapperEx;
import com.util.PaidangMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotifyService {
    @Autowired
    private UserNotifyMapper userNotifyMapper;
    @Autowired
    private UserNotifyMapperEx userNotifyMapperEx;
    @Autowired
    private MessageService messageService;

    private static final Logger logger = Logger.getLogger(UserNotifyService.class);

    public int countByExample(UserNotifyExample example) {
        return this.userNotifyMapper.countByExample(example);
    }

    public UserNotify selectByPrimaryKey(Integer id) {
        return this.userNotifyMapper.selectByPrimaryKey(id);
    }

    public List<UserNotify> selectByExample(UserNotifyExample example) {
        return this.userNotifyMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.userNotifyMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UserNotify record) {
        return this.userNotifyMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserNotify record) {
        return this.userNotifyMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(UserNotifyExample example) {
        return this.userNotifyMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(UserNotify record, UserNotifyExample example) {
        return this.userNotifyMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(UserNotify record, UserNotifyExample example) {
        return this.userNotifyMapper.updateByExample(record, example);
    }

    public int insert(UserNotify record) {
    	messageService.pushToSingleUserSide(record.getUserId(), record.getContent(), record.getRedirectType(), record.getRedirectContent());
        return this.userNotifyMapper.insert(record);
    }

    public int insertSelective(UserNotify record) {
    	messageService.pushToSingleUserSide(record.getUserId(), record.getContent(), record.getRedirectType(), record.getRedirectContent());
        return this.userNotifyMapper.insertSelective(record);
    }

    /**
     *
     * @param userId
     * @param message 通知消息模板
     * @param params
     * @return
     */
    public int insertByTemplate(Integer userId, String redirectContent, PaidangMessage message,String... params){
        UserNotify userNotify = new UserNotify();
        userNotify.setIsRead(0);
        userNotify.setRedirectType(message.getRedirectType());
        userNotify.setTitle(message.getTitle());
        userNotify.setType(message.getType());
        userNotify.setUserId(userId);
        userNotify.setContent(StringUtil.format(message.getTemplate(),params));
        userNotify.setRedirectContent(redirectContent);
        return this.insertSelective(userNotify);
    }

    /**
     *
     * @param userId
     * @param message 通知消息模板
     * @param params
     * @return
     */
    public int insertByTemplate(Integer userId, PaidangMessage message,String... params){
        return insertByTemplate(userId,null,message,params);
    }
}