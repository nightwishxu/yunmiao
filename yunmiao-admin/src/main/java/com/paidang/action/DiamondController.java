package com.paidang.action;

import java.util.List;
import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.paidang.dao.model.Diamond;
import com.paidang.dao.model.DiamondExample;
import com.paidang.service.DiamondService;

/**
@author sun
*/
@RequestMapping("diamond")
@Controller
@LoginFilter
public class DiamondController extends CoreController{

    @Autowired
    private DiamondService diamondService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	DiamondExample example = new DiamondExample();
    	
    	List<Diamond> list = diamondService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Diamond diamond){
    	if (diamond.getId() == null){
    		diamondService.insert(diamond);
    	}else{
    		diamondService.updateByPrimaryKeySelective(diamond);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Diamond diamond = diamondService.selectByPrimaryKey(id);
       	return ok(diamond);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		diamondService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}