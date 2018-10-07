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
import com.item.dao.model.WxUserNotify;
import com.item.dao.model.WxUserNotifyExample;
import com.item.service.WxUserNotifyService;

/**
@author sun
*/
@RequestMapping("wxUserNotify")
@Controller
@LoginFilter
public class WxUserNotifyController extends CoreController{

    @Autowired
    private WxUserNotifyService wxUserNotifyService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	WxUserNotifyExample example = new WxUserNotifyExample();
    	
    	List<WxUserNotify> list = wxUserNotifyService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(WxUserNotify wxUserNotify){
    	if (wxUserNotify.getId() == null){
    		wxUserNotifyService.insert(wxUserNotify);
    	}else{
    		wxUserNotifyService.updateByPrimaryKeySelective(wxUserNotify);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	WxUserNotify wxUserNotify = wxUserNotifyService.selectByPrimaryKey(id);
       	return ok(wxUserNotify);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		wxUserNotifyService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}