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
import com.item.dao.model.WxUserInfo;
import com.item.dao.model.WxUserInfoExample;
import com.item.service.WxUserInfoService;

/**
@author sun
*/
@RequestMapping("wxUserInfo")
@Controller
@LoginFilter
public class WxUserInfoController extends CoreController{

    @Autowired
    private WxUserInfoService wxUserInfoService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	WxUserInfoExample example = new WxUserInfoExample();
    	
    	List<WxUserInfo> list = wxUserInfoService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(WxUserInfo wxUserInfo){
    	if (wxUserInfo.getId() == null){
    		wxUserInfoService.insert(wxUserInfo);
    	}else{
    		wxUserInfoService.updateByPrimaryKeySelective(wxUserInfo);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	WxUserInfo wxUserInfo = wxUserInfoService.selectByPrimaryKey(id);
       	return ok(wxUserInfo);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		wxUserInfoService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }


}