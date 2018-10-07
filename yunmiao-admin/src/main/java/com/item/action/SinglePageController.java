package com.item.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Grid;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.SinglePage;
import com.item.dao.model.SinglePageExample;
import com.item.service.SinglePageService;

@Controller
@RequestMapping(value = "sp")
@LoginFilter
public class SinglePageController extends CoreController{
	@Autowired
	SinglePageService singlePageService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page,Integer rows){
		PaginationSupport.byPage(page, rows);
		SinglePageExample example = new SinglePageExample();
		example.setOrderByClause("sort_order desc");
		if(!getSessionParameter("sys").equals("administrator")){
			example.createCriteria().andIsShowEqualTo(1);
		}
		List<SinglePage> list = singlePageService.selectByExample(example);
		return page(list);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public String save(SinglePage news)throws Exception{
		int i = singlePageService.updateByPrimaryKeySelective(news);
		if(i == 0){
			singlePageService.insertSelective(news);
		}
		return ok();
	}
	
	@RequestMapping("/findByCode")
	@ResponseBody
	public String findByCode(String code){
		SinglePage singlePage = singlePageService.selectByPrimaryKey(code);
		return ok(singlePage);
	}
	
	@RequestMapping("del")
	@ResponseBody
	public String del(String id){
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			singlePageService.deleteByPrimaryKey(ids[i]);
		}
		return ok();
	}

	@RequestMapping("/checkExists")
	@ResponseBody
	public String checkExists(String value) throws Exception {
		SinglePageExample example = new SinglePageExample();
		example.createCriteria().andCodeEqualTo(value);
		int cnt = singlePageService.countByExample(example);
		if (cnt > 0) return msg(1);
		return ok();
	}
}
