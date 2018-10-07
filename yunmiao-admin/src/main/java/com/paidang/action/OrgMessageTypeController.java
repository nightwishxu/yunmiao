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
import com.paidang.dao.model.OrgMessageType;
import com.paidang.dao.model.OrgMessageTypeExample;
import com.paidang.service.OrgMessageTypeService;

/**
@author sun
*/
@RequestMapping("orgMessageType")
@Controller
@LoginFilter
public class OrgMessageTypeController extends CoreController{

    @Autowired
    private OrgMessageTypeService orgMessageTypeService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	OrgMessageTypeExample example = new OrgMessageTypeExample();
    	
    	List<OrgMessageType> list = orgMessageTypeService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(OrgMessageType orgMessageType){
    	if (orgMessageType.getId() == null){
    		orgMessageTypeService.insert(orgMessageType);
    	}else{
    		orgMessageTypeService.updateByPrimaryKeySelective(orgMessageType);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	OrgMessageType orgMessageType = orgMessageTypeService.selectByPrimaryKey(id);
       	return ok(orgMessageType);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		orgMessageTypeService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}