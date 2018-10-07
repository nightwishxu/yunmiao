package com.weixin.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.CoreConstants;
import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.util.BeanUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.weixin.dao.model.Weixin;
import com.weixin.daoEx.model.WeixinEx;
import com.weixin.service.WeixinService;

@RequestMapping("wx")
@Controller
@LoginFilter
public class AccountController extends CoreController{

    @Autowired
    private WeixinService weixinService;
    
    private static String baseUrl = CoreConstants.getProperty("weixin.baseUrl","");
    private static String token = CoreConstants.getProperty("weixin.token","");
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Weixin weixin,HttpSession session)throws Exception{
    	String fid = WeixinController.getFid(session);
    	Weixin wx = weixinService.selectByPrimaryKey(fid);
    	if (wx == null){
    		weixin.setUserId(fid);
    		weixinService.insert(weixin);
    	}else{
    		weixinService.updateByPrimaryKeySelective(weixin);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(HttpSession session)throws Exception{
    	String fid = WeixinController.getFid(session);
    	Weixin wx = weixinService.selectByPrimaryKey(fid);
    	WeixinEx ex = new WeixinEx();
        if(wx!=null){
    		BeanUtils.copyProperties(wx, ex);
    	}else{
    		ex.setUserId(fid);
    	}
    	
    	if(fid.equals("0")){
    		ex.setToken(token);
    		ex.setUrl(baseUrl+"/weixin");
    	}else{
    		ex.setToken(ex.getUserId());
    		ex.setUrl(baseUrl+"/weixin?userid="+ex.getUserId());
    	}
    	
       	return JSONUtils.serialize(ex);
    }
}
