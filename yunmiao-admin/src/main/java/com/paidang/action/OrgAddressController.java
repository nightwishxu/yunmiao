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
import com.paidang.dao.model.OrgAddress;
import com.paidang.dao.model.OrgAddressExample;
import com.paidang.service.OrgAddressService;

/**
@author sun
*/
@RequestMapping("orgAddress")
@Controller
@LoginFilter
public class OrgAddressController extends CoreController{

    @Autowired
    private OrgAddressService orgAddressService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	OrgAddressExample example = new OrgAddressExample();
    	
    	List<OrgAddress> list = orgAddressService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(OrgAddress orgAddress){
    	if (orgAddress.getId() == null){
    		orgAddressService.insert(orgAddress);
    	}else{
    		orgAddressService.updateByPrimaryKeySelective(orgAddress);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	OrgAddress orgAddress = orgAddressService.selectByPrimaryKey(id);
       	return ok(orgAddress);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		orgAddressService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}