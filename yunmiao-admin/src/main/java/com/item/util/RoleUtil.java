package com.item.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.dao.model.Right;
import com.item.dao.model.Role;
import com.item.dao.model.RoleExample;
import com.item.dao.model.UserGroup;
import com.item.dao.model.UserGroupExample;
import com.item.service.RightService;
import com.item.service.RoleService;
import com.item.service.UserGroupService;

@Component
public class RoleUtil {
	private static Map<Integer, List<Role>> roleMap = new HashMap<Integer, List<Role>>();
	
	private static Map<Integer, List<Right>> rightMap = new HashMap<Integer, List<Right>>();
	
	private static Map<Integer, UserGroup> groupMap = new HashMap<Integer, UserGroup>();
	
	private static List<UserGroup> groupList = new ArrayList<UserGroup>();
	
	private static List<Role> roleList = new ArrayList<Role>();
	
	private static Set<String> rightSet = new HashSet<String>();
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private RightService rightService;
	@Autowired
	private UserGroupService groupService;
	
	@PostConstruct
	public void loadData(){
		UserGroupExample groupExample = new UserGroupExample();
		groupList = groupService.selectByExample(groupExample);
		RoleExample example = new RoleExample();
		example.createCriteria().andStateEqualTo(1);
		roleList = roleService.selectByExample(example);
		for (int i = 0; i < groupList.size(); i++){
			Integer groupId = groupList.get(i).getId();
			List<Role> roles = new ArrayList<Role>();
			for (int j = 0; j < roleList.size(); j++){
				if (roleList.get(j).getGroupId().equals(groupId)){
					roles.add(roleList.get(j));
					List<Right> rights = rightService.selectByRole(roleList.get(j).getId());
					rightMap.put(roleList.get(j).getId(), rights);
					for (Right right : rights){
						if (right.getUrl() != null)
							rightSet.add(right.getUrl());
					}
				}
			}
			roleMap.put(groupId, roles);
			groupMap.put(groupId, groupList.get(i));
		}
	}
	
	public static boolean isMenu(Integer role, String menu) {
		List<Right> list = rightMap.get(role);
		if (list != null){
			for (Right right : list){
				if (menu.equals(right.getUrl()))
					return true;
			}
		}
		return false;
	}
	
	public static boolean isUrl(String url){
		for (String str : rightSet){
			if (str.equals(url))
				return true;
		}
		return false;
	}
	
	/**
	 * 是否是已存在的用户组
	 * @param code
	 * @return
	 */
	public static boolean isGroup(String code){
		for (UserGroup group : getGroups()){
			if (group.getCode().equals(code))
				return true;
		}
		return false;
	}
	
	/**
	 * 获取用户组名称
	 */
	public static String getGroupName(String code){
		for (UserGroup group : getGroups()){
			if (group.getCode().equals(code))
				return group.getName();
		}
		return "系统";
	}
	
	/**
	 * 获取用户组角色
	 * @param groupId
	 * @return
	 */
	public static List<Role> getRoles(Integer groupId){
		return roleMap.get(groupId);
	}
	
	/**
	 * 获取用户组角色
	 * @param groupCode
	 * @return
	 */
	public static List<Role> getRolesByCode(String groupCode){
		UserGroup group = getGroupByCode(groupCode);
		if (group != null){
			return getRoles(group.getId());
		}
		return null;
	}
	
	public static List<String> getRolesCode(String groupCode){
		List<String> code = new ArrayList<String>();
		for (Role role : getRolesByCode(groupCode)){
			code.add(role.getCode());
		}
		return code;
	}
	
	public static boolean isGroupRole(String roleCode, String groupCode){
		if (StringUtils.isBlank(roleCode)) return false;
		for(String str : getRolesCode(groupCode)){
			if (roleCode.equals(str)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 全部角色
	 * @return
	 */
	public static List<Role> getRoles(){
		return roleList;
	}
	
	/**
	 * @param str(角色id)(用户组id,角色id)
	 * @return
	 */
	public static Role getRole(Integer...str){
		List<Role> list = null;
		Integer roleId = null;
		if (str.length == 1){
			list = getRoles();
			roleId = str[0];
		}else {
			list = getRoles(str[0]);
			roleId = str[1];
		}
		for (Role role : list){
			if (role.getId().equals(roleId)){
				return role;
			}
		}
		return null;
	}
	
	/**
	 * @param str(角色code)(用户组code,角色code)
	 * @return
	 */
	public static Role getRoleByCode(String...str){
		List<Role> list = null;
		String code = "";
		if (str.length == 1){
			list = getRoles();
			code = str[0];
		}else {
			list = getRolesByCode(str[0]);
			code = str[1];
		}
		for (Role role : list){
			if (role.getCode().equals(code)){
				return role;
			}
		}
		return null;
	}
	
	/**
	 * 根据角色id获取角色权限
	 * @param roleId
	 * @return
	 */
	public static List<Right> getRights(Integer roleId){
		return rightMap.get(roleId);
	}
	
	/**
	 * 根据角色code获取角色权限
	 * @param roleCode
	 * @return
	 */
	public static List<Right> getRightsByCode(String groupCode,String roleCode){
		Role role = getRoleByCode(groupCode,roleCode);
		if (role != null)
			return getRights(role.getId());
		return null;
	}
	
	/**
	 * 全部用户组
	 * @return
	 */
	public static List<UserGroup> getGroups(){
		return groupList;
	}
	
	/**
	 * 获取自身的子用户组
	 * @param groupId
	 * @param roleId
	 * @return
	 */
	public static List<UserGroup> getGroups(Integer groupId, String roleId){
		List<UserGroup> list = getGroups();
		List<UserGroup> temp = new ArrayList<UserGroup>();
		for (UserGroup group : list){
			if (group.getParentId().equals(groupId) || (group.getId().equals(groupId) && hasChild(getRoles(groupId), roleId))){
				temp.add(group);
			}
		}
		return temp;
	}
	
	private static boolean hasChild(List<Role> list, String roleId){
		for (Role group : list){
			if (group.getParentId().equals(roleId))
				return true;
		}
		return false;
	}
	
	/**
	 * 获取自身的子角色
	 * @param groupId
	 * @param roleId
	 * @return
	 */
	public static List<Role> getRoles(Integer groupId, String roleId){
		List<Role> list = getRoles(groupId);
		List<Role> temp = new ArrayList<Role>();
		for (Role role : list){
			if (role.getParentId().toString().equals(roleId)){
				temp.add(role);
			}
		}
		return temp;
	}
	
	/**
	 * id获取用户组
	 * @param groupId
	 * @return
	 */
	public static UserGroup getGroup(String groupId){
		return groupMap.get(groupId);
	}
	
	/**
	 * code获取用户组
	 * @param groupCode
	 * @return
	 */
	public static UserGroup getGroupByCode(String groupCode){
		for (UserGroup group : getGroups()){
			if (group.getCode().equals(groupCode)){
				return group;
			}
		}
		return null;
	}
	
	private static String path  = "go?path=";
	
	/**
	 * 初始化角色菜单
	 * @param list
	 * @return
	 */
	public static Map<String, List<Menus>> initMenus(List<Right> list){
		if (list == null) return null;
		Map<String, List<Menus>> map = new HashMap<String, List<Menus>>();
		List<Menus> menuss = new ArrayList<Menus>();
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).getParentId() == 0){
				Menus menus = new Menus();
				menus.setIcon(list.get(i).getIcon());
				menus.setMenuid(list.get(i).getId()+"");
				menus.setMenuname(list.get(i).getName());
				List<Menus> child = new ArrayList<Menus>();
				for (int j = 0; j < list.size(); j++){
					if (list.get(j).getParentId().equals(list.get(i).getId())){
						Menus menusChild = new Menus();
						menusChild.setIcon(list.get(j).getIcon());
						menusChild.setMenuid(list.get(j).getId()+"");
						menusChild.setMenuname(list.get(j).getName());
						String url = list.get(j).getUrl();
						if (url != null)
							menusChild.setUrl(url.startsWith("http")?url:(path + url));
						child.add(menusChild);
					}
				}
				menus.setMenus(child);
				menuss.add(menus);
			}
		}
		map.put("_menus", menuss);
		return map;
	}
	
}
