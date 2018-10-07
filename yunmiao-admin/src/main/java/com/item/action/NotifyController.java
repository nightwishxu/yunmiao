package com.item.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.item.dao.model.*;
import com.item.service.UserNotifyService;
import com.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.action.CoreController;
import com.base.dialect.PaginationSupport;
import com.base.web.annotation.LoginFilter;
import com.item.daoEx.model.NotifyEx;
import com.item.service.NotifyService;

@RequestMapping("notify")
@Controller
@LoginFilter
public class NotifyController extends CoreController{
	@Autowired
	private NotifyService notifyService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserNotifyService userNotifyService;
	
	@RequestMapping("/list")
	@ResponseBody
	public String list(Integer page,Integer rows){
		PaginationSupport.byPage(page, rows);
		Map<String,Object> map = new HashMap<String,Object>();
		List<NotifyEx> list = notifyService.selectList(map);
		return page(list);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(Notify notify){
		if(notify.getId() == null){//添加
			notify.setState(1);
			notify.setNum(0);
			notify.setTitle("系统消息");
			notify.setRedirectType(0);
			notify.setRedirectContent("");
			notify.setCreateTime(new Date());
			notifyService.insert(notify);

		}else{//update
			Notify temp = notifyService.selectByPrimaryKey(notify.getId());
			if(temp == null || temp.getState() == 2){
				return msg(1,"已发送的记录无法修改");
			}
			notify.setState(1);
			notify.setCreateTime(temp.getCreateTime());
			notifyService.updateByPrimaryKey(notify);
		}
		return ok();
	}
	
	@RequestMapping("/send")
	@ResponseBody
	public String send(Integer id){
		notifyService.sendNotify(id);
		return ok();
	}

	@RequestMapping("del")
	@ResponseBody
	public String del(String id){
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			notifyService.deleteEx(Integer.parseInt(ids[i]));
		}
		return ok();
	}
	
	@RequestMapping("/findById")
	@ResponseBody
	public String findById(Integer id) throws Exception{
		Notify notify = notifyService.selectByPrimaryKey(id);
		return ok(notify);
	}
}
