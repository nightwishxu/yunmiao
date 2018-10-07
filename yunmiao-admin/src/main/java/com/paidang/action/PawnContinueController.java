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
import com.paidang.dao.model.PawnContinue;
import com.paidang.dao.model.PawnContinueExample;
import com.paidang.service.PawnContinueService;

/**
@author sun
*/
@RequestMapping("pawnContinue")
@Controller
@LoginFilter
public class PawnContinueController extends CoreController{

    @Autowired
    private PawnContinueService pawnContinueService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	PawnContinueExample example = new PawnContinueExample();
    	
    	List<PawnContinue> list = pawnContinueService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PawnContinue pawnContinue){
    	if (pawnContinue.getId() == null){
    		pawnContinueService.insert(pawnContinue);
    	}else{
    		pawnContinueService.updateByPrimaryKeySelective(pawnContinue);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PawnContinue pawnContinue = pawnContinueService.selectByPrimaryKey(id);
       	return ok(pawnContinue);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		pawnContinueService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}