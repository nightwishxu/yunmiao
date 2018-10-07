package com.weixin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.util.StringUtil;
import com.base.web.annotation.LoginFilter;
import com.github.sd4324530.fastweixin.api.MenuAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.api.entity.MenuButton;
import com.github.sd4324530.fastweixin.api.enums.MenuType;
import com.github.sd4324530.fastweixin.api.enums.ResultType;
import com.weixin.dao.model.Menu;
import com.weixin.dao.model.MenuExample;
import com.weixin.dao.model.MenuExample.Criteria;
import com.weixin.dao.model.MenuKey;
import com.weixin.daoEx.model.MenuEx;
import com.weixin.service.MenuService;

@Controller
@LoginFilter
@RequestMapping("/wxmenu")
public class MenuController extends CoreController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/tree")
	@ResponseBody 
	public String tree(String id,HttpSession session)throws Exception{
		String fid = WeixinController.getFid(session);
		
		MenuExample example = new MenuExample();
		Criteria criteria = example.createCriteria().andFidEqualTo(fid);
		
		example.setOrderByClause("sort_order");
		if(StringUtils.isNotBlank(id) && !id.equals("00"))
			criteria.andParentIdEqualTo(id);
		else
			criteria.andParentIdEqualTo("00");
		List<Menu> list = menuService.selectByExample(example);
		
		List<MenuEx> listEx = new ArrayList<MenuEx>();
		for (Menu menu : list) {
			MenuEx menuEx = new MenuEx();
			BeanUtils.copyProperties(menuEx, menu);
			if(StringUtils.isBlank(id) || id.equals("00"))
				menuEx.setState("closed");
			listEx.add(menuEx);
		}
		if(StringUtils.isBlank(id)){
			MenuEx cate = new MenuEx();
			cate.setId("00");
			cate.setName("微信自定义菜单");
			cate.setParentId("0");
			cate.setState("open");
			listEx.add(0, cate);
		}
		return JSONUtils.serialize(listEx);
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public synchronized String save(Menu cate,HttpSession session)throws Exception{
		String fid = WeixinController.getFid(session);
		
		if(cate.getType() == 2){
			cate.setActionKey("keyword_"+cate.getActionKey());
		}
		
		if(StringUtil.isEmpty(cate.getId())){
			MenuExample example = new MenuExample();
			example.createCriteria().andFidEqualTo(fid).andParentIdEqualTo(cate.getParentId());
			int cnt = menuService.countByExample(example);
			if(cate.getParentId().equals("00")){
				if(cnt>2){
					return JSONUtils.serialize(new Ret(1,"最多创建3 个一级菜单"));
				}
			}else{
				if(cnt>4){
					return JSONUtils.serialize(new Ret(1,"最多创建5 个二级菜单"));
				}
			}
			
			example.setOrderByClause("id desc");
			PaginationSupport.byPage(1, 1, false);
			List<Menu> list = menuService.selectByExample(example);
			if(list.size() == 0){
				cate.setId(cate.getParentId()+"01");
			}else{
				String id = list.get(0).getId();
				if(cate.getParentId().equals("00")){
					String str = String.format("%04d", Integer.parseInt(id)+1);  
					cate.setId(str);
				}else{
					String str = String.format("%06d", Integer.parseInt(id)+1);  
					cate.setId(str);
				}
			}
			cate.setFid(fid);
			menuService.insert(cate);
		}else{
			if(cate.getParentId().equals("00")){
				MenuKey key = new MenuKey();
				key.setFid(fid);
				key.setId(cate.getId());
				Menu menu = menuService.selectByPrimaryKey(key);
				if(menu.getType() == 0 && cate.getType()!=0){
					MenuExample example = new MenuExample();
					example.createCriteria().andFidEqualTo(fid).andParentIdEqualTo(cate.getId());
					menuService.deleteByExample(example);
				}
			}
			menuService.updateByPrimaryKeySelective(cate);
		}
		return JSONUtils.serialize(new Ret(0));
	}
	
	@RequestMapping(value="/findById")
	@ResponseBody
	public String findById(String id,HttpSession session) throws Exception {
		String fid = WeixinController.getFid(session);
		
		MenuKey key = new MenuKey();
		key.setFid(fid);
		key.setId(id);
		Menu menu = menuService.selectByPrimaryKey(key);
		if (menu.getType() == 2) {
			menu.setActionKey(menu.getActionKey().substring(8));
		}
		return JSONUtils.serialize(menu);
	}

	@RequestMapping("/del")
	@ResponseBody
	public String del(String code,HttpSession session)throws Exception{
		String fid = WeixinController.getFid(session);
		String[] ids = code.split(",");
		MenuExample example = new MenuExample();
		for (String c : ids) {
			example.createCriteria().andFidEqualTo(fid).andIdLike(c+"%");
			menuService.deleteByExample(example);
		}
		return JSONUtils.serialize(new Ret(0));
	}
	
	@RequestMapping("/publish")
	@ResponseBody
	public String publish(HttpSession session)throws Exception{
		String fid = WeixinController.getFid(session);
		ApiConfig config = WeixinController.getApiConfig(session);
		if(config == null) return JSONUtils.serialize(new Ret(1,"尚未开启微信公众平台管理服务"));
		
		MenuExample example = new MenuExample();
		example.createCriteria().andFidEqualTo(fid);
		example.setOrderByClause("parent_id,sort_order");
		List<Menu> list = menuService.selectByExample(example);
		
		if(list.size()>0){
	        List<MenuButton> mainList = new ArrayList<MenuButton>();
	        
	        for (int i = 0; i < list.size(); i++) {
	        	Menu menu = list.get(i);
	        	if(menu.getParentId().equals("00")){
	        		//准备一级主菜单
	                MenuButton main = new MenuButton();
	                main.setName(menu.getName());
	                
	                if(menu.getType() == 0){
	                	//准备子菜单
	                	List<MenuButton> sublist = new ArrayList<MenuButton>();
	                	for (int j = 0; j < list.size();) {
	                		Menu submenu = list.get(j);
	                		if(submenu.getParentId().equals(menu.getId())){
	                			MenuButton sub = new MenuButton();
	                			sub.setName(submenu.getName());
	                			excuMenuButton(submenu,sub);
	                			
	                			//加入子菜单列表
	                			sublist.add(sub);
	                			
	                			list.remove(j);
	                		}else{
	                			j++;
	                		}
	                	}
	                	//将子菜单放入主菜单里
	                	if(sublist.size() == 0){
	                		return JSONUtils.serialize(new Ret(1,"一级菜单["+main.getName()+"]下缺少子菜单"));
	                	}
	                	main.setSubButton(sublist);
	                }else{
	                	excuMenuButton(menu,main);
	                }
	                //加入主菜单列表
	                mainList.add(main);
	        	}
			}
	        //将主菜单加入请求对象
	        com.github.sd4324530.fastweixin.api.entity.Menu request = new com.github.sd4324530.fastweixin.api.entity.Menu();
	        request.setButton(mainList);
	        logger.debug(request.toJsonString());
	        
	        MenuAPI menuAPI = new MenuAPI(config);
	        //先删除之前的菜单
	        menuAPI.deleteMenu();
	        //创建菜单
	        ResultType resultType = menuAPI.createMenu(request);
	        if(resultType == null)return JSONUtils.serialize(new Ret(1,"发布失败"));
	        logger.debug(resultType.toString());
		}
		
		return JSONUtils.serialize(new Ret(0));
	}
	
	private void excuMenuButton(Menu menu,MenuButton main){
		switch (menu.getType()) {
		case 1:
			main.setType(MenuType.VIEW);
			main.setUrl(menu.getUrl());
			break;
		case 2:
			main.setType(MenuType.CLICK);
			main.setKey(menu.getActionKey());
			break;
		case 3:
			main.setType(MenuType.CLICK);
			main.setKey(menu.getActionKey());
			break;
		default:
			break;
		}
	}
}
