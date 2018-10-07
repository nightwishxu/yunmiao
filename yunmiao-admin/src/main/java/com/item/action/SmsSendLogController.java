package com.item.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.DateUtil;
import com.base.util.JSONUtils;
import com.base.util.SendsmsUtil;
import com.item.dao.model.SmsSendLog;
import com.item.dao.model.SmsSendLogExample;
import com.item.daoEx.model.SmsSendLogEx;
import com.item.service.SmsSendLogService;

@RequestMapping("smsSendLog")
@Controller
public class SmsSendLogController extends CoreController{

    @Autowired
    private SmsSendLogService smsSendLogService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows, String phone, String device, String ip, String code, String time) throws Exception{
    	PaginationSupport.byPage(page, rows);
    	SmsSendLogExample example = new SmsSendLogExample();
    	example.setOrderByClause("create_time desc");
    	SmsSendLogExample.Criteria criteria = example.createCriteria();
    	if(StringUtils.isNotBlank(phone)){
    		criteria.andPhoneLike(phone);
    	}
    	if (StringUtils.isNotBlank(device)){
    		criteria.andDeviceIdLike(device);
    	}
    	if (StringUtils.isNotBlank(ip)){
    		criteria.andIpLike(ip);
    	}
    	if (StringUtils.isNotBlank(code)){
    		criteria.andCodeEqualTo(code);
    	}
    	if (StringUtils.isNotBlank(time)){
    		Date date = DateUtil.strToDate(time, "yyyy-MM-dd");
    		criteria.andCreateTimeGreaterThan(date).andCreateTimeLessThan(DateUtil.add(date, 1));
    	}
    	List<SmsSendLog> list = smsSendLogService.selectByExample(example);
    	
    	List<SmsSendLogEx> exs = new ArrayList<SmsSendLogEx>();
    	for (SmsSendLog log : list){
    		SmsSendLogEx ex = new SmsSendLogEx();
    		BeanUtils.copyProperties(ex, log);
    		ex.setErrorName(SendsmsUtil.getSmsError(ex.getCode()));
    		exs.add(ex);
    	}
    	
      	return page(exs);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(SmsSendLog smsSendLog){
    	if (smsSendLog.getId() == null){
    		smsSendLogService.insert(smsSendLog);
    	}else{
    		smsSendLogService.updateByPrimaryKeySelective(smsSendLog);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	SmsSendLog smsSendLog = smsSendLogService.selectByPrimaryKey(id);
       	return ok(smsSendLog);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		smsSendLogService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }
}
