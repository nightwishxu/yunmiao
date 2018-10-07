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
import com.item.dao.model.UserBlack;
import com.item.dao.model.UserBlackExample;
import com.item.service.UserBlackService;

/**
@author sun
*/
@RequestMapping("userBlack")
@Controller
@LoginFilter
public class UserBlackController extends CoreController{

    @Autowired
    private UserBlackService userBlackService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserBlackExample example = new UserBlackExample();
    	
    	List<UserBlack> list = userBlackService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserBlack userBlack){
    	if (userBlack.getId() == null){
    		userBlackService.insert(userBlack);
    	}else{
    		userBlackService.updateByPrimaryKeySelective(userBlack);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserBlack userBlack = userBlackService.selectByPrimaryKey(id);
       	return ok(userBlack);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userBlackService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}