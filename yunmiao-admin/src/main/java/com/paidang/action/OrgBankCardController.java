package com.paidang.action;

import com.base.action.CoreController;
import com.base.dialect.PaginationSupport;
import com.base.web.annotation.LoginFilter;
import com.paidang.dao.model.OrgBankCard;
import com.paidang.dao.model.OrgBankCardExample;
import com.paidang.service.OrgBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
@author sun
*/
@RequestMapping("orgBankCard")
@Controller
@LoginFilter
public class OrgBankCardController extends CoreController{

    @Autowired
    private OrgBankCardService orgBankCardService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
		String orgId = getSessionParameter("id");
    	OrgBankCardExample example = new OrgBankCardExample();
    	example.createCriteria().andOrgIdEqualTo(Integer.valueOf(orgId));
    	example.setOrderByClause("create_time desc");
		PaginationSupport.byPage(page, rows);
    	List<OrgBankCard> list = orgBankCardService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(OrgBankCard orgBankCard){
    	String orgId = getSessionParameter("id");
    	orgBankCard.setIsDefault(0);
    	orgBankCard.setOrgId(Integer.valueOf(orgId));
    	if (orgBankCard.getId() == null){
    		orgBankCardService.insert(orgBankCard);
    	}else{
    		orgBankCardService.updateByPrimaryKeySelective(orgBankCard);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	OrgBankCard orgBankCard = orgBankCardService.selectByPrimaryKey(id);
       	return ok(orgBankCard);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		orgBankCardService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}