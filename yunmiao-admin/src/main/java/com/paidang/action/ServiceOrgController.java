package com.paidang.action;

import com.base.action.CoreController;
import com.base.des.Md5;
import com.base.dialect.PaginationSupport;
import com.base.web.annotation.LoginFilter;
import com.paidang.dao.model.ServiceOrg;
import com.paidang.dao.model.ServiceOrgExample;
import com.paidang.service.ServiceOrgService;
import com.util.PaidangConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
@author sun
*/
@RequestMapping("serviceOrg")
@Controller
@LoginFilter
public class ServiceOrgController extends CoreController{

    @Autowired
    private ServiceOrgService serviceOrgService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows, String name, String account){
    	PaginationSupport.byPage(page, rows);
    	ServiceOrgExample example = new ServiceOrgExample();
		ServiceOrgExample.Criteria	criteria = 	example.createCriteria();
		if(null!=name){
			criteria.andNameLike("%"+name+"%");
		}
		if(null!=account){
			criteria.andAccountLike("%"+account+"%");
		}
		example.setOrderByClause("create_time desc");
    	
    	List<ServiceOrg> list = serviceOrgService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(ServiceOrg serviceOrg) throws Exception {
    	if (serviceOrg.getId() == null){
    		serviceOrg.setRoleCode(PaidangConst.SERVICE_ORG_ROLE);
    		serviceOrg.setPassword(Md5.md5("1"));
			serviceOrg.setBalance(new BigDecimal("0") );
    		serviceOrgService.insert(serviceOrg);
    	}else{
			serviceOrg.setModifyTime(new Date());
    		serviceOrgService.updateByPrimaryKeySelective(serviceOrg);
    	}
       	return ok();
    }

	@RequestMapping("/changePwds")
	@ResponseBody
	public String changePwds(ServiceOrg serviceOrg)throws Exception{
		serviceOrgService.changePwd(serviceOrg.getId(),serviceOrg.getPassword());
		return ok();
	}
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	ServiceOrg serviceOrg = serviceOrgService.selectByPrimaryKey(id);
       	return ok(serviceOrg);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		serviceOrgService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}