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
import com.item.dao.model.UserInfo;
import com.item.dao.model.UserInfoExample;
import com.item.service.UserInfoService;

/**
@author sun
*/
@RequestMapping("userInfo")
@Controller
@LoginFilter
public class UserInfoController extends CoreController{

    @Autowired
    private UserInfoService userInfoService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserInfoExample example = new UserInfoExample();
    	
    	List<UserInfo> list = userInfoService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserInfo userInfo){
    	if (userInfo.getId() == null){
    		userInfoService.insert(userInfo);
    	}else{
    		userInfoService.updateByPrimaryKeySelective(userInfo);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserInfo userInfo = userInfoService.selectByPrimaryKey(id);
       	return ok(userInfo);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userInfoService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}