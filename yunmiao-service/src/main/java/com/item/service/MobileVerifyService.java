package com.item.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.ConstantsCode;
import com.base.api.MobileInfo;
import com.base.cache.serviceCache.CacheAdd;
import com.base.cache.serviceCache.CacheRemove;
import com.item.dao.MobileVerifyMapper;
import com.item.dao.model.MobileVerify;
import com.item.dao.model.MobileVerifyExample;

@Service
public class MobileVerifyService {
    @Autowired
    private MobileVerifyMapper mobileVerifyMapper;

    public int countByExample(MobileVerifyExample example) {
        return this.mobileVerifyMapper.countByExample(example);
    }

    public MobileVerify selectByPrimaryKey(String deviceId) {
        return this.mobileVerifyMapper.selectByPrimaryKey(deviceId);
    }

    public List<MobileVerify> selectByExample(MobileVerifyExample example) {
        return this.mobileVerifyMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String deviceId) {
        return this.mobileVerifyMapper.deleteByPrimaryKey(deviceId);
    }

    @CacheRemove(group="'mobileVerify'",key="#record.verify")
    public int updateByPrimaryKeySelective(MobileVerify record) {
        return this.mobileVerifyMapper.updateByPrimaryKeySelective(record);
    }

    @CacheRemove(group="'mobileVerify'",key="#record.verify")
    public int updateByPrimaryKey(MobileVerify record) {
        return this.mobileVerifyMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(MobileVerifyExample example) {
        return this.mobileVerifyMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(MobileVerify record, MobileVerifyExample example) {
        return this.mobileVerifyMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MobileVerify record, MobileVerifyExample example) {
        return this.mobileVerifyMapper.updateByExample(record, example);
    }

    public int insert(MobileVerify record) {
        return this.mobileVerifyMapper.insert(record);
    }

    public int insertSelective(MobileVerify record) {
        return this.mobileVerifyMapper.insertSelective(record);
    }
    
    /**
     * 更新登录信息
     * @param mobileInfo 
     * @param deviceType 设备类型 ios or android
     * @param cid 个推cid
     * @param mutli 是否支持多终端登录
     * @return verify
     */
    public String updateMobileVerify(MobileInfo mobileInfo,Integer deviceType,String cid){
        if(!ConstantsCode.MULTI_LOGIN){//单设备登录删除其他设备的登录信息
            deleteOther(mobileInfo.getUserid(),mobileInfo.getDeviceid());
        }

        //更新当前设备登录信息
        MobileVerify mobileVerify = new MobileVerify();
        mobileVerify.setVerify(UUID.randomUUID().toString());
        mobileVerify.setDeviceId(mobileInfo.getDeviceid());
        mobileVerify.setUserId(mobileInfo.getUserid());
        mobileVerify.setDeviceType(deviceType);
        if(StringUtils.isNotBlank(cid))mobileVerify.setCid(cid);
        int count = mobileVerifyMapper.updateByPrimaryKeySelective(mobileVerify);

        if(count == 0){//未更新则新增
            mobileVerify.setCreateTime(new Date());
            mobileVerifyMapper.insert(mobileVerify);
        }
        return mobileVerify.getVerify();
    }


    
    @CacheRemove(group="'mobileVerify'",key="#mobileInfo.token")
    public void logout(MobileInfo mobileInfo){
    	MobileVerify mobileVerify = mobileVerifyMapper.selectByPrimaryKey(mobileInfo.getDeviceid());
    	if(mobileVerify == null){
    		return;
    	}
    	mobileVerifyMapper.deleteByPrimaryKey(mobileInfo.getDeviceid());
    }

	public void deleteOther(Integer userid,String deviceid) {
		MobileVerifyExample example = new MobileVerifyExample();
		example.createCriteria().andUserIdEqualTo(userid).andDeviceIdNotEqualTo(deviceid);
		mobileVerifyMapper.deleteByExample(example);
	}
    
	public void deleteOther(MobileInfo mobileInfo) {
		MobileVerifyExample example = new MobileVerifyExample();
		example.createCriteria().andUserIdEqualTo(mobileInfo.getUserid()).andDeviceIdNotEqualTo(mobileInfo.getDeviceid());
		mobileVerifyMapper.deleteByExample(example);
	}
	
    public List<String> getCid(Integer userId){
    	MobileVerifyExample example = new MobileVerifyExample();
    	example.createCriteria().andUserIdEqualTo(userId);
    	List<MobileVerify> list = mobileVerifyMapper.selectByExample(example);
    	List<String> cids = new ArrayList<String>();
    	for (MobileVerify verify : list){
    		if (StringUtils.isNotBlank(verify.getCid())&& !cids.contains(verify.getCid())){
    			cids.add(verify.getCid());
    		}
    	}
    	if (cids.size() > 0){
    		return cids;
    	}
    	return null;
    }
    
    public List<String> getCid(List<Integer> userIds){
    	MobileVerifyExample example = new MobileVerifyExample();
    	example.createCriteria().andUserIdIn(userIds);
    	List<MobileVerify> list = mobileVerifyMapper.selectByExample(example);
    	List<String> cids = new ArrayList<String>();
    	for (MobileVerify verify : list){
    		if (StringUtils.isNotBlank(verify.getCid()) && !cids.contains(verify.getCid())){
    			cids.add(verify.getCid());
    		}
    	}
    	if (cids.size() > 0){
    		return cids;
    	}
    	return null;
    }

    @CacheAdd(group="'mobileVerify'",key="#token")
	public MobileVerify queryByToken(String token) {
		MobileVerifyExample example = new MobileVerifyExample();
		example.createCriteria().andVerifyEqualTo(token);
		List<MobileVerify> list = selectByExample(example);
		if(list.size()>0)return list.get(0);
		return null;
	}
//	public MobileVerify selectByUserId(Integer id) {
//		return this.mobileVerifyMapperEx.selectByUserId(id);
//	}
}