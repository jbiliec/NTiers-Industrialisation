package org.imie.chat;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/server")
public class ChatEndPoint {

	@OnOpen
	public void open(Session session){
		System.out.println("CONNECTED");
	}
	
	@OnClose
	public void close(Session session){
		System.out.println("DISCONNECTED");
	}
	
	@OnMessage
	public void receiveMessage(String message, Session session){
		
		try {
			session.getBasicRemote().sendText(message);
			System.out.println("msg sent :" + message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	
}
