package com.item.action;

import com.base.action.CoreController;
import com.base.dao.model.Ret;
import com.base.dialect.PaginationSupport;
import com.base.support.PropertySupport;
import com.base.util.JSONUtils;
import com.base.web.annotation.LoginFilter;
import com.item.dao.model.Message;
import com.item.dao.model.MessageExample;
import com.item.dao.model.User;
import com.item.dao.model.UserExample;
import com.item.service.MessageService;
import com.item.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("msg")
@Controller
@LoginFilter
public class MessageController extends CoreController{

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    
    @RequestMapping("/list")
	@ResponseBody 
    public String list(Integer page, Integer rows){
    	PaginationSupport.byPage(page, rows);
    	MessageExample example = new MessageExample();
    	example.setOrderByClause("create_time desc");
    	List<Message> list = messageService.selectByExample(example);
      	return page(list);
    }
    
    @RequestMapping("/save")
	@ResponseBody 
    public String save(Message message){
    	if (message.getId() == null){
    		message.setRedirectType(1);
    		message.setNum(0);
    		message.setCreateTime(new Date());
    		message.setState(1);
    		int userId = userService.selectIdByAccount(message.getTarget());   		
    		message.setTarget(userId+"");
    		messageService.insert(message);
    	}else{
    		Message temp = messageService.selectByPrimaryKey(message.getId());
			if(temp == null || temp.getState() == 2){
				return msg(1,"已推送的记录无法修改");
			}
			message.setState(1);
			message.setCreateTime(temp.getCreateTime());
			int userId = userService.selectIdByAccount(message.getTarget());   		
    		message.setTarget(userId+"");
    		messageService.updateByPrimaryKeySelective(message);
    	}
       	return ok();
    }
    
    @RequestMapping("/findById")
	@ResponseBody 
    public String find(Integer id){
    	Message message = messageService.selectByPrimaryKey(id);
    	String account = userService.selectAccountById(message.getTarget());
    	message.setTarget(account);
       	return ok(message);
    }
    
    @RequestMapping("/del")
	@ResponseBody 
    public String del(String id){
    	String[] ids = id.split(",");
    	for (String str : ids){
    		messageService.deleteByPrimaryKey(Integer.parseInt(str));
    	}
       	return ok();
    }

	
	@RequestMapping("/send")
	@ResponseBody
	public String send(Integer id){
		if(StringUtils.isBlank(PropertySupport.getProperty("jpush.appkey"))){
			return msg(1,"系统尚未开启推送服务！");
		}
		
		Message message = messageService.selectByPrimaryKey(id);
		
		if(message==null){
			return msg(1,"消息不存在");
		}
		
		if(message.getState() == 2){
			return msg(1,"消息已被推送过了~");
		}
		//如果是个推的情况下，判断这个用户是否存在
		if(message.getState() == 2){
			UserExample example = new UserExample();
			example.createCriteria().andAccountEqualTo(message.getTarget());
			List<User> list = userService.selectByExample(example);
			if(list.size() == 0){
				return msg(1,"该用户不存在");
			}
			if(list.size() > 1){
				return msg(1,"用户信息有误,请联系开发人员");
			}
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("redirectType", 1);
		params.put("msg", message.getContent());
		String ret = "";
		if(message.getType() == 1){
			ret = messageService.pushToApp(message.getContent(),1,"");
		}else if(message.getType() == 2){
			
			ret = messageService.pushToSingleUserSide(Integer.parseInt(message.getTarget()), message.getContent(), 1, "");
		}
		
		if(StringUtils.isBlank(ret)){
			return msg(1,"推送失败，请联系开发人员");
		}
		
		if(ret.contains("sendno")){
			message.setState(2);
			messageService.updateByPrimaryKey(message);
		}else{
			return msg(1,"推送失败,返回值："+ret);
		}
		
		return ok();
	}
	
	@RequestMapping("/userIsNoExist")
	@ResponseBody
	public String userIsNoExist(String value){
		UserExample example = new UserExample();
		example.createCriteria().andAccountEqualTo(value);
		int cnt = userService.countByExample(example);
		if(cnt>0){
	           return JSONUtils.serialize(new Ret(0)); 
	       }        
	       return JSONUtils.serialize(new Ret(1));
	}
}
