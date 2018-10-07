package com.weixin.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.weixin.dao.model.FirstAttention;
import com.weixin.service.FirstAttentionService;

@RequestMapping("wxfa")
@Controller
@LoginFilter
public class FirstAttentionController extends CoreController{

    @Autowired
    private FirstAttentionService firstAttentionService;
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(FirstAttention firstAttention,HttpSession session)throws Exception{
    	String fid = WeixinController.getFid(session);
    	FirstAttention attention = firstAttentionService.selectByPrimaryKey(fid);
    	if (attention == null){
    		firstAttention.setFid(fid);
    		firstAttentionService.insert(firstAttention);
    	}else{
    		firstAttentionService.updateByPrimaryKeySelective(firstAttention);
    	}
       	return JSONUtils.serialize(new Ret(0));
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(HttpSession session)throws Exception{
    	String fid = WeixinController.getFid(session);
    	FirstAttention firstAttention = firstAttentionService.selectByPrimaryKey(fid);
       	return JSONUtils.serialize(firstAttention);
    }
}
