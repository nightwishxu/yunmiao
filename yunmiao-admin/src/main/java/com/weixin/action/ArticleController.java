package com.weixin.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.weixin.dao.model.Article;
import com.weixin.dao.model.ArticleExample;
import com.weixin.service.ArticleService;

@RequestMapping("wxarticle")
@Controller
@LoginFilter
public class ArticleController extends CoreController{

    @Autowired
    private ArticleService articleService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows,String resId){
    	PaginationSupport.byPage(page, rows);
    	ArticleExample example = new ArticleExample();
    	example.createCriteria().andResIdEqualTo(resId);
    	example.setOrderByClause("sort_order,create_time");
    	List<Article> list = articleService.selectByExample(example);
      	return JSONUtils.serialize(new Grid(PaginationSupport.getContext().getTotalCount(), list));
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Article article){
    	if (StringUtils.isBlank(article.getId())){
    		ArticleExample example = new ArticleExample();
    		example.createCriteria().andResIdEqualTo(article.getResId());
			int cnt = articleService.countByExample(example);
			if(cnt>9){
				return JSONUtils.serialize(new Ret(1,"超出图文上限：10个"));
			}
    		
    		article.setCreateTime(new Date());
    		articleService.insert(article);
    	}else{
    		articleService.updateByPrimaryKeySelective(article);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(String id){
    	Article article = articleService.selectByPrimaryKey(id);
       	return JSONUtils.serialize(article);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		articleService.deleteByPrimaryKey(str);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }

    
    @RequestMapping("/findByResId")
	@ResponseBody 
    public String findByResId(String id){
    	ArticleExample example = new ArticleExample();
    	example.createCriteria().andResIdEqualTo(id);
    	example.setOrderByClause("sort_order,create_time");
    	List<Article> list = articleService.selectByExample(example);
       	return JSONUtils.serialize(list);
    }
}
