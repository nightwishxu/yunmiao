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
import com.paidang.dao.model.VideoOnlineComment;
import com.paidang.dao.model.VideoOnlineCommentExample;
import com.paidang.service.VideoOnlineCommentService;

/**
@author sun
*/
@RequestMapping("videoOnlineComment")
@Controller
@LoginFilter
public class VideoOnlineCommentController extends CoreController{

    @Autowired
    private VideoOnlineCommentService videoOnlineCommentService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	VideoOnlineCommentExample example = new VideoOnlineCommentExample();
    	
    	List<VideoOnlineComment> list = videoOnlineCommentService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(VideoOnlineComment videoOnlineComment){
    	if (videoOnlineComment.getId() == null){
    		videoOnlineCommentService.insert(videoOnlineComment);
    	}else{
    		videoOnlineCommentService.updateByPrimaryKeySelective(videoOnlineComment);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	VideoOnlineComment videoOnlineComment = videoOnlineCommentService.selectByPrimaryKey(id);
       	return ok(videoOnlineComment);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		videoOnlineCommentService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}