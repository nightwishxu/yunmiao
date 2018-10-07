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
import com.item.dao.model.UserMessage;
import com.item.dao.model.UserMessageExample;
import com.item.service.UserMessageService;

/**
@author sun
*/
@RequestMapping("userMessage")
@Controller
@LoginFilter
public class UserMessageController extends CoreController{

    @Autowired
    private UserMessageService userMessageService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserMessageExample example = new UserMessageExample();
    	
    	List<UserMessage> list = userMessageService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserMessage userMessage){
    	if (userMessage.getId() == null){
    		userMessageService.insert(userMessage);
    	}else{
    		userMessageService.updateByPrimaryKeySelective(userMessage);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserMessage userMessage = userMessageService.selectByPrimaryKey(id);
       	return ok(userMessage);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userMessageService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}