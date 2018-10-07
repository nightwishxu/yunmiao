package com.item.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dialect.PaginationSupport;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.Focus;
import com.item.daoEx.model.FocusEx;
import com.item.service.FocusService;


@Controller
@RequestMapping("focus")
@LoginFilter
public class FocusController extends CoreController{
	@Autowired
	private FocusService focusService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page,Integer rows,Integer location){
		PaginationSupport.byPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("location", location);
		String areaCode = getSessionParameter("areaCode");
		if(StringUtils.isBlank(areaCode) && location == 1)areaCode = "0";
		//map.put("areaCode", areaCode);
		List<FocusEx> list = focusService.selectList(map);
		return page(list);
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public String del(String id){
		String[] ids =id.split(",");
		for (int i = 0; i < ids.length; i++) {
			focusService.deleteByPrimaryKey(Integer.parseInt(ids[i]));
		}
		return ok();
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Focus focus,Integer location){
		if(focus.getId() == null) {//添加
			if(location == 5){
				focus.setImg("");
				focus.setRedirectType(0);
			}
//			String areaCode = getSessionParameter("areaCode");
			focus.setCreateTime(new Date());
//			focus.setAreaCode(areaCode);
			this.focusService.insert(focus);
		}else{//update
			this.focusService.updateByPrimaryKeySelective(focus);
		}
		return ok();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public String findById(Integer id) throws Exception{
		Focus focus = this.focusService.selectByPrimaryKey(id);
		return ok(focus);
	}

	@RequestMapping("/listTo")
	@ResponseBody
	public String list(Integer page,Integer rows){
		PaginationSupport.byPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		String areaCode = getSessionParameter("areaCode");
		//map.put("areaCode", areaCode);
		List<FocusEx> list = focusService.selectListTo(map);
		return page(list);
	}
	@RequestMapping("/listToStore")
	@ResponseBody
	public String listToStore(Integer page,Integer rows){
		PaginationSupport.byPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		String areaCode = getSessionParameter("areaCode");
		//map.put("areaCode", areaCode);
		List<FocusEx> list = focusService.listToStore(map);
		return page(list);
	}
	@RequestMapping("/findByLocation")
	@ResponseBody
	public String findByLocation(Integer location) throws Exception{
		Focus focus = this.focusService.findByLocation(location);
		return ok(focus);
	}
}
