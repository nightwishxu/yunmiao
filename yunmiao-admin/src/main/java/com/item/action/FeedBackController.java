package com.item.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.item.daoEx.model.FeedbackEx;
import com.item.service.FeedbackService;


@RequestMapping("feedback")
@Controller
@LoginFilter
public class FeedBackController extends CoreController {
	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping("/list")
	@ResponseBody
	public String findlist(HttpSession session, Integer page, Integer rows) {
		PaginationSupport.byPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		List<FeedbackEx> list = this.feedbackService.selectList(map);
		return page(list);
	}

	@RequestMapping("/del")
	@ResponseBody
	public String del(String id) {
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			this.feedbackService.deleteByPrimaryKey(Integer.parseInt(ids[i]));
		}
		return ok();
	}

}
