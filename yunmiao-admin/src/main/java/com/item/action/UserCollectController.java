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
import com.item.dao.model.UserCollect;
import com.item.dao.model.UserCollectExample;
import com.item.service.UserCollectService;

/**
@author sun
*/
@RequestMapping("userCollect")
@Controller
@LoginFilter
public class UserCollectController extends CoreController{

    @Autowired
    private UserCollectService userCollectService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserCollectExample example = new UserCollectExample();
    	
    	List<UserCollect> list = userCollectService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserCollect userCollect){
    	if (userCollect.getId() == null){
    		userCollectService.insert(userCollect);
    	}else{
    		userCollectService.updateByPrimaryKeySelective(userCollect);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserCollect userCollect = userCollectService.selectByPrimaryKey(id);
       	return ok(userCollect);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userCollectService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}