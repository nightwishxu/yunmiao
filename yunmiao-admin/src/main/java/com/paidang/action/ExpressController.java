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
import com.paidang.dao.model.Express;
import com.paidang.dao.model.ExpressExample;
import com.paidang.service.ExpressService;

/**
@author sun
*/
@RequestMapping("express")
@Controller
@LoginFilter
public class ExpressController extends CoreController{

    @Autowired
    private ExpressService expressService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	ExpressExample example = new ExpressExample();
    	
    	List<Express> list = expressService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Express express){
    	if (express.getId() == null){
    		expressService.insert(express);
    	}else{
    		expressService.updateByPrimaryKeySelective(express);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Express express = expressService.selectByPrimaryKey(id);
       	return ok(express);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		expressService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}