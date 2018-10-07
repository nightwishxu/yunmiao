package com.item.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TextMessageHandler extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(TextMessageHandler.class);
	private static final Map<String, WebSocketSession> users;

	static {
		users = new HashMap<String, WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.debug(session.getAttributes().get(WebSocketConfig.DEFAULT_WEBSOCKET_KEY)+"链接成功......");
		/*
		 * 链接成功后会触发此方法，可在此处对离线消息什么的进行处理
		 */
		users.put(session.getId(), session);
		session.sendMessage(new TextMessage("链接成功......"));
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		logger.debug("链接出错，关闭链接......");
		if (session.isOpen()) {
			session.close();
		}
		logger.debug(exception.getMessage());
		users.remove(session.getId());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.debug("链接关闭......" + status.toString());
		users.remove(session.getId());
	}

	public void sendMessageToUser(String sys,String account, String msg) {
		Iterator<Map.Entry<String, WebSocketSession>> it = userIterator();
		while (it.hasNext()) {
			WebSocketSession session = it.next().getValue();
			if ((sys+"_"+account).equals(session.getAttributes().get(WebSocketConfig.DEFAULT_WEBSOCKET_KEY))) {
				try {
					if (session.isOpen())
						session.sendMessage(new TextMessage(msg));
				} catch (IOException e) {
					logger.error("sendMessageToUser异常!", e);
				}
			}
		}
	}

	public void sendMessageToUsers(String msg) {
		TextMessage message = new TextMessage(msg);
		Iterator<Map.Entry<String, WebSocketSession>> it = userIterator();
		while (it.hasNext()) {
			WebSocketSession session = it.next().getValue();
			try {
				if (session.isOpen())
					session.sendMessage(message);
			} catch (IOException e) {
				logger.error("sendMessageToUsers异常!", e);
			}

		}
	}

	private static Iterator<Map.Entry<String, WebSocketSession>> userIterator() {
		Set<Map.Entry<String, WebSocketSession>> entrys = users.entrySet();
		return entrys.iterator();
	}
}
