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
import com.item.dao.model.UserOption;
import com.item.dao.model.UserOptionExample;
import com.item.service.UserOptionService;

/**
@author sun
*/
@RequestMapping("userOption")
@Controller
@LoginFilter
public class UserOptionController extends CoreController{

    @Autowired
    private UserOptionService userOptionService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserOptionExample example = new UserOptionExample();
    	
    	List<UserOption> list = userOptionService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserOption userOption){
    	if (userOption.getId() == null){
    		userOptionService.insert(userOption);
    	}else{
    		userOptionService.updateByPrimaryKeySelective(userOption);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserOption userOption = userOptionService.selectByPrimaryKey(id);
       	return ok(userOption);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userOptionService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}