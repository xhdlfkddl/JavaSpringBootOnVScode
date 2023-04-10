package com.taeyoung.board.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class SocketGroup {
    private String room;
    private WebSocketSession webSocketSession;     
}

@Component
public class SocketProvider extends TextWebSocketHandler {
    
    private List<SocketGroup> sessionList = new ArrayList<>();


    //? 소켓이 처음 연결 되었을 때
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) {
        System.out.println("Socket connected!!");
        // System.out.println(webSocketSession.getHandshakeHeaders().toString());
        System.out.println(webSocketSession.getHandshakeHeaders().getFirst("room"));
        // System.out.println(webSocketSession.toString());
        // sessionList.add(webSocketSession);
        String room = webSocketSession.getHandshakeHeaders().getFirst("room");
        sessionList.add(new SocketGroup(room, webSocketSession));
    }


    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) throws Exception {
        // 몸체를 가져온 것
        String messagePayload = textMessage.getPayload();
        System.out.println(messagePayload);

        String room = webSocketSession.getHandshakeHeaders().getFirst("room");

        // for (WebSocketSession session : sessionList) {
        for (SocketGroup socketGroup : sessionList) {
            if (socketGroup.getRoom().equals(room))
            socketGroup.getWebSocketSession().sendMessage(textMessage);
        }
    }

    //? 소켓이 연결이 끊어졌을 때
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) {
        System.out.println("Socket closed");
        System.out.println(webSocketSession.toString());
        System.out.println(closeStatus.toString());

        for (SocketGroup socketGroup : sessionList) {
            if (socketGroup.getWebSocketSession().equals(webSocketSession)) {
                sessionList.remove(socketGroup);
            } 
        }
    }

}
