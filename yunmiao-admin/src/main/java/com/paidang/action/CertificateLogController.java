package com.paidang.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.dialect.PaginationSupport;
import com.base.dao.model.Ret;
import com.base.dao.model.Grid;
import com.base.util.DateUtil;
import com.base.util.StringUtil;
import com.paidang.daoEx.model.CertificateLogEx;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import com.base.action.CoreController;
import com.paidang.dao.model.CertificateLog;
import com.paidang.dao.model.CertificateLogExample;
import com.paidang.service.CertificateLogService;

/**
@author sun
*/
@RequestMapping("certificateLog")
@Controller
@LoginFilter
public class CertificateLogController extends CoreController{

    @Autowired
    private CertificateLogService certificateLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	CertificateLogExample example = new CertificateLogExample();
    	
    	List<CertificateLog> list = certificateLogService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(CertificateLog certificateLog,String times){
//    	if(StringUtil.isNotBlank(times)){
//
//			certificateLog.setLogTime(DateUtil.strToDate(times));
//		}
    	if (certificateLog.getId() == null){
    		certificateLogService.insert(certificateLog);
    	}else{
    		certificateLogService.updateByPrimaryKeySelective(certificateLog);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	CertificateLog certificateLog = certificateLogService.selectByPrimaryKey(id);
       	return ok(certificateLog);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		certificateLogService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

}