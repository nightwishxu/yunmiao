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
import com.paidang.dao.model.PlatformBalanceLog;
import com.paidang.dao.model.PlatformBalanceLogExample;
import com.paidang.service.PlatformBalanceLogService;

/**
@author sun
*/
@RequestMapping("platformBalanceLog")
@Controller
@LoginFilter
public class PlatformBalanceLogController extends CoreController{

    @Autowired
    private PlatformBalanceLogService platformBalanceLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	PlatformBalanceLogExample example = new PlatformBalanceLogExample();
    	
    	List<PlatformBalanceLog> list = platformBalanceLogService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PlatformBalanceLog platformBalanceLog){
    	if (platformBalanceLog.getId() == null){
    		platformBalanceLogService.insert(platformBalanceLog);
    	}else{
    		platformBalanceLogService.updateByPrimaryKeySelective(platformBalanceLog);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PlatformBalanceLog platformBalanceLog = platformBalanceLogService.selectByPrimaryKey(id);
       	return ok(platformBalanceLog);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		platformBalanceLogService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}