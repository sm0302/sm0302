package com.jsp.chat;
import java.util.*;
import java.io.*;
import javax.websocket.*;
import javax.websocket.server.*;
@ServerEndpoint("/websocket")
public class Chatting {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void open(Session session){
		System.out.println("���� ���Դϴ�......");
		clients.add(session);
	}
	@OnMessage
	public void message(String message, Session session) throws IOException {
		synchronized (clients) {
			for(Session client : clients) {
				if(!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	@OnClose
	public void close(Session session) {
		System.out.println("������ �����մϴ�.");
		clients.remove(session);
	}
	@OnError
	public void error(Throwable t) {
		t.printStackTrace();
	}
}
