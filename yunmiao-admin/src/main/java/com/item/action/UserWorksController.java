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
import com.item.dao.model.UserWorks;
import com.item.dao.model.UserWorksExample;
import com.item.service.UserWorksService;

/**
@author sun
*/
@RequestMapping("userWorks")
@Controller
@LoginFilter
public class UserWorksController extends CoreController{

    @Autowired
    private UserWorksService userWorksService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserWorksExample example = new UserWorksExample();
    	
    	List<UserWorks> list = userWorksService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserWorks userWorks){
    	if (userWorks.getId() == null){
    		userWorksService.insert(userWorks);
    	}else{
    		userWorksService.updateByPrimaryKeySelective(userWorks);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserWorks userWorks = userWorksService.selectByPrimaryKey(id);
       	return ok(userWorks);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userWorksService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}