package com.item.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dao.model.Ret;
import com.base.dao.model.TaskLog;
import com.base.dao.model.TaskLogExample;
import com.base.dao.model.TaskLogExample.Criteria;
import com.base.dialect.PaginationSupport;
import com.base.service.TaskLogService;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;


@RequestMapping("taskLog")
@Controller
@LoginFilter
public class TaskLogController extends CoreController {
	@Autowired
	private TaskLogService logService;

	@RequestMapping("/list")
	@ResponseBody
	public String findlist(Integer page, Integer rows,String jobId,Integer status) {
		PaginationSupport.byPage(page, rows);
		TaskLogExample example = new TaskLogExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("create_time desc");
		if(StringUtils.isNotBlank(jobId))criteria.andJobIdEqualTo(jobId);
		if(status != null)criteria.andStatusEqualTo(status);
		List<TaskLog> list = logService.selectByExample(example);
		return page(list);
	}

	@RequestMapping("/del")
	@ResponseBody
	public String del(String id) {
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			logService.deleteByPrimaryKey(ids[i]);
		}
		return ok();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public String findById(String id) throws Exception{
		TaskLog log = this.logService.selectByPrimaryKey(id);
		return ok(log);
	}
}
