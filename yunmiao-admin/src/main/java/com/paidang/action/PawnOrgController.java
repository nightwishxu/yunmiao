package com.paidang.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.des.Md5;
import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import com.base.security.util.UserUtils;
import com.paidang.daoEx.model.GoodsEx;
import com.paidang.daoEx.model.PawnOrgEx;
import com.util.PaidangConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.paidang.dao.model.PawnOrg;
import com.paidang.dao.model.PawnOrgExample;
import com.paidang.service.PawnOrgService;

/**
@author sun
*/
@RequestMapping("pawnOrg")
@Controller
@LoginFilter
public class PawnOrgController extends CoreController{

    @Autowired
    private PawnOrgService pawnOrgService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows, String name, Integer type){
    	PaginationSupport.byPage(page, rows);
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("name",name);
    	map.put("type",type);
    	List<PawnOrgEx> list = pawnOrgService.selectList(map);
      	return page(list);
    }

	@RequestMapping("/pawnMsg")
	@ResponseBody
	public String pawnMsg(){
		PawnOrgExample example = new PawnOrgExample();
		example.createCriteria();
		example.setOrderByClause("create_time desc");
		List<PawnOrg> list = pawnOrgService.selectByExample(example);
		return ok(list);
	}
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PawnOrg pawnOrg)throws Exception{

    	if (pawnOrg.getId() == null){
    		if(pawnOrg.getType()==1){
				pawnOrg.setRoleCode(PaidangConst.ORG_ROLE);
			}else if(pawnOrg.getType()==3){
				pawnOrg.setRoleCode(PaidangConst.SUPPLIER_ROLE);
			}
			pawnOrg.setPassword(Md5.md5("1"));
			pawnOrg.setBalance(BigDecimal.ZERO);
			pawnOrg.setState(2);
			//pawnOrg.setType(1);
    		pawnOrgService.insert(pawnOrg);
    	}else{
    		pawnOrgService.updateByPrimaryKeySelective(pawnOrg);
    	}
       	return ok();
    }

	@RequestMapping("/saveService")
	@ResponseBody
	public String saveService(PawnOrg pawnOrg)throws Exception{

		if (pawnOrg.getId() == null){
			pawnOrg.setBalance(BigDecimal.ZERO);
			pawnOrg.setRoleCode(PaidangConst.SERVICE_ORG_ROLE);
			pawnOrg.setPassword(Md5.md5(PaidangConst.INIT_PASSWORD));
			pawnOrg.setType(2);
			pawnOrgService.insert(pawnOrg);
		}else{
			pawnOrgService.updateByPrimaryKeySelective(pawnOrg);
		}
		return ok();
	}

	@RequestMapping("/changePwds")
	@ResponseBody
	public String changePwds(PawnOrg pawnOrg)throws Exception{
			pawnOrgService.changePwd(pawnOrg.getId(),pawnOrg.getPassword());
		return ok();
	}

    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PawnOrg pawnOrg = pawnOrgService.selectByPrimaryKey(id);
       	return ok(pawnOrg);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		pawnOrgService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	@RequestMapping("/changeState")
	@ResponseBody
	public String changeState(Integer id,Integer v){
    	PawnOrg pawnOrg=new PawnOrg();
    	pawnOrg.setId(id);
    	Integer state=null;
    	if (v==0){
    		state=1;
		}else if(v==1){
    		state=0;
		}else if(v==2 || v==null){
    		state=1;
		}
		pawnOrg.setState(state);
		pawnOrgService.changeState(pawnOrg);
		return ok();
	}
}