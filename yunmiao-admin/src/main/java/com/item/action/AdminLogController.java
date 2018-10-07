package com.item.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.AdminLog;
import com.base.dao.model.AdminLogExample;
import com.base.dao.model.AdminLogExample.Criteria;
import com.base.dao.model.Grid;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.log.annotation.ControllerLog;
import com.base.log.annotation.ServiceLog;
import com.base.service.AdminLogService;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;


@RequestMapping("adminLog")
@Controller
@LoginFilter
public class AdminLogController extends CoreController {
	@Autowired
	private AdminLogService logService;

	@RequestMapping("/list")
	@ResponseBody
	public String findlist(Integer page, Integer rows,Integer source,Integer type,String userId) {
		PaginationSupport.byPage(page, rows);
		AdminLogExample example = new AdminLogExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("create_time desc");
		if(source != null)criteria.andSourceEqualTo(source);
		if(type != null)criteria.andTypeEqualTo(type);
		if(StringUtils.isNotBlank(userId))criteria.andUserIdEqualTo(userId);
		List<AdminLog> list = logService.selectByExample(example);
		return page(list);
	}

	@RequestMapping("/del")
	@ResponseBody
	@ControllerLog(type=1,description="adminLog删除日志")
	public String del(String id) {
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			logService.deleteByPrimaryKey(ids[i]);
		}
		return ok();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	@ControllerLog(type=1,description="adminLog操作日志")
	public String findById(String id) throws Exception{
		AdminLog log = this.logService.selectByPrimaryKey(id);
		return ok(log);
	}
	
	@RequestMapping("/errorLog")
	@ResponseBody
	@ServiceLog(type=1,description="adminLog异常日志")
	public String errorLog() throws Exception{
		int a = 1,b = 0;
		int c = a/b;
		return JSONUtils.serialize(new Ret(c));
	}
}
