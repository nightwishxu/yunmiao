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
import com.paidang.dao.model.UserAddress;
import com.paidang.dao.model.UserAddressExample;
import com.paidang.service.UserAddressService;

/**
@author sun
*/
@RequestMapping("userAddress")
@Controller
@LoginFilter
public class UserAddressController extends CoreController{

    @Autowired
    private UserAddressService userAddressService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserAddressExample example = new UserAddressExample();
    	
    	List<UserAddress> list = userAddressService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserAddress userAddress){
    	if (userAddress.getId() == null){
    		userAddressService.insert(userAddress);
    	}else{
    		userAddressService.updateByPrimaryKeySelective(userAddress);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserAddress userAddress = userAddressService.selectByPrimaryKey(id);
       	return ok(userAddress);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userAddressService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}