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
import com.item.dao.model.UserNotify;
import com.item.dao.model.UserNotifyExample;
import com.item.service.UserNotifyService;

/**
@author sun
*/
@RequestMapping("userNotify")
@Controller
@LoginFilter
public class UserNotifyController extends CoreController{

    @Autowired
    private UserNotifyService userNotifyService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserNotifyExample example = new UserNotifyExample();
    	
    	List<UserNotify> list = userNotifyService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserNotify userNotify){
    	if (userNotify.getId() == null){
    		userNotifyService.insert(userNotify);
    	}else{
    		userNotifyService.updateByPrimaryKeySelective(userNotify);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserNotify userNotify = userNotifyService.selectByPrimaryKey(id);
       	return ok(userNotify);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userNotifyService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}