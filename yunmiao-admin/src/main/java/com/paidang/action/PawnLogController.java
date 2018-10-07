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
import com.paidang.dao.model.PawnLog;
import com.paidang.dao.model.PawnLogExample;
import com.paidang.service.PawnLogService;

/**
@author sun
*/
@RequestMapping("pawnLog")
@Controller
@LoginFilter
public class PawnLogController extends CoreController{

    @Autowired
    private PawnLogService pawnLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	PawnLogExample example = new PawnLogExample();
    	
    	List<PawnLog> list = pawnLogService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PawnLog pawnLog){
    	if (pawnLog.getId() == null){
    		pawnLogService.insert(pawnLog);
    	}else{
    		pawnLogService.updateByPrimaryKeySelective(pawnLog);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PawnLog pawnLog = pawnLogService.selectByPrimaryKey(id);
       	return ok(pawnLog);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		pawnLogService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	@RequestMapping("/search")
	@ResponseBody
	public String list(Integer id){
		PawnLogExample example = new PawnLogExample();
		example.createCriteria().andGoodsIdEqualTo(id);
		example.setOrderByClause("create_time asc");
		List<PawnLog> list = pawnLogService.selectByExample(example);
		return ok(list);
	}
}