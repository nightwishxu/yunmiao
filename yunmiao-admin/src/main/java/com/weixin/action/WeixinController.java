package com.weixin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.CoreConstants;
import com.base.spring.SpringContextUtil;
import com.base.web.annotation.LoginMethod;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.NewsMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.MenuEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.weixin.EventHandle;
import com.weixin.MessageHandle;
import com.weixin.WeixinSupport;
import com.weixin.dao.model.Article;
import com.weixin.dao.model.ArticleExample;
import com.weixin.dao.model.FirstAttention;
import com.weixin.dao.model.Keyword;
import com.weixin.dao.model.KeywordExample;
import com.weixin.dao.model.Weixin;
import com.weixin.service.ArticleService;
import com.weixin.service.FirstAttentionService;
import com.weixin.service.KeywordService;
import com.weixin.service.WeixinService;

@Controller
@RequestMapping("weixin")
public class WeixinController extends WeixinSupport {
	private static final Logger log = LoggerFactory.getLogger(WeixinController.class);
	private static final String TOKEN = CoreConstants.getProperty("weixin.token");
	private static String baseUrl = CoreConstants.getProperty("weixin.baseUrl","");
	public static ApiConfig config = null;

	public static Map<String,ApiConfig> configMap = new HashMap<String,ApiConfig>();
	private static WeixinService wxService;
	@Autowired
	private WeixinService weixinService;
	@Autowired
	private FirstAttentionService attentionService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private KeywordService keywordService;
	
	
	
    /**
     * 绑定微信服务器
     */
	@RequestMapping(method = RequestMethod.GET)
	protected final void bindServer(HttpServletRequest request,HttpServletResponse response,String echostr) {
    	if (isLegal(request)) {
    		log.info("绑定微信服务器成功");
    		try {
                PrintWriter pw = response.getWriter();
                pw.write(echostr);
                pw.flush();
                pw.close();
            } catch (Exception e) {
            	log.error("绑定服务器异常", e);
            }
        } else {
        	log.error("绑定微信服务器失败");
        }
    }

    /**
     * 微信消息交互处理
     *
     * @param request http 请求对象
     * @return 响应给微信服务器的消息报文
     * @throws ServletException 异常
     * @throws IOException      IO异常
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    protected final String process(HttpServletRequest request) throws ServletException, IOException {
        if (!isLegal(request)) {
            return "";
        }
        return processRequest(request);
    }
    
	// 处理对应的微信文本消息
    @Override
	protected BaseMsg handleTextMsg(TextReqMsg msg,String fid) {
    	if(StringUtils.isBlank(fid))fid = "0";
		String content = msg.getContent();
		log.debug("用户发送到服务器的内容:" + content);
		
		KeywordExample example = new KeywordExample();
		example.createCriteria().andFidEqualTo(fid).andKeywordEqualTo(content);
		List<Keyword> list = keywordService.selectByExample(example);
		if(list.size() == 0)return new TextMsg("");
		Keyword kw = list.get(0);
		if(kw.getReplyType() == 1){
			return new TextMsg(kw.getReplyContent());
		}else if(kw.getReplyType() == 2 && StringUtils.isNotBlank(kw.getResId())){
			ArticleExample artexample = new ArticleExample();
			artexample.createCriteria().andResIdEqualTo(kw.getResId());
			artexample.setOrderByClause("sort_order,create_time");
	    	List<Article> artlist = articleService.selectByExample(artexample);
	    	if(artlist.size()>0){
	    		NewsMsg news = new NewsMsg(artlist.size());
	    		for (Article article : artlist) {
	    			com.github.sd4324530.fastweixin.message.Article art = new com.github.sd4324530.fastweixin.message.Article();
	    			art.setDescription(list.size()==1?article.getRemark():"");
	    			art.setTitle(article.getTitle());
	    			art.setPicUrl(baseUrl+"/download?id="+article.getImg());
	    			art.setUrl(StringUtils.isBlank(article.getUrl())?(baseUrl+"/detail?type=3&id="+article.getId()):article.getUrl());
	    			news.add(art);
				}
	    		return news;
	    	}
		}
		
		return null;
	}

	// 处理添加关注事件
    @Override
	protected BaseMsg handleSubscribe(BaseEvent event,String fid) {
    	if(StringUtils.isBlank(fid))fid = "0";
		FirstAttention attention = attentionService.selectByPrimaryKey(fid);
		if(attention == null){
			return null;
		}else{
			if(attention.getType() == 0){
				return new TextMsg(attention.getContent());
			}else if(StringUtils.isNotBlank(attention.getResId())){
				ArticleExample example = new ArticleExample();
		    	example.createCriteria().andResIdEqualTo(attention.getResId());
		    	example.setOrderByClause("sort_order,create_time");
		    	List<Article> list = articleService.selectByExample(example);
		    	if(list.size()>0){
		    		NewsMsg news = new NewsMsg(list.size());
		    		for (Article article : list) {
		    			com.github.sd4324530.fastweixin.message.Article art = new com.github.sd4324530.fastweixin.message.Article();
		    			art.setDescription(list.size()==1?article.getRemark():"");
		    			art.setTitle(article.getTitle());
		    			art.setPicUrl(baseUrl+"/download?id="+article.getImg());
		    			art.setUrl(StringUtils.isBlank(article.getUrl())?(baseUrl+"/detail?type=3&id="+article.getId()):article.getUrl());
		    			news.add(art);
					}
		    		return news;
		    	}
			}
		}
		return null;
	}
	
	public static ApiConfig getApiConfig(HttpSession session){
		if(wxService == null) wxService = SpringContextUtil.getBean(WeixinService.class);
		String sys = getSessionParameter("sys", session);
		String id = getSessionParameter("id", session);
		ApiConfig config = null;
		if(Boolean.valueOf("true".equals(CoreConstants.getProperty("weixin.singleMode", "true"))) || "admin".equals(sys) || "administrator".equals(sys)){//平台账号
			id = "0";
		}

		config = configMap.get(id);
		
		if(config == null){
			Weixin weixin = wxService.selectByPrimaryKey(id);
			if(weixin != null){
				config = new ApiConfig(weixin.getAppid(), weixin.getAppsecret());
				configMap.put(id, config);
			}
		}else if(StringUtils.isBlank(config.getAccessToken())){
			config = null;
		}
		return config;
	}
	
	public static String getFid(HttpSession session){
		String fid = "0";
		String sys = getSessionParameter("sys", session);
		String id = getSessionParameter("id", session);
		if(Boolean.valueOf("true".equals(CoreConstants.getProperty("weixin.singleMode", "true")))){//是否为单用户
			fid = "0";
		}else if(!"admin".equals(sys) && !"administrator".equals(sys)){//平台账号
			fid = id;
		}
		return fid;
	}
	
	public static String getSessionParameter(String name,HttpSession session) {
		Object obj = session.getAttribute(LoginMethod.ADMIN.getName());
		if (obj != null) {
			HashMap<String, String> map = (HashMap<String, String>) obj;
			return map.get(name);
		}
		return "";
	}
	
	protected String getToken(String fid) {
		if(StringUtils.isBlank(fid)){
			return TOKEN;
		}else{
			return fid;
		}
	}
	
	@Override
	protected String getAppId(String fid) {
		if(StringUtils.isBlank(fid))fid = "0";
		ApiConfig config = configMap.get(fid);
		if(config!= null)return config.getAppid();
		
		Weixin weixin = weixinService.selectByPrimaryKey(fid);
		return weixin.getAppid();
	}
	
	/*
	 * 1.1版本新增，重写父类方法，加入自定义微信消息处理器不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
	 * 这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
	 */
	@Override
	protected List<MessageHandle> initMessageHandles() {
		List<MessageHandle> handles = new ArrayList<MessageHandle>();
//		handles.add(new MessageHandle<BaseReqMsg>() {
//
//			@Override
//			public BaseMsg handle(BaseReqMsg message,String fid) {
//				return null;
//			}
//
//			@Override
//			public boolean beforeHandle(BaseReqMsg message) {
//				return false;
//			}
//		});
		return handles;
	}

	// 1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
	@Override
	protected List<EventHandle> initEventHandles() {
		List<EventHandle> handles = new ArrayList<EventHandle>();
		handles.add(new ClickKeyword());
		return handles;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//处理菜单类型为关键字
	class ClickKeyword implements EventHandle<BaseEvent> {
		public BaseMsg handle(BaseEvent event, String fid) {//处理具体业务
			MenuEvent me = (MenuEvent)event;
			TextReqMsg msg = new TextReqMsg(me.getEventKey().substring(8));
			return handleTextMsg(msg,fid);
		}
		public boolean beforeHandle(BaseEvent event) {//判断该事件是否可以被当前处理类处理
			if(event instanceof MenuEvent){
				MenuEvent me = (MenuEvent)event;
				if(me.getEventKey().startsWith("keyword_")){
					return true;
				}
			}
			return false;
		}
	}
	
	
	
	
}