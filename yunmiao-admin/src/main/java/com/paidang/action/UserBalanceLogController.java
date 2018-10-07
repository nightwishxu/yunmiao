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
import com.paidang.dao.model.UserBalanceLog;
import com.paidang.dao.model.UserBalanceLogExample;
import com.paidang.service.UserBalanceLogService;

/**
@author sun
*/
@RequestMapping("userBalanceLog")
@Controller
@LoginFilter
public class UserBalanceLogController extends CoreController{

    @Autowired
    private UserBalanceLogService userBalanceLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserBalanceLogExample example = new UserBalanceLogExample();
    	
    	List<UserBalanceLog> list = userBalanceLogService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserBalanceLog userBalanceLog){
    	if (userBalanceLog.getId() == null){
    		userBalanceLogService.insert(userBalanceLog);
    	}else{
    		userBalanceLogService.updateByPrimaryKeySelective(userBalanceLog);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserBalanceLog userBalanceLog = userBalanceLogService.selectByPrimaryKey(id);
       	return ok(userBalanceLog);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userBalanceLogService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}