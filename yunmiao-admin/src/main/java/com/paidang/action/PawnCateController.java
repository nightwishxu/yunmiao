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
import com.paidang.dao.model.PawnCate;
import com.paidang.dao.model.PawnCateExample;
import com.paidang.service.PawnCateService;

/**
@author sun
*/
@RequestMapping("pawnCate")
@Controller
@LoginFilter
public class PawnCateController extends CoreController{

    @Autowired
    private PawnCateService pawnCateService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	PawnCateExample example = new PawnCateExample();
		example.setOrderByClause("sort_order asc,create_time desc");
    	List<PawnCate> list = pawnCateService.selectByExample(example);
      	return page(list);
    }

	@RequestMapping("/all")
	@ResponseBody
	public String all(){
		PawnCateExample example = new PawnCateExample();
		example.setOrderByClause("sort_order asc,create_time desc");
		List<PawnCate> list = pawnCateService.selectByExample(example);
		return ok(list);
	}
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(PawnCate pawnCate){
    	if (pawnCate.getId() == null){
    		pawnCateService.insert(pawnCate);
    	}else{
    		pawnCateService.updateByPrimaryKeySelective(pawnCate);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	PawnCate pawnCate = pawnCateService.selectByPrimaryKey(id);
       	return ok(pawnCate);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		pawnCateService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}