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
import com.item.dao.model.CollectPraise;
import com.item.dao.model.CollectPraiseExample;
import com.item.service.CollectPraiseService;

/**
@author sun
*/
@RequestMapping("collectPraise")
@Controller
@LoginFilter
public class CollectPraiseController extends CoreController{

    @Autowired
    private CollectPraiseService collectPraiseService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	CollectPraiseExample example = new CollectPraiseExample();
    	
    	List<CollectPraise> list = collectPraiseService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(CollectPraise collectPraise){
    	if (collectPraise.getId() == null){
    		collectPraiseService.insert(collectPraise);
    	}else{
    		collectPraiseService.updateByPrimaryKeySelective(collectPraise);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	CollectPraise collectPraise = collectPraiseService.selectByPrimaryKey(id);
       	return ok(collectPraise);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		collectPraiseService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}