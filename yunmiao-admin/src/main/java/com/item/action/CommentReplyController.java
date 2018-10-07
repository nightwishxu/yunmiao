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
import com.item.dao.model.CommentReply;
import com.item.dao.model.CommentReplyExample;
import com.item.service.CommentReplyService;

/**
@author sun
*/
@RequestMapping("commentReply")
@Controller
@LoginFilter
public class CommentReplyController extends CoreController{

    @Autowired
    private CommentReplyService commentReplyService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	CommentReplyExample example = new CommentReplyExample();
    	
    	List<CommentReply> list = commentReplyService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(CommentReply commentReply){
    	if (commentReply.getId() == null){
    		commentReplyService.insert(commentReply);
    	}else{
    		commentReplyService.updateByPrimaryKeySelective(commentReply);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	CommentReply commentReply = commentReplyService.selectByPrimaryKey(id);
       	return ok(commentReply);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		commentReplyService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}