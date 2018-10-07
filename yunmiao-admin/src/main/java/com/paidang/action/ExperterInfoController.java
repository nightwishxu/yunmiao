package com.paidang.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import com.paidang.dao.model.UserGoods;
import com.paidang.daoEx.model.ExperterInfoEx;
import com.paidang.service.UserGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.paidang.dao.model.ExperterInfo;
import com.paidang.dao.model.ExperterInfoExample;
import com.paidang.service.ExperterInfoService;

/**
@author sun
*/
@RequestMapping("experterInfo")
@Controller
@LoginFilter
public class ExperterInfoController extends CoreController{

    @Autowired
    private ExperterInfoService experterInfoService;
	@Autowired
	private UserGoodsService userGoodsService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows,String experterName, String goodsName){
    	PaginationSupport.byPage(page, rows);
    	ExperterInfoExample example = new ExperterInfoExample();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("experterName",experterName);
		map.put("goodsName",goodsName);
    	//List<ExperterInfo> list = experterInfoService.selectByExample(example);
		List<ExperterInfoEx> list = experterInfoService.selectList(map);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(ExperterInfo experterInfo){
    	if (experterInfo.getId() == null){
    		experterInfoService.insert(experterInfo);
    	}else{
    		experterInfoService.updateByPrimaryKeySelective(experterInfo);
    	}
       	return ok();
    }

	@RequestMapping("/saveInfo")
	@ResponseBody
	public String saveInfo(ExperterInfo experterInfo){
    	//插入专家表意见表
		experterInfoService.insert(experterInfo);
		//修改p_user_gooods表
		UserGoods userGoods = new UserGoods();
		userGoods.setId(experterInfo.getGoodsId());
		userGoods.setExperterInfoId(experterInfo.getId());
		userGoodsService.updateByPrimaryKeySelective(userGoods);
		return ok();
	}
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	ExperterInfo experterInfo = experterInfoService.selectByPrimaryKey(id);
       	return ok(experterInfo);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		experterInfoService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}