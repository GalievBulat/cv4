package com.kakadurf.cv4.framework.web_socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakadurf.cv4.domain.datasource.MessagesSource;
import com.kakadurf.cv4.domain.entities.MessageEntity;
import com.kakadurf.cv4.framework.data.dto.ParcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MessageHandler extends TextWebSocketHandler {
    //private final Set<WebSocketSession> webSocketSessions = new HashSet<>();
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MessagesSource messagesSource;
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ParcelDto parcel = objectMapper.readValue(message.getPayload(),ParcelDto.class);
        /*webSocketSessions.add(session);
        for(WebSocketSession aSession : webSocketSessions){
            aSession.sendMessage(message);
        }*/
        session.sendMessage(message);
        messagesSource.save(MessageEntity.builder()
                .name(parcel.getUserName())
                .text(parcel.getText())
                .build());
    }
}
