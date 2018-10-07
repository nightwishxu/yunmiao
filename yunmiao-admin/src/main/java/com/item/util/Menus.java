package com.item.util;

import java.util.List;

public class Menus {
	private String menuid;
	
	private String icon;
	
	private String menuname;
	
	private String url;
	
	private List<Menus> menus;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setMenus(List<Menus> menus) {
		this.menus = menus;
	}

	public List<Menus> getMenus() {
		return menus;
	}

	
	
	
}
