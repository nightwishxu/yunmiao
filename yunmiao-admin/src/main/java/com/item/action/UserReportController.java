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
import com.item.dao.model.UserReport;
import com.item.dao.model.UserReportExample;
import com.item.service.UserReportService;

/**
@author sun
*/
@RequestMapping("userReport")
@Controller
@LoginFilter
public class UserReportController extends CoreController{

    @Autowired
    private UserReportService userReportService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserReportExample example = new UserReportExample();
    	
    	List<UserReport> list = userReportService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserReport userReport){
    	if (userReport.getId() == null){
    		userReportService.insert(userReport);
    	}else{
    		userReportService.updateByPrimaryKeySelective(userReport);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserReport userReport = userReportService.selectByPrimaryKey(id);
       	return ok(userReport);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userReportService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}