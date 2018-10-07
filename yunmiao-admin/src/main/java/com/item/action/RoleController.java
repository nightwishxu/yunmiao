package com.item.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.base.security.util.UserUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.des.Md5;
import com.base.dialect.PaginationSupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.item.dao.model.Admin;
import com.item.dao.model.AdminExample;
import com.item.dao.model.Right;
import com.item.dao.model.RightExample;
import com.item.dao.model.Role;
import com.item.dao.model.RoleExample;
import com.item.dao.model.RoleExample.Criteria;
import com.item.dao.model.UserGroup;
import com.item.dao.model.UserGroupExample;
import com.item.daoEx.model.AdminEx;
import com.item.daoEx.model.RightEx;
import com.item.daoEx.model.RoleEx;
import com.item.service.AdminService;
import com.item.service.RightService;
import com.item.service.RoleService;
import com.item.service.UserGroupService;
import com.item.util.RoleUtil;


@Controller
@LoginFilter
@RequestMapping("role")
public class RoleController extends CoreController{
	@Autowired
	private RoleService roleService;
	@Autowired
	private AdminService userService;
	@Autowired
	private UserGroupService groupService;
	@Autowired
	private RoleUtil roleUtil;
	@Autowired
	private RightService rightService;

	@RequestMapping("/list")
	@ResponseBody
	public String roleList(Integer id) throws Exception {
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(1);
		if (id != null){
			criteria.andParentIdEqualTo(id);
		}else {
			criteria.andParentIdEqualTo(0);
		}
		List<Role> list = roleService.selectByExample(example);
		JsonArray tree = new JsonArray();
		JsonArray childs = new JsonArray();
		
		for (Role role : list){
			JsonObject node = new JsonObject();
			node.addProperty("id", role.getId());  
		    node.addProperty("text", role.getName());  
		    node.addProperty("state", hasChild(role.getId()) ? "closed" : "open"); 
		    childs.add(node);
		}
		
		if (id == null){
			JsonObject root = new JsonObject();
			root.addProperty("id", "role");  
			root.addProperty("text", "角色");  
			root.addProperty("icon", "icon-ok");  
			root.add("children", childs); 
			tree.add(root);	
		}
		return tree.size() > 0 ? tree.toString() : childs.toString();
	}
	@RequestMapping("/lists")
	@ResponseBody
	public String roleList2(String id) throws Exception {
		RightExample rightExample = new RightExample();
		rightExample.setOrderByClause("level,sort_order desc");
		List<Right> list = rightService.selectByExample(rightExample);
		return ok(list);
	}
	
	@RequestMapping("/listsByParent")
	@ResponseBody
	public String listsByParent(Integer parentId) throws Exception {
		List<Right> list = null;
		if(parentId == 0){
			RightExample rightExample = new RightExample();
			rightExample.setOrderByClause("level,sort_order desc");
			list = rightService.selectByExample(rightExample);
		}else{
			list = rightService.selectByRole(parentId);
		}
		return ok(list);
	}
	
	@RequestMapping("/grouplist")
	@ResponseBody
	public String groupList() throws Exception {
		UserGroupExample example = new UserGroupExample();
		List<UserGroup> list = groupService.selectByExample(example);
		List<UserGroup> all = new ArrayList<UserGroup>(list.size()+1);
		UserGroup group = new UserGroup();
		group.setId(0);
		group.setName("根节点");
		group.setParentId(-1);
		group.setLevel(0);
		all.add(group);
		all.addAll(list);
		return ok(all);
	}
	
	@RequestMapping("/rolelist")
	@ResponseBody
	public String roleListByGroup(Integer id) throws Exception{
		RoleExample example = new RoleExample();
		example.createCriteria().andGroupIdEqualTo(id);
		List<Role> list = roleService.selectByExample(example);
		List<Role> all = new ArrayList<Role>(list.size()+1);
		Role role = new Role();
		role.setId(0);
		role.setName("根节点");
		role.setParentId(-1);
		role.setLevel(0);
		all.add(role);
		all.addAll(list);
		return ok(all);
	}
	
	@RequestMapping("/rightlist")
	@ResponseBody
	public String rightList(Integer id) throws Exception {
		RightExample example = new RightExample();
		example.setOrderByClause("sort_order desc");
		if(id != null)
			example.createCriteria().andParentIdEqualTo(id);
		else
			example.createCriteria().andParentIdEqualTo(0);
		List<Right> list = rightService.selectByExample(example);
		List<RightEx> listEx = new ArrayList<RightEx>();
		for (Right right : list) {
			RightEx rightEx = new RightEx();
			BeanUtils.copyProperties(rightEx, right);
			if(id == null || id == 0)rightEx.setState("closed");
			listEx.add(rightEx);
		}
		if(id == null){
			RightEx right = new RightEx();
			right.setParentId(-1);
			right.setId(0);
			right.setLevel(0);
			right.setName("根目录");
			listEx.add(0, right);
		}
		return ok(listEx);
	}
	
	@RequestMapping("/userlist")
	@ResponseBody
	public String userList(String id, Integer page, Integer rows) throws Exception {
		String groupId = getSessionParameter("groupId");
		String roleId = UserUtils.getPrincipal().getRoles().get(0).getId().toString();
		PaginationSupport.byPage(page, rows);
		List<AdminEx> list = userService.selectAdmins(groupId, roleId);
		return page(list);
	}
	
	@RequestMapping("/grouprolelist")
	@ResponseBody
	public String groupRoles(Integer id) throws Exception {
		String groupId = getSessionParameter("groupId");
		String roleId = UserUtils.getPrincipal().getRoles().get(0).getId().toString();
		
		if (id == null){
			return ok(RoleUtil.getGroups(Integer.parseInt(groupId),roleId));
		}else {
			if (!id.equals(groupId)) roleId = "0";
			return ok(RoleUtil.getRoles(id, roleId));
		}
	}
	@RequestMapping("/checkAccount")
	@ResponseBody
	public String checkAccount(String value) throws Exception {
		AdminExample example = new AdminExample();
		example.createCriteria().andAccountEqualTo(value);
		int cnt = userService.countByExample(example);
		if (cnt > 0) return msg(1,"");
		return ok();
	}
	
	@RequestMapping("/adduser")
	@ResponseBody
	public String addUser(Admin user) throws Exception {
		if (user.getId() == null){
			user.setPassword(Md5.md5(user.getPassword()));
			user.setCreateTime(new Date());
			user.setState(1);
			userService.insert(user);
		}else {
			if (!StringUtils.isBlank(user.getPassword()))
				user.setPassword(Md5.md5(user.getPassword()));
			user.setModifyTime(new Date());
			userService.updateByPrimaryKeySelective(user);
		}
		roleUtil.loadData();
		return JSONUtils.serialize(new Ret(0));
	}
	
	@RequestMapping("/finduser")
	@ResponseBody
	public String findUser(Integer id) throws Exception {
		Admin user = userService.selectByPrimaryKey(id);
		Role role = RoleUtil.getRoleByCode(user.getRoleCode());
		AdminEx ex = new AdminEx();
		ex.setGroupId(role.getGroupId());
		ex.setId(user.getId());
		ex.setAccount(user.getAccount());
		ex.setRoleCode(user.getRoleCode());
		return JSONUtils.serialize(ex);
	}
	
	@RequestMapping("/deluser")
	@ResponseBody
	public String delUser(String id) throws Exception {
		if (StringUtils.isBlank(id)) return null;
		String[] ids = id.split(",");
		for (String str : ids){
			userService.deleteByPrimaryKey(Integer.parseInt(str));
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/addright")
	@ResponseBody
	public String addRight(Right right) throws Exception {
		if (right.getId() == null){
			right.setCreateTime(new Date());
			rightService.insert(right);
		}else {
			rightService.updateByPrimaryKeySelective(right);
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/delright")
	@ResponseBody
	public String delRight(String id) throws Exception {
		if (StringUtils.isBlank(id)) return null;
		String[] ids = id.split(",");
		for (String str : ids){
			rightService.deleteByPrimaryKey(Integer.parseInt(str));
			RightExample example = new RightExample();
			example.createCriteria().andParentIdEqualTo(Integer.parseInt(str));
			rightService.deleteByExample(example);
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/findright")
	@ResponseBody
	public String findRight(Integer id) throws Exception {
		Right right = rightService.selectByPrimaryKey(id);
		return JSONUtils.serialize(right);
	}
	
	@RequestMapping("/addrole")
	@ResponseBody
	public String addRole(Role role, String rid) throws Exception {
		if (!StringUtils.isBlank(rid)){
			String[] temp = rid.split(",");
			for (int i=0;i<temp.length;i++){
				temp[i] = "["+temp[i]+"]";
			}
			rid = StringUtils.join(temp, ",");
		}
		if (role.getId() == null){
			role.setCreateTime(new Date());
			role.setModifyTime(new Date());
			role.setState(1);
			role.setRights(rid);
			roleService.insert(role);
		}else {
			role.setModifyTime(new Date());
			role.setRights(rid);
			roleService.updateByPrimaryKeySelective(role);
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/delrole")
	@ResponseBody
	public String delRole(String id) throws Exception {
		if (StringUtils.isBlank(id)) return null;
		String[] ids = id.split(",");
		for (String str : ids){
			roleService.deleteByPrimaryKey(Integer.parseInt(str));
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/findrole")
	@ResponseBody
	public String findRole(Integer id) throws Exception {
		Role role = roleService.selectByPrimaryKey(id);
		String rid = "";
		List<Right> list = RoleUtil.getRights(id);
		for (Right right : list){
			if (right.getParentId() != 0) rid += right.getId()+",";
		}
		if (rid.indexOf(",") != -1){
			rid = rid.substring(0, rid.lastIndexOf(","));
		}
		RoleEx ex = new RoleEx();
		BeanUtils.copyProperties(ex, role);
		ex.setRid(rid);
		return JSONUtils.serialize(ex);
	}
	
	@RequestMapping("/addgroup")
	@ResponseBody
	public String addGroup(UserGroup group) throws Exception{
		if (group.getId() == null){
			group.setCreateTime(new Date());
			group.setModifyTime(new Date());
			groupService.insert(group);
		}else {
			group.setModifyTime(new Date());
			groupService.updateByPrimaryKeySelective(group);
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/delgroup")
	@ResponseBody
	public String delGroup(String id) throws Exception {
		if (StringUtils.isBlank(id)) return null;
		String[] ids = id.split(",");
		for (String str : ids){
			groupService.deleteByPrimaryKey(Integer.parseInt(str));
		}
		roleUtil.loadData();
		return "{\"success\":true}";
	}
	
	@RequestMapping("/findgroup")
	@ResponseBody
	public String findGroup(Integer id) throws Exception {
		UserGroup group = groupService.selectByPrimaryKey(id);
		return JSONUtils.serialize(group);
	}
	
	private boolean hasChild(Integer id) throws Exception {
		RoleExample example = new RoleExample();
		example.createCriteria().andParentIdEqualTo(id);
		int i = roleService.countByExample(example);
		return i != 0;
	}
	
	@RequestMapping("findmenu")
	@ResponseBody
	public String findMenu(Integer id) throws Exception {
		Right right = rightService.selectByPrimaryKey(id);
		return JSONUtils.serialize(right);
	}
}
