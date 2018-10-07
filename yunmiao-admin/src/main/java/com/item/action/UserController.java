//package com.item.action;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.item.dao.model.UserExample;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.base.action.CoreController;
//import com.base.des.Md5;
//import com.base.dialect.PaginationSupport;
//import com.base.web.annotation.LoginFilter;
//import com.item.dao.model.User;
//import com.item.daoEx.model.UserEx;
//import com.item.service.UserService;
//
//@RequestMapping("user")
//@Controller
//@LoginFilter
//public class UserController extends CoreController{
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping("/orgUsersList")
//	@ResponseBody
//	public String selectOrgUsersList(String name,Integer page,Integer rows) throws Exception{
//		PaginationSupport.byPage(page, rows);
//		Map<String,Object> map = new HashMap<String,Object>();
//		String orgId = getSessionParameter("id");
//
//		map.put("orgId",orgId);
//	   //map.put("key", "'%"+name+"%'");
//	    map.put("key",name);
//		List<UserEx> list= userService.selectOrgUsersList(map);
//		return page(list);
//	}
//
//
//	@RequestMapping("/list")
//	@ResponseBody
//	public String selectUserList(String name,Integer page,Integer rows) throws Exception{
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("key", name);
//		PaginationSupport.byPage(page, rows);
//		List<UserEx> list= userService.selectList(map);
//		return page(list);
//	}
//
//	@RequestMapping("/duplicateCheck")
//	@ResponseBody
//	public String duplicateCheck(String accountInput) throws Exception{
//		UserExample example = new UserExample();
//		example.createCriteria().andTypeEqualTo(1);
//		List<User> allOrgUsers = userService.selectByExample(example);
//		for (User element:allOrgUsers) {
//			if (element.getAccount().equals(accountInput)){
//				return msg(-1,"您输入的账户名已存在，请重新填写用户名");
//			}
//		}
//		return ok();
//	}
//
//
//	@RequestMapping("/saveOrgUser")
//	@ResponseBody
//	public String saveOrgUser(User user) throws Exception{
//		String orgId = getSessionParameter("id");
//		if (StringUtils.isEmpty(user.getAccount())){
//			return msg(-1,"用户账户不能为空");
//		}
//		if (user.getId() == null){
//			//添加用户时判断输入的账号是否已存在
//			UserExample example = new UserExample();
//			example.createCriteria().andTypeEqualTo(1);
//			List<User> allOrgUsers = userService.selectByExample(example);
//			for (User element:allOrgUsers) {
//				if (user.getAccount().equals(element.getAccount())){
//					return msg(-1,"您输入的账户名已存在，请重新填写用户名");
//				}
//			}
//			user.setPassword(Md5.md5("1"));
//			user.setType(1);//表示机构用户
//			user.setState(1);
//			user.setOrgId(Integer.valueOf(orgId));
//			userService.insert(user);
//		}else{
//			userService.updateByPrimaryKeySelective(user);
//		}
//		return ok();
//	}
//
//	@RequestMapping("/update")
//	@ResponseBody
//	public String update(User user){
//		if(!StringUtils.isBlank(user.getPassword()))
//		    user.setPassword(Md5.mD5(user.getPassword()));
//		this.userService.updateByPrimaryKeySelective(user);
//		return ok();
//	}
//
//	@RequestMapping("/findById")
//	@ResponseBody
//	public String find(Integer id){
//		User user = userService.selectByPrimaryKey(id);
//		return ok(user);
//	}
//
//
//	@RequestMapping("/del")
//	@ResponseBody
//	public String del(String id){
//		String[] ids = id.split(",");
//		for (String str : ids){
//			userService.deleteByPrimaryKey(Integer.parseInt(str));
//		}
//		return ok();
//	}
//	/*@RequestMapping("detail")
//	@ResponseBody
//	public String detail() throws Exception{
//		UserExample example = new UserExample();
//		List<User> list = userService.selectByExample(example);
//		return list.get(0);
//	}*/
//
//	@RequestMapping("/save")
//	@ResponseBody
//	public String save(User user){
//		if(user.getId() == null){
//			userService.insert(user);
//		}else{
//			userService.updateByPrimaryKeySelective(user);
//		}
//		return ok();
//	}
//}
