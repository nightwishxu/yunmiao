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
import com.item.dao.model.UserFollow;
import com.item.dao.model.UserFollowExample;
import com.item.service.UserFollowService;

/**
@author sun
*/
@RequestMapping("userFollow")
@Controller
@LoginFilter
public class UserFollowController extends CoreController{

    @Autowired
    private UserFollowService userFollowService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserFollowExample example = new UserFollowExample();
    	
    	List<UserFollow> list = userFollowService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserFollow userFollow){
    	if (userFollow.getId() == null){
    		userFollowService.insert(userFollow);
    	}else{
    		userFollowService.updateByPrimaryKeySelective(userFollow);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserFollow userFollow = userFollowService.selectByPrimaryKey(id);
       	return ok(userFollow);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userFollowService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}