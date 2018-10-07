package com.item.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.UserCreditLog;
import com.item.dao.model.UserCreditLogExample;
import com.item.dao.model.UserCreditLogExample.Criteria;
import com.item.service.UserCreditLogService;

@RequestMapping("userCreditLog")
@Controller
@LoginFilter
public class UserCreditLogController extends CoreController{
	@Autowired
	private UserCreditLogService userCreditLogService;

	@RequestMapping("/listByUserId")
	@ResponseBody
	public String list(String id,Integer type,Integer page,Integer rows){
		UserCreditLogExample example = new UserCreditLogExample();
		example.setOrderByClause("create_time desc");
		PaginationSupport.byPage(page, rows);
		Criteria criteria = example.createCriteria().andUserIdEqualTo(id);
		if(type != null){
			criteria.andTypeEqualTo(type);
		}
		List<UserCreditLog> list = this.userCreditLogService.selectByExample(example);
		return page(list);
	}
}
