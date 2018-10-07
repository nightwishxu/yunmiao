package com.item.service;

import java.util.Date;
import java.util.List;

import com.util.LsmSmsSendUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.base.support.PropertySupport;
import com.base.util.DateUtil;
import com.base.util.SmsSendUtil;
import com.item.dao.SmsSendLogMapper;
import com.item.dao.model.SmsSendLog;
import com.item.dao.model.SmsSendLogExample;

@Service
public class SmsSendLogService {
	@Autowired
	private SmsSendLogMapper smsSendLogMapper;

	private static final Logger logger = Logger
			.getLogger(SmsSendLogService.class);

	public int countByExample(SmsSendLogExample example) {
		return this.smsSendLogMapper.countByExample(example);
	}

	public SmsSendLog selectByPrimaryKey(Integer id) {
		return this.smsSendLogMapper.selectByPrimaryKey(id);
	}

	public List<SmsSendLog> selectByExample(SmsSendLogExample example) {
		return this.smsSendLogMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.smsSendLogMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SmsSendLog record) {
		return this.smsSendLogMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SmsSendLog record) {
		return this.smsSendLogMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(SmsSendLogExample example) {
		return this.smsSendLogMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(SmsSendLog record,
			SmsSendLogExample example) {
		return this.smsSendLogMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(SmsSendLog record, SmsSendLogExample example) {
		return this.smsSendLogMapper.updateByExample(record, example);
	}

	public int insert(SmsSendLog record) {
		return this.smsSendLogMapper.insert(record);
	}

	public int insertSelective(SmsSendLog record) {
		return this.smsSendLogMapper.insertSelective(record);
	}

	/**
	 * @param phone
	 *            手机号
	 * @param deviceId
	 *            设备id
	 * @param ip
	 *            ip
	 * @param type
	 *            1:验证码
	 * @return int 1可以发送-1发送间隔时间不够-2当天发送条数超过0其他问题
	 */
	public int sendSmsValidate(String phone, String deviceId, String ip,
			Integer type) {
		Date now = new Date();
		try {
			String paString = PropertySupport.getProperty("sms.type" + type);
			Integer space = Integer.parseInt(PropertySupport.getProperty("sms.space"))*1000;
			Date today = DateUtil.strToDate(
					DateUtil.dateToStr(now, "yyyy-MM-dd"), "yyyy-MM-dd");
			SmsSendLogExample example = new SmsSendLogExample();
			example.setOrderByClause("create_time desc");
			example.or().andPhoneEqualTo(phone).andTypeEqualTo(type)
					.andCreateTimeGreaterThan(today);
			if (StringUtils.isNotBlank(deviceId)){
				example.or().andDeviceIdEqualTo(deviceId).andTypeEqualTo(type)
				.andCreateTimeGreaterThan(today);
			}
			if (StringUtils.isNotBlank(ip)){
				example.or().andIpEqualTo(ip).andTypeEqualTo(type)
				.andCreateTimeGreaterThan(today);
			}
			List<SmsSendLog> list = smsSendLogMapper.selectByExample(example);
			
			int cnt = list == null ? 0 : list.size();
			if (cnt > 0){
				SmsSendLog log = list.get(0);
				if ((now.getTime() - log.getCreateTime().getTime()) < space){
					return -1;
				}
			}
			
			if (paString == null)
				return 1;
			else {
				Integer pass = Integer.parseInt(paString);
				if (cnt < pass)
					return 1;
				else
					return -2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public synchronized String sendSms(String phone, String deviceId, String ip,
			Integer type, String content) {
		String result = sendSmsValidate(phone, deviceId, ip, type)+"";
		if ("1".equals(result)) {
			SmsSendLog log = new SmsSendLog();
			log.setCreateTime(new Date());
			log.setDeviceId(deviceId);
			log.setIp(ip);
			log.setPhone(phone);
			log.setType(type);
			smsSendLogMapper.insertSelective(log);
			try {
				result = LsmSmsSendUtil.push(phone,content);
			} catch (Exception e) {
				result = "0";
			}
			log.setCode(result);
			smsSendLogMapper.updateByPrimaryKeySelective(log);
		}
		return result;
	}
	
	/**
	 * 发送短信验证码
	 * @param phone
	 * @param deviceId
	 * @param ip
	 * @param content
	 * @return
	 */
	public String sendIdentifySms(String phone, String deviceId, String ip,String content,Integer type){
		boolean flag = Boolean.valueOf("true".equals(PropertySupport.getProperty("sms.enable", "false")));
		if(!flag){
			return "2";
		}
		return sendSms(phone, deviceId, ip, type, content);
	}
}