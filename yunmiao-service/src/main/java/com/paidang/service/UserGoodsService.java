package com.paidang.service;

import java.util.List;
import java.util.Map;

import com.paidang.daoEx.UserGoodsMapperEx;
import com.paidang.daoEx.model.UserGoodsEx;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paidang.dao.UserGoodsMapper;
import com.paidang.dao.model.UserGoods;
import com.paidang.dao.model.UserGoodsExample;

@Service
public class UserGoodsService {
	@Autowired
	private UserGoodsMapper userGoodsMapper;
	@Autowired
	private UserGoodsMapperEx userGoodsMapperEx;

	public int countByExample(UserGoodsExample example) {
		return this.userGoodsMapper.countByExample(example);
	}

	public UserGoods selectByPrimaryKey(Integer id) {
		return this.userGoodsMapper.selectByPrimaryKey(id);
	}

	public List<UserGoods> selectByExample(UserGoodsExample example) {
		return this.userGoodsMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.userGoodsMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(UserGoods record) {
		return this.userGoodsMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(UserGoods record) {
		return this.userGoodsMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(UserGoodsExample example) {
		return this.userGoodsMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(UserGoods record, UserGoodsExample example) {
		return this.userGoodsMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(UserGoods record, UserGoodsExample example) {
		return this.userGoodsMapper.updateByExample(record, example);
	}

	public int insert(UserGoods record) {
		return this.userGoodsMapper.insert(record);
	}

	public int insertSelective(UserGoods record) {
		return this.userGoodsMapper.insertSelective(record);
	}

	public String getGoodNameById(Integer id){
		if(id == null){
			return null;
		}
		UserGoods userGoods = userGoodsMapper.selectByPrimaryKey(id);
		if(userGoods == null){
			return null;
		}
		return userGoods.getName();
	}

    public int updateResAuthPrice(Map<String, Object> map) {
		return this.userGoodsMapperEx.updateResAuthPrice(map);
    }

    public List<UserGoodsEx> selectList(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectList(map);
    }

    public List<UserGoodsEx> checkDetail(Map<String, Object> map) {
		return this.userGoodsMapperEx.checkDetail(map);
    }

    public UserGoodsEx selectGotoPawn(Integer id) {
		return this.userGoodsMapperEx.selectGotoPawn(id);
    }

    public List<UserGoodsEx> selectByAppList(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectByAppList(map);
    }

	public List<UserGoodsEx> selectMyGoods(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectMyGoods(map);
	}

	//查看适配监控
    public List<UserGoodsEx> selectMyVideo(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectMyVideo(map);
    }

    //机构取回宝贝
	public List<UserGoodsEx> selectGoodsByOrgList(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectGoodsByOrgList(map);
	}

	//未典当列表
    public List<UserGoodsEx> selectNoPawnList(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectNoPawnList(map);
    }

    public List<UserGoodsEx> selectCancelPawnList(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectCancelPawnList(map);
    }

    public List<UserGoodsEx> selectTradeRecordList(Map<String, Object> map) {
		return this.userGoodsMapperEx.selectTradeRecordList(map);
    }
}
