package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.base.util.DateUtil;
import com.base.util.JSONUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.CustMsg;
import com.taobao.api.domain.ImMsg;
import com.taobao.api.domain.OpenImUser;
import com.taobao.api.domain.RoamingMessageResult;
import com.taobao.api.domain.TribeInfo;
import com.taobao.api.domain.Userinfos;
import com.taobao.api.internal.util.json.JSONWriter;
import com.taobao.api.request.OpenimChatlogsGetRequest;
import com.taobao.api.request.OpenimCustmsgPushRequest;
import com.taobao.api.request.OpenimImmsgPushRequest;
import com.taobao.api.request.OpenimRelationsGetRequest;
import com.taobao.api.request.OpenimTribeCreateRequest;
import com.taobao.api.request.OpenimTribeDismissRequest;
import com.taobao.api.request.OpenimTribeExpelRequest;
import com.taobao.api.request.OpenimTribeInviteRequest;
import com.taobao.api.request.OpenimTribeJoinRequest;
import com.taobao.api.request.OpenimTribeModifytribeinfoRequest;
import com.taobao.api.request.OpenimTribeQuitRequest;
import com.taobao.api.request.OpenimTribeSetmanagerRequest;
import com.taobao.api.request.OpenimTribeUnsetmanagerRequest;
import com.taobao.api.request.OpenimUsersAddRequest;
import com.taobao.api.request.OpenimUsersDeleteRequest;
import com.taobao.api.request.OpenimUsersGetRequest;
import com.taobao.api.request.OpenimUsersUpdateRequest;
import com.taobao.api.response.OpenimChatlogsGetResponse;
import com.taobao.api.response.OpenimCustmsgPushResponse;
import com.taobao.api.response.OpenimImmsgPushResponse;
import com.taobao.api.response.OpenimRelationsGetResponse;
import com.taobao.api.response.OpenimTribeCreateResponse;
import com.taobao.api.response.OpenimTribeDismissResponse;
import com.taobao.api.response.OpenimTribeExpelResponse;
import com.taobao.api.response.OpenimTribeInviteResponse;
import com.taobao.api.response.OpenimTribeJoinResponse;
import com.taobao.api.response.OpenimTribeModifytribeinfoResponse;
import com.taobao.api.response.OpenimTribeQuitResponse;
import com.taobao.api.response.OpenimTribeSetmanagerResponse;
import com.taobao.api.response.OpenimTribeUnsetmanagerResponse;
import com.taobao.api.response.OpenimUsersAddResponse;
import com.taobao.api.response.OpenimUsersDeleteResponse;
import com.taobao.api.response.OpenimUsersGetResponse;
import com.taobao.api.response.OpenimUsersUpdateResponse;

public class OpenImUtil {

	//http://gw.api.taobao.com/router/rest
	private static final String URL = "http://gw.api.taobao.com/router/rest";
	
	private static final String LOGIN = "https://chat.im.taobao.com/login/oauth?";

	private static final String APPKEY = "";

	private static final String APPSECRET = "";

//	private static TaobaoClient client = null;

	static {
//		client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json",30000,30000);
	}
	
	public static String login(String account, String password, String target){
		StringBuffer login = new StringBuffer(LOGIN);
		login.append("appkey=").append(APPKEY).append("&uid=").append(account);
		login.append("&credential=").append(password).append("&touid=").append(target);
		login.append("&tonick=").append(target).append("&tokenFlag=64&csspath=").append("http%3A%2F%2Fg.alicdn.com%2Faliww%2Fh5-openim%2F0.0.1%2Fstyles%2Ftheme.debug.css");
		return login.toString();
	}
	
	public static void add(String account, String password){
		Userinfos userinfos = new Userinfos();
		userinfos.setUserid(account);
		userinfos.setPassword(password);
		add(userinfos);
	}
	
	public static void update(String id, String nickName, String headImg){
		Userinfos userinfos = new Userinfos();
		userinfos.setUserid(id);
		if (nickName != null){
			userinfos.setNick(nickName);
		}
		if (headImg != null){
			userinfos.setIconUrl(headImg);
		}
		update(userinfos);
	}

	public static String add(Userinfos userinfos){
		TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
		String info = new JSONWriter(false,true).write(userinfos);
		OpenimUsersAddRequest req = new OpenimUsersAddRequest();
		try {
			req.setUserinfos(info);
			OpenimUsersAddResponse response = client.execute(req);
			return response.getUidSucc().get(0);
		} catch (Exception e) {
			
		}
		return null;
	}

	public static List<String> add(List<Userinfos> list) {
		OpenimUsersAddRequest req = new OpenimUsersAddRequest();
		req.setUserinfos(list);
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimUsersAddResponse response = client.execute(req);
			return response.getUidSucc();
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 发送普通消息
	 * @param from
	 * @param target
	 * @param msgType 消息类型。0:文本消息。1:图片消息，只支持jpg、gif。2:语音消息，只支持amr。8:地理位置信息。
	 * @param content 发送的消息内容。根据不同消息类型，传不同的值。0(文本消息):填消息内容字符串。1(图片):base64编码的jpg或gif文件。2(语音):base64编码的amr文件。8(地理位置):经纬度，格式如 111,222
	 * @param mediaAttr 根据msgtype变化。0(文本):填空即可。 1(图片):需要图片格式，{"type":"jpg"}或{"type":"gif"}。 2(语音): 需要文件格式和语音长度信息{"type":"amr","playtime":5}
	 */
	public static Long pushCommMsg(String from, String[] target, Long msgType,String content,String mediaAttr){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimImmsgPushRequest req = new OpenimImmsgPushRequest();
			ImMsg msg = new ImMsg();
			if (from != null){
				msg.setFromUser(from);
			}
			if (target != null){
				msg.setToUsers(Arrays.asList(target));
			}
			msg.setMsgType(msgType);
			if (mediaAttr != null){
				msg.setMediaAttr(mediaAttr);
			}
			if (content != null)
				msg.setContext(content);
			req.setImmsg(msg);
			OpenimImmsgPushResponse rsp = client.execute(req);
			return rsp.getMsgid();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 建讨论组
	 */
	public static Long addDiscussGroup(String userId, String groupName, String notice, String groupImg, String[] users){
		return addGroup(userId, groupName, notice, groupImg, 1L,users);
	}
	
	/**
	 * 建普通群
	 */
	public static Long addCommGroup(String userId, String groupName, String notice, String groupImg, String[] users){
		return addGroup(userId, groupName, notice, groupImg, 0L, users);
	}
	
	/**
	 * 群消息修改
	 */
	public static Long editGroup(Long groupId, String userId,String groupName, String notice, String groupImg){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeModifytribeinfoRequest req = new OpenimTribeModifytribeinfoRequest();
			req.setTribeId(groupId);
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setTaobaoAccount(false);
			user.setAppKey(APPKEY);
			if (groupName != null){
				req.setTribeName(groupName);
			}
			if (notice != null){
				req.setNotice(notice);
			}
			OpenimTribeModifytribeinfoResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 加入群
	 */
	public static Long joinGroup(Long groupId, String userId){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeJoinRequest req = new OpenimTribeJoinRequest();
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setAppKey(APPKEY);
			user.setTaobaoAccount(false);
			req.setUser(user);
			req.setTribeId(groupId);
			OpenimTribeJoinResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 踢群成员
	 * @param groupId
	 * @param userId
	 * @param targetId
	 * @return
	 */
	public static Long delGroupUser(Long groupId, String userId, String targetId){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeExpelRequest req = new OpenimTribeExpelRequest();
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setTaobaoAccount(false);
			user.setAppKey(APPKEY);
			OpenImUser target = new OpenImUser();
			target.setUid(targetId);
			target.setAppKey(APPKEY);
			target.setTaobaoAccount(false);
			req.setTribeId(groupId);
			req.setMember(target);
			req.setUser(user);
			OpenimTribeExpelResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 设置群管理员
	 */
	public static Long setGroupManager(Long groupId, String userId, String targetId){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeSetmanagerRequest req = new OpenimTribeSetmanagerRequest();
			req.setTid(groupId);
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setTaobaoAccount(false);
			user.setAppKey(APPKEY);
			OpenImUser target = new OpenImUser();
			target.setUid(targetId);
			target.setAppKey(APPKEY);
			target.setTaobaoAccount(false);
			req.setMember(target);
			req.setUser(user);
			OpenimTribeSetmanagerResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 取消群管理员
	 */
	public static Long delGroupManager(Long groupId, String userId, String targetId){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeUnsetmanagerRequest req = new OpenimTribeUnsetmanagerRequest();
			req.setTid(groupId);
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setTaobaoAccount(false);
			user.setAppKey(APPKEY);
			OpenImUser target = new OpenImUser();
			target.setUid(targetId);
			req.setMember(target);
			req.setUser(user);
			OpenimTribeUnsetmanagerResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/***
	 * 添加群成员
	 */
	public static Long addGroupUser(Long groupId,String userId, String[] ids){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeInviteRequest req = new OpenimTribeInviteRequest();
			req.setTribeId(groupId);
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setAppKey(APPKEY);
			user.setTaobaoAccount(false);
			List<OpenImUser> list = new ArrayList<OpenImUser>();
			for (String id : ids){
				OpenImUser u = new OpenImUser();
				u.setUid(id);
				u.setAppKey(APPKEY);
				u.setTaobaoAccount(false);
				list.add(user);
			}
			req.setMembers(list);
			OpenimTribeInviteResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 解散群
	 * */
	public static Long delGroup(Long groupId, String userId){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeDismissRequest req = new OpenimTribeDismissRequest();
			req.setTribeId(groupId);
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setAppKey(APPKEY);
			user.setTaobaoAccount(false);
			req.setUser(user);
			OpenimTribeDismissResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**退出群
	 * */
	public static Long quitGroup(Long groupId, String userId){
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimTribeQuitRequest req = new OpenimTribeQuitRequest();
			OpenImUser user = new OpenImUser();
			user.setUid(userId);
			user.setAppKey(APPKEY);
			user.setTaobaoAccount(false);
			req.setUser(user);
			req.setTribeId(groupId);
			OpenimTribeQuitResponse rsp = client.execute(req);
			return rsp.getTribeCode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 建群
	 */
	private static Long addGroup(String userId, String groupName, String notice, String groupImg, Long type,String[] users){
		OpenimTribeCreateRequest req = new OpenimTribeCreateRequest();
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenImUser own = new OpenImUser();
			own.setUid(userId);
			own.setAppKey(APPKEY);
			own.setTaobaoAccount(false);
			req.setUser(own);
			req.setNotice(notice);
			req.setTribeName(groupName);
			req.setTribeType(type);
			if (users != null && users.length > 0){
				List<OpenImUser> list = new ArrayList<OpenImUser>();
				for (String u : users){
					OpenImUser t = new OpenImUser();
					t.setUid(u);
					t.setAppKey(APPKEY);
					list.add(t);
				}
				req.setMembers(list);
			}
			OpenimTribeCreateResponse response = client.execute(req);
			TribeInfo tribeInfo = response.getTribeInfo();
			return tribeInfo.getTribeId();
		} catch (Exception e) {
		}
		return null;
	}

	public static void del(String ids){
		OpenimUsersDeleteRequest req = new OpenimUsersDeleteRequest();
		req.setUserids(ids);
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimUsersDeleteResponse response = client.execute(req);
			System.out.println(response.getBody());
		} catch (Exception e) {
		}
	}
	
	public static void update(Userinfos userinfos){
		OpenimUsersUpdateRequest req = new OpenimUsersUpdateRequest();
		String info = new JSONWriter(false,true).write(userinfos);
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			req.setUserinfos(info);
			OpenimUsersUpdateResponse response = client.execute(req);
		    System.out.println(response.getBody());
		} catch (Exception e) {
		}
	}
	
	public static void update(List<Userinfos> list){
		OpenimUsersUpdateRequest req = new OpenimUsersUpdateRequest();
		req.setUserinfos(list);
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimUsersUpdateResponse response = client.execute(req);
		    System.out.println(response.getBody());
		} catch (Exception e) {
		}
	}
	
	public static void get(String ids){
		OpenimUsersGetRequest req=new OpenimUsersGetRequest(); 
	    req.setUserids(ids); 
	    try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimUsersGetResponse response = client.execute(req);
			System.out.println(response.getBody());
		} catch (ApiException e) {
		} 
	}
	
	public static boolean push(String id, String msg, Map<String, Object> params, List<String> ids){
		OpenimCustmsgPushRequest req = new OpenimCustmsgPushRequest();
		CustMsg custMsg = new CustMsg();
		custMsg.setFromAppkey(APPKEY);
		custMsg.setToAppkey(APPKEY);
		custMsg.setFromUser(id);
		custMsg.setToUsers(ids);
		custMsg.setData(JSONUtils.serialize(params));
		Map<String, Object> aps = new HashMap<String, Object>();
		aps.put("alert", msg);
		custMsg.setAps(JSONUtils.serialize(aps));
		custMsg.setSummary(msg);
		req.setCustmsg(custMsg);
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimCustmsgPushResponse response = client.execute(req);
			System.out.println(response.getBody());
			return response.isSuccess();
		} catch (Exception e) {
		}
		return false;
	}
	
	public static List<OpenImUser> chatRelation(Date begin, Date end, String uid){
		OpenimRelationsGetRequest req = new OpenimRelationsGetRequest();
		req.setBegDate(DateUtil.dateToStr(begin, "yyyyMMdd"));
		req.setEndDate(DateUtil.dateToStr(end, "yyyyMMdd"));
		     
		OpenImUser user = new OpenImUser();
		user.setAppKey(APPKEY);
		user.setTaobaoAccount(false);
		user.setUid(uid);
		 
		req.setUser(user);
		 
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimRelationsGetResponse response = client.execute(req);
			System.out.println(response.getBody());
			return response.getUsers();
		} catch (Exception e) {
		}
		return null;
	}
	
	public static RoamingMessageResult chatLog(String u1,String u2,Long count,Date begin, Date end, String nextKey){
		OpenimChatlogsGetRequest req = new OpenimChatlogsGetRequest();
		OpenImUser from = new OpenImUser();
		OpenImUser to = new OpenImUser();
		from.setAppKey(APPKEY);
		from.setUid(u1);
		from.setTaobaoAccount(false);
		 
		to.setAppKey(APPKEY);
		to.setUid(u2);
		to.setTaobaoAccount(false);
		 
		req.setUser1(from);
		req.setUser2(to);
		req.setCount(count);
		req.setBegin(getUtcTime(begin));
		req.setEnd(getUtcTime(end));
		try {
			TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, APPSECRET,"json");
			OpenimChatlogsGetResponse response = client.execute(req);
			System.out.println(response.getBody());
			return response.getResult();
		} catch (Exception e) {
		}
		return null;
	}
	
	public static void push(String id, String msg, Map<String, Object> params, String... uid){
		List<String> ids = Arrays.asList(uid);
		push(id, msg, params, ids);
	}
	
	/**
	 * 推送系统消息
	 * @param args
	 */
	public static void pushSys(String msg, Map<String, Object> params, List<String> ids){
		push("sys@0", msg, params, ids);
	}
	
	public static void pushSys(String msg, Map<String, Object> params, String...id){
		push("sys@0", msg, params, Arrays.asList(id));
	}
	
	/**
	 * 发送到会话列表
	 * @param args
	 */
	public static void pushToView(String msg,Map<String, Object> params,String from,String target){
		push(from, msg, params, target);
	}
	
	public static long getUtcTime(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return cal.getTimeInMillis()/1000;
	}
	
	public static void main(String[] args) throws Exception {
		/*BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\dingxin\\Desktop\\f_user.txt")));
		String line = null;
		while((line = reader.readLine()) != null){
			String str = line.trim();
			Userinfos userinfos = new Userinfos();
			userinfos.setUserid(str);
			userinfos.setPassword(str);
			OpenImUtil.add(userinfos);
		}
		reader.close();*/
		//pushCommMsg("222481259", new String[]{"222481259"}, 0L, "呵呵", null);
		//get("44645619");
		//add("S00000002", "S00000002");
//		String[] keys = key.split(",");
//		for (String str : keys){
//			add(str, str);
//		}
		
		get("S00000002");
	}
}
