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
import com.item.dao.model.UserPraise;
import com.item.dao.model.UserPraiseExample;
import com.item.service.UserPraiseService;

/**
@author sun
*/
@RequestMapping("userPraise")
@Controller
@LoginFilter
public class UserPraiseController extends CoreController{

    @Autowired
    private UserPraiseService userPraiseService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserPraiseExample example = new UserPraiseExample();
    	
    	List<UserPraise> list = userPraiseService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserPraise userPraise){
    	if (userPraise.getId() == null){
    		userPraiseService.insert(userPraise);
    	}else{
    		userPraiseService.updateByPrimaryKeySelective(userPraise);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserPraise userPraise = userPraiseService.selectByPrimaryKey(id);
       	return ok(userPraise);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userPraiseService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}