package com.item.service;

import com.item.dao.NotifyMapper;
import com.item.dao.UserMapper;
import com.item.dao.UserNotifyMapper;
import com.item.dao.model.*;
import com.item.daoEx.NotifyMapperEx;
import com.item.daoEx.UserNotifyMapperEx;
import com.item.daoEx.model.NotifyEx;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NotifyService {
    @Autowired
    private NotifyMapper notifyMapper;
    @Autowired
    private NotifyMapperEx notifyMapperEx;
    @Autowired
    private UserNotifyMapper userNotifyMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserNotifyMapperEx userNotifyMapperEx;


    private static final Logger logger = Logger.getLogger(NotifyService.class);

    public int countByExample(NotifyExample example) {
        return this.notifyMapper.countByExample(example);
    }

    public Notify selectByPrimaryKey(Integer id) {
        return this.notifyMapper.selectByPrimaryKey(id);
    }

    public List<Notify> selectByExample(NotifyExample example) {
        return this.notifyMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.notifyMapper.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Notify record) {
        return this.notifyMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Notify record) {
        return this.notifyMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(NotifyExample example) {
        return this.notifyMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Notify record, NotifyExample example) {
        return this.notifyMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Notify record, NotifyExample example) {
        return this.notifyMapper.updateByExample(record, example);
    }

    public int insert(Notify record) {
        return this.notifyMapper.insert(record);
    }

    public int insertSelective(Notify record) {
        return this.notifyMapper.insertSelective(record);
    }

	public List<NotifyEx> selectList(Map<String, Object> map) {
		return notifyMapperEx.selectList(map);
	}

	public void deleteEx(Integer id) {
		UserNotifyExample example = new UserNotifyExample();
		example.createCriteria().andNidEqualTo(id);
		userNotifyMapper.deleteByExample(example);
		notifyMapper.deleteByPrimaryKey(id);
	}

	public void sendNotify(Integer id) {
		Notify notify = notifyMapper.selectByPrimaryKey(id);
		if(notify!=null){
		    Date now = new Date();
			if(notify.getUserId() != null){
                UserNotify record = getByNotify(notify);
                record.setCreateTime(now);
				record.setUserId(notify.getUserId());
				userNotifyMapper.insert(record);
				notify.setNum(1);
				messageService.pushToSingleUserSide(notify.getUserId(), notify.getContent(), notify.getRedirectType(), notify.getRedirectContent());
			}else{
                UserExample example = new UserExample();
                List<User> list = userMapper.selectByExample(example);
                List<UserNotify> notifies = new ArrayList<>(list.size());
                for (User user : list){
                    UserNotify record = getByNotify(notify);
                    record.setCreateTime(now);
                    record.setUserId(user.getId());
                    notifies.add(record);
                }
                userNotifyMapperEx.insertBatch(notifies);
                notify.setNum(list.size());
				messageService.pushToApp(notify.getContent(), notify.getRedirectType(), notify.getRedirectContent());
			}

			notify.setState(2);
			notifyMapper.updateByPrimaryKey(notify);
		}
	}

    /**
     * 新注册用户
     * @param userId
     * @return
     */
	public int insertNewUser(Integer userId){
        NotifyExample example = new NotifyExample();
        example.createCriteria().andUserIdIsNull().andStateEqualTo(2);
        List<Notify> list = notifyMapper.selectByExample(example);
        List<UserNotify> notifies = new ArrayList<>(list.size());
        Date now = new Date();
        for (Notify notify : list){
            UserNotify record = getByNotify(notify);
            record.setCreateTime(now);
            record.setUserId(userId);
            notifies.add(record);
        }
        userNotifyMapperEx.insertBatch(notifies);
        return list.size();
    }

	private UserNotify getByNotify(Notify notify){
        UserNotify record = new UserNotify();
        record.setType(1);
        record.setContent(notify.getContent());
        record.setNid(notify.getId());
        record.setIsRead(0);
        record.setTitle(notify.getTitle());
        record.setRedirectType(notify.getRedirectType());
        record.setRedirectContent(notify.getRedirectContent());
        return record;
    }
}