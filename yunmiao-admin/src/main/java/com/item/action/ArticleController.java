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
import com.item.dao.model.Article;
import com.item.dao.model.ArticleExample;
import com.item.service.ArticleService;

/**
@author sun
*/
@RequestMapping("article")
@Controller
@LoginFilter
public class ArticleController extends CoreController{

    @Autowired
    private ArticleService articleService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	ArticleExample example = new ArticleExample();
    	
    	List<Article> list = articleService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Article article){
    	if (article.getId() == null){
    		articleService.insert(article);
    	}else{
    		articleService.updateByPrimaryKeySelective(article);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Article article = articleService.selectByPrimaryKey(id);
       	return ok(article);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		articleService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}