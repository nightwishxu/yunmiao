package com.item.action;

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
import com.item.dao.model.SysDict;
import com.item.dao.model.SysDictExample;
import com.item.service.SysDictService;

/**
@author sun
*/
@RequestMapping("sysDict")
@Controller
@LoginFilter
public class SysDictController extends CoreController{

    @Autowired
    private SysDictService sysDictService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	SysDictExample example = new SysDictExample();
    	
    	List<SysDict> list = sysDictService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(SysDict sysDict){
    	if (sysDict.getId() == null){
    		sysDictService.insert(sysDict);
    	}else{
    		sysDictService.updateByPrimaryKeySelective(sysDict);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	SysDict sysDict = sysDictService.selectByPrimaryKey(id);
       	return ok(sysDict);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		sysDictService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}