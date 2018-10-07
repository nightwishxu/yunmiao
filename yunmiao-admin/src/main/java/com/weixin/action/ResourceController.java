package com.weixin.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.weixin.dao.model.ArticleExample;
import com.weixin.dao.model.Resource;
import com.weixin.daoEx.model.ResourceEx;
import com.weixin.service.ArticleService;
import com.weixin.service.ResourceService;

@RequestMapping("wxres")
@Controller
@LoginFilter
public class ResourceController extends CoreController{

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private ArticleService articleService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows,HttpSession session){
    	String fid = WeixinController.getFid(session);
    	PaginationSupport.byPage(page, rows);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("fid", fid);
    	List<ResourceEx> list = resourceService.selectList(map);
      	return JSONUtils.serialize(new Grid(PaginationSupport.getContext().getTotalCount(), list));
    }
    
    @RequestMapping("/all")
	@ResponseBody 
    public String all(HttpSession session){
    	String fid = WeixinController.getFid(session);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("fid", fid);
    	List<ResourceEx> list = resourceService.selectList(map);
      	return JSONUtils.serialize(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Resource resource,HttpSession session){
    	String fid = WeixinController.getFid(session);
    	if (StringUtils.isBlank(resource.getId())){
    		resource.setFid(fid);
    		resource.setCreateTime(new Date());
    		resourceService.insert(resource);
    	}else{
    		resourceService.updateByPrimaryKeySelective(resource);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(String id){
    	Resource resource = resourceService.selectByPrimaryKey(id);
       	return JSONUtils.serialize(resource);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		ArticleExample example = new ArticleExample();
    		example.createCriteria().andResIdEqualTo(str);
    		articleService.deleteByExample(example);
    		resourceService.deleteByPrimaryKey(str);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }


}
