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
import com.item.dao.model.PlatformAuthenticationApply;
import com.item.dao.model.PlatformAuthenticationApplyExample;
import com.item.service.PlatformAuthenticationApplyService;

/**
@author sun
*/
@RequestMapping("platformAuthenticationApply")
@Controller
@LoginFilter
public class PlatformAuthenticationApplyController extends CoreController{

    @Autowired
    private PlatformAuthenticationApplyService platformAuthenticationApplyService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	PlatformAuthenticationApplyExample example = new PlatformAuthenticationApplyExample();
    	
    	List<PlatformAuthenticationApply> list = platformAuthenticationApplyService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PlatformAuthenticationApply platformAuthenticationApply){
    	if (platformAuthenticationApply.getId() == null){
    		platformAuthenticationApplyService.insert(platformAuthenticationApply);
    	}else{
    		platformAuthenticationApplyService.updateByPrimaryKeySelective(platformAuthenticationApply);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PlatformAuthenticationApply platformAuthenticationApply = platformAuthenticationApplyService.selectByPrimaryKey(id);
       	return ok(platformAuthenticationApply);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		platformAuthenticationApplyService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}