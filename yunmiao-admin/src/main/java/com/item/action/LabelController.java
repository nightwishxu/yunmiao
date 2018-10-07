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
import com.item.dao.model.Label;
import com.item.dao.model.LabelExample;
import com.item.service.LabelService;

/**
@author sun
*/
@RequestMapping("label")
@Controller
@LoginFilter
public class LabelController extends CoreController{

    @Autowired
    private LabelService labelService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	LabelExample example = new LabelExample();
    	
    	List<Label> list = labelService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Label label){
    	if (label.getId() == null){
    		labelService.insert(label);
    	}else{
    		labelService.updateByPrimaryKeySelective(label);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Label label = labelService.selectByPrimaryKey(id);
       	return ok(label);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		labelService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}