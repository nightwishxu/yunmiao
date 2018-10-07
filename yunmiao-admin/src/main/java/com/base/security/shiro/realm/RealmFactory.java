package com.base.security.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Component;

@Component
public class RealmFactory {
	
	@Resource
	private AdminRealm adminRealm;

	private List<Realm> realms = new ArrayList<Realm>();
	
	public List<Realm> getRealms(){
		realms.add(adminRealm);
		return realms;
	}
	
}
