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
import com.item.dao.model.UserComment;
import com.item.dao.model.UserCommentExample;
import com.item.service.UserCommentService;

/**
@author sun
*/
@RequestMapping("userComment")
@Controller
@LoginFilter
public class UserCommentController extends CoreController{

    @Autowired
    private UserCommentService userCommentService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	UserCommentExample example = new UserCommentExample();
    	
    	List<UserComment> list = userCommentService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(UserComment userComment){
    	if (userComment.getId() == null){
    		userCommentService.insert(userComment);
    	}else{
    		userCommentService.updateByPrimaryKeySelective(userComment);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	UserComment userComment = userCommentService.selectByPrimaryKey(id);
       	return ok(userComment);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		userCommentService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}