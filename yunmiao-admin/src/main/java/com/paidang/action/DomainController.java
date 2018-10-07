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
import com.paidang.dao.model.Domain;
import com.paidang.dao.model.DomainExample;
import com.paidang.service.DomainService;

/**
@author sun
*/
@RequestMapping("domain")
@Controller
@LoginFilter
public class DomainController extends CoreController{

    @Autowired
    private DomainService domainService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	DomainExample example = new DomainExample();
    	
    	List<Domain> list = domainService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Domain domain){
    	if (domain.getId() == null){
    		domainService.insert(domain);
    	}else{
    		domainService.updateByPrimaryKeySelective(domain);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Domain domain = domainService.selectByPrimaryKey(id);
       	return ok(domain);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		domainService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	@RequestMapping("/domainList")
	@ResponseBody
	public List<Domain> domainList(){
		DomainExample example = new DomainExample();

		List<Domain> list = domainService.selectByExample(example);
		return list;
	}


}