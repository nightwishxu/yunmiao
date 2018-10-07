package com.item.util;

import java.util.List;

import io.rong.RongCloud;
import io.rong.models.ChatroomInfo;
import io.rong.models.GroupInfo;
import io.rong.models.Message;
import io.rong.result.BlackUserResult;
import io.rong.result.BlockUserResult;
import io.rong.result.ChatRoomResult;
import io.rong.result.CodeResult;
import io.rong.result.FilterWordResult;
import io.rong.result.GagUserResult;
import io.rong.result.GroupUserResult;
import io.rong.result.MessageHistoryResult;
import io.rong.result.StatusResult;
import io.rong.result.TokenResult;
import io.rong.util.GsonUtil;

public class RongCloudUtil {

	private static RongCloud cloud = null;
	
	static{
		cloud = new RongCloud("3argexb63mg7e", "Wi1zEAT0Jb");
	}
	
	 /**
	  * 获取token
	  * @param userId
	  * @param userName
	  * @param portraitUri
	  * @return
	  */
	public static TokenResult getToken(String userId, String userName,
			String portraitUri){
		try {
			return (TokenResult) GsonUtil.fromJson(cloud.getToken(userId, userName, portraitUri).getResult(), TokenResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 检查用户在线状态
	 * @param userId
	 * @return
	 */
	public static StatusResult checkOnline(String userId){
		try {
			return (StatusResult) GsonUtil.fromJson(cloud.checkOnline(userId).getResult(), StatusResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 刷新用户信息
	 * @param userId
	 * @param userName
	 * @param portraitUri
	 * @return
	 */
	public static CodeResult refreshUser(String userId, String userName,
			String portraitUri){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.getToken(userId, userName, portraitUri).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**封禁用户
	 * @param userId
	 * @param minute	<=43200
	 * @return
	 */
	public static CodeResult blockUser(String userId, int minute){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.blockUser(userId, minute).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**解禁用户
	 * @param userId
	 * @return
	 */
	public static CodeResult unblockUser(String userId){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.unblockUser(userId).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取被封禁用户
	 */
	public static BlockUserResult queryBlockUsers(){
		try {
			return (BlockUserResult) GsonUtil.fromJson(cloud.queryBlockUsers().getResult(), BlockUserResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加用户到黑名单
	 */
	public static CodeResult blackUser(String userId,
			List<String> blackUserIds) {
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.blackUser(userId,blackUserIds).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**从黑名单移除用户
	 * 
	 */
	public static CodeResult unblackUser(String userId,
			List<String> blackUserIds){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.unblackUser(userId,blackUserIds).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**获取黑名单用户
	 * 
	 */
	public static BlackUserResult QueryblackUser(String userId){
		try {
			return (BlackUserResult) GsonUtil.fromJson(cloud.QueryblackUser(userId).getResult(), BlackUserResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**创建群
	 * 
	 */
	public static CodeResult createGroup(List<String> userIds,
			String groupId, String groupName){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.createGroup(userIds,groupId,groupName).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**加入群
	 * 
	 */
	public static CodeResult joinGroup(String userId, String groupId,
			String groupName){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.joinGroup(userId,groupId,groupName).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**批量加入群
	 * 
	 */
	public static CodeResult joinGroupBatch(List<String> userIds,
			String groupId, String groupName){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.joinGroupBatch(userIds,groupId,groupName).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 退出群
	 */
	public static CodeResult quitGroup(String userId, String groupId){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.quitGroup(userId,groupId).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 批量退出群
	 */
	public static CodeResult quitGroupBatch(List<String> userIds,
			String groupId){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.quitGroupBatch(userIds,groupId).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解散群
	 */
	public static CodeResult dismissGroup(String userId, String groupId){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.dismissGroup(userId,groupId).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 同步用户群信息
	 */
	public static CodeResult syncGroup(String userId, List<GroupInfo> groups){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.syncGroup(userId,groups).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 刷新群信息
	 */
	public static CodeResult refreshGroupInfo(String groupId,
			String groupName){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.refreshGroupInfo(groupId,groupName).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送消息
	 */
	public static CodeResult publishMessage(String fromUserId,
			List<String> toUserIds, Message msg){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.publishMessage(fromUserId,toUserIds,msg).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送消息
	 */
	public static CodeResult publishMessage(String fromUserId,
			List<String> toUserIds, Message msg, String pushContent,
			String pushData){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.publishMessage(fromUserId,toUserIds,msg,pushContent,pushData).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送系统消息
	 */
	public static CodeResult publishSystemMessage(String fromUserId,
			List<String> toUserIds, Message msg, String pushContent,
			String pushData){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.publishSystemMessage(fromUserId,toUserIds,msg,pushContent,pushData).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送群消息
	 */
	public static CodeResult publishGroupMessage(String fromUserId,
			List<String> toGroupIds, Message msg, String pushContent,
			String pushData){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.publishGroupMessage(fromUserId,toGroupIds,msg,pushContent,pushData).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 发送聊天室消息
	 */
	public static CodeResult publishChatroomMessage(String fromUserId,
			List<String> toChatroomIds, Message msg) {
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.publishChatroomMessage(fromUserId,toChatroomIds,msg).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 广播
	 */
	public static CodeResult broadcastMessage(String fromUserId,
			Message msg, String pushContent, String pushData) {
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.broadcastMessage(fromUserId,msg,pushContent,pushData).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 创建聊天室
	 */
	public static CodeResult createChatroom(List<ChatroomInfo> chatrooms) {
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.createChatroom(chatrooms).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 销毁聊天室
	 */
	public static CodeResult destroyChatroom(List<String> chatroomIds) {
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.destroyChatroom(chatroomIds).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询聊天室信息
	 */
	public static ChatRoomResult queryChatroom(List<String> chatroomIds) {
		try {
			return (ChatRoomResult) GsonUtil.fromJson(cloud.queryChatroom(chatroomIds).getResult(), ChatRoomResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取消息历史记录下载地址
	 * @param date 格式为2014010101,表示：2014年1月1日凌晨1点
	 */
	public static MessageHistoryResult getMessageHistoryUrl(String date){
		try {
			return (MessageHistoryResult) GsonUtil.fromJson(cloud.getMessageHistoryUrl(date).getResult(), MessageHistoryResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除消息历史记录
	 */
	public static CodeResult deleteMessageHistory(String date){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.deleteMessageHistory(date).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取群内成员
	 */
	public static GroupUserResult queryGroupUserList(String groupId){
		try {
			return (GroupUserResult) GsonUtil.fromJson(cloud.queryGroupUserList(groupId).getResult(), GroupUserResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 群内禁言
	 * @param minute 单位(分钟)
	 */
	public static CodeResult groupUserGagAdd(String groupId, String userId,
			long minute){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.groupUserGagAdd(groupId, userId, minute).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解除群内禁言
	 * @param minute 单位(分钟)
	 */
	public static CodeResult groupUserGagRollback(String groupId,
			String userId){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.groupUserGagRollback(groupId, userId).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *查询被禁言群成员
	 */
	public static GagUserResult groupUserGagList(String groupId){
		try {
			return (GagUserResult) GsonUtil.fromJson(cloud.groupUserGagList(groupId).getResult(), GagUserResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加敏感词
	 */
	public static CodeResult wordFilterAdd(String word){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.wordFilterAdd(word).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 移除敏感词 
	 */
	public static CodeResult wordFilterDelete(String word){
		try {
			return (CodeResult) GsonUtil.fromJson(cloud.wordFilterDelete(word).getResult(), CodeResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询敏感词列表
	 */
	public static FilterWordResult wordFilterList(){
		try {
			return (FilterWordResult) GsonUtil.fromJson(cloud.wordFilterList().getResult(), FilterWordResult.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
