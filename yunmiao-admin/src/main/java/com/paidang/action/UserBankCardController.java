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
import com.paidang.dao.model.UserBankCard;
import com.paidang.dao.model.UserBankCardExample;
import com.paidang.service.UserBankCardService;

/**
@author sun
*/
@RequestMapping("userBankCard")
@Controller
@LoginFilter
public class UserBankCardController extends CoreController{

    @Autowired
    private UserBankCardService userBankCardService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserBankCardExample example = new UserBankCardExample();
    	
    	List<UserBankCard> list = userBankCardService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserBankCard userBankCard){
    	if (userBankCard.getId() == null){
    		userBankCardService.insert(userBankCard);
    	}else{
    		userBankCardService.updateByPrimaryKeySelective(userBankCard);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserBankCard userBankCard = userBankCardService.selectByPrimaryKey(id);
       	return ok(userBankCard);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userBankCardService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}