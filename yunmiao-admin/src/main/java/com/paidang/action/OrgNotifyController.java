//package com.paidang.action;
//
//import java.util.List;
//import com.base.dialect.PaginationSupport;
//import com.base.dao.model.Ret;
//import com.base.dao.model.Grid;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.apache.commons.lang.StringUtils;
//import com.base.util.JSONUtils;
//import com.base.web.annotation.LoginFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.base.action.CoreController;
//import com.paidang.dao.model.OrgNotify;
//import com.paidang.dao.model.OrgNotifyExample;
//import com.paidang.service.OrgNotifyService;
//
///**
//@author sun
//*/
//@RequestMapping("orgNotify")
//@Controller
//@LoginFilter
//public class OrgNotifyController extends CoreController{
//
//    @Autowired
//    private OrgNotifyService orgNotifyService;
//
//    @RequestMapping("/list")
//	@ResponseBody
//    public String list(Integer page, Integer rows){
//    	PaginationSupport.byPage(page, rows);
//    	OrgNotifyExample example = new OrgNotifyExample();
//
//    	List<OrgNotify> list = orgNotifyService.selectByExample(example);
//      	return page(list);
//    }
//
//    @RequestMapping("/save")
//	@ResponseBody
//    public String save(OrgNotify orgNotify){
//    	if (orgNotify.getId() == null){
//    		orgNotifyService.insert(orgNotify);
//    	}else{
//    		orgNotifyService.updateByPrimaryKeySelective(orgNotify);
//    	}
//       	return ok();
//    }
//
//    @RequestMapping("/findById")
//	@ResponseBody
//    public String find(Integer id){
//    	OrgNotify orgNotify = orgNotifyService.selectByPrimaryKey(id);
//       	return ok(orgNotify);
//    }
//
//    @RequestMapping("/del")
//	@ResponseBody
//    public String del(String id){
//    	String[] ids = id.split(",");
//    	for (String str : ids){
//    		orgNotifyService.deleteByPrimaryKey(Integer.parseInt(str));
//    	}
//       	return ok();
//    }
//
//
//}