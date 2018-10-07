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
import com.paidang.dao.model.OrgBalanceLog;
import com.paidang.dao.model.OrgBalanceLogExample;
import com.paidang.service.OrgBalanceLogService;

/**
@author sun
*/
@RequestMapping("orgBalanceLog")
@Controller
@LoginFilter
public class OrgBalanceLogController extends CoreController{

    @Autowired
    private OrgBalanceLogService orgBalanceLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	OrgBalanceLogExample example = new OrgBalanceLogExample();
    	
    	List<OrgBalanceLog> list = orgBalanceLogService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(OrgBalanceLog orgBalanceLog){
    	if (orgBalanceLog.getId() == null){
    		orgBalanceLogService.insert(orgBalanceLog);
    	}else{
    		orgBalanceLogService.updateByPrimaryKeySelective(orgBalanceLog);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	OrgBalanceLog orgBalanceLog = orgBalanceLogService.selectByPrimaryKey(id);
       	return ok(orgBalanceLog);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		orgBalanceLogService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}