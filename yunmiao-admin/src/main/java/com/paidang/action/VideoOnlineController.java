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
import com.paidang.dao.model.VideoOnline;
import com.paidang.dao.model.VideoOnlineExample;
import com.paidang.service.VideoOnlineService;

/**
@author sun
*/
@RequestMapping("videoOnline")
@Controller
@LoginFilter
public class VideoOnlineController extends CoreController{

    @Autowired
    private VideoOnlineService videoOnlineService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	VideoOnlineExample example = new VideoOnlineExample();
    	example.setOrderByClause("create_time desc");
    	List<VideoOnline> list = videoOnlineService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(VideoOnline videoOnline){
    	if (videoOnline.getId() == null){
    		videoOnline.setViewCnt(0);
    		videoOnlineService.insert(videoOnline);
    	}else{
    		videoOnlineService.updateByPrimaryKeySelective(videoOnline);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	VideoOnline videoOnline = videoOnlineService.selectByPrimaryKey(id);
       	return ok(videoOnline);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		videoOnlineService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }
}