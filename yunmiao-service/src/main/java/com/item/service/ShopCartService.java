package com.item.service;

import java.util.*;

import com.api.view.shopCart.ShopCartVo;
import com.item.daoEx.ShopCartMapperEx;
import com.item.daoEx.model.ShopCartEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.dao.ShopCartMapper;
import com.item.dao.model.ShopCart;
import com.item.dao.model.ShopCartExample;

@Service
public class ShopCartService {
	@Autowired
	private ShopCartMapper shopCartMapper;

	@Autowired
	private ShopCartMapperEx shopCartMapperEx;

	public int countByExample(ShopCartExample example) {
		return this.shopCartMapper.countByExample(example);
	}

	public ShopCart selectByPrimaryKey(Integer user_id) {
		return this.shopCartMapper.selectByPrimaryKey(user_id);
	}

	public List<ShopCart> selectByExample(ShopCartExample example) {
		return this.shopCartMapper.selectByExample(example);
	}

	public int deleteByPrimaryKey(Integer id) {
		return this.shopCartMapper.deleteByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(ShopCart record) {
		return this.shopCartMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(ShopCart record) {
		return this.shopCartMapper.updateByPrimaryKey(record);
	}

	public int deleteByExample(ShopCartExample example) {
		return this.shopCartMapper.deleteByExample(example);
	}

	public int updateByExampleSelective(ShopCart record, ShopCartExample example) {
		return this.shopCartMapper.updateByExampleSelective(record, example);
	}

	public int updateByExample(ShopCart record, ShopCartExample example) {
		return this.shopCartMapper.updateByExample(record, example);
	}

	public int insert(ShopCart record) {
		return this.shopCartMapper.insert(record);
	}

	public int insertSelective(ShopCart record) {
		return this.shopCartMapper.insertSelective(record);
	}

	/**
	 * 购物车列表
	 * @param userId
	 * @return
	 */
	public List<ShopCartVo> findList(Integer userId){
		List<ShopCartEx> list=shopCartMapperEx.findList(userId);
		List<ShopCartVo> result=new ArrayList<>();
		Map<Integer,ShopCartVo> map=new LinkedHashMap<>();
		for (ShopCartEx ex:list){
			ShopCartVo cartVo= map.get(ex.getOrgId());
			if (cartVo==null){
				ShopCartVo shopCartVo=new ShopCartVo();
				shopCartVo.setOrgId(ex.getOrgId());
				shopCartVo.setOrgLogo(ex.getOrgLogo());
				shopCartVo.setOrgName(ex.getOrgName());
				List<ShopCartEx> exes=new ArrayList<>();
				exes.add(ex);
				shopCartVo.setGoods(exes);
				map.put(shopCartVo.getOrgId(),shopCartVo);
				result.add(shopCartVo);
			}else {
				cartVo.getGoods().add(ex);
			}
		}
		return result;
	}

}
