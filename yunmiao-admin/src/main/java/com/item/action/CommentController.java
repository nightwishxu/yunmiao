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
import com.item.dao.model.Comment;
import com.item.dao.model.CommentExample;
import com.item.service.CommentService;

/**
@author sun
*/
@RequestMapping("comment")
@Controller
@LoginFilter
public class CommentController extends CoreController{

    @Autowired
    private CommentService commentService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	CommentExample example = new CommentExample();
    	
    	List<Comment> list = commentService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Comment comment){
    	if (comment.getId() == null){
    		commentService.insert(comment);
    	}else{
    		commentService.updateByPrimaryKeySelective(comment);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Comment comment = commentService.selectByPrimaryKey(id);
       	return ok(comment);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		commentService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}