package com.paidang.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import com.paidang.daoEx.model.ExperterEx;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.paidang.dao.model.Experter;
import com.paidang.dao.model.ExperterExample;
import com.paidang.service.ExperterService;

/**
@author sun
*/
@RequestMapping("experter")
@Controller
@LoginFilter
public class ExperterController extends CoreController{

    @Autowired
    private ExperterService experterService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows,Integer domainId){
    	PaginationSupport.byPage(page, rows);
    	ExperterExample example = new ExperterExample();
		Map<String, Object> map = new HashMap<>();
		map.put("domainId",domainId);
		List<ExperterEx> list = experterService.selectList(map);
    	//List<Experter> list = experterService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Experter experter){
    	if (experter.getId() == null){
    		experterService.insert(experter);
    	}else{
    		experterService.updateByPrimaryKeySelective(experter);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Experter experter = experterService.selectByPrimaryKey(id);
       	return ok(experter);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		experterService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	@RequestMapping("/experterList")
	@ResponseBody
	public List<ExperterEx> experterList(Integer domainId){
		ExperterExample example = new ExperterExample();
		Map<String, Object> map = new HashMap<>();
		map.put("domainId",domainId);
		List<ExperterEx> list = experterService.selectList(map);
		//List<Experter> list = experterService.selectByExample(example);
		return list;
	}


}