package com.kakadurf.cv4.framework.web_socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakadurf.cv4.domain.datasource.MessageSource;
import com.kakadurf.cv4.domain.entities.MessageEntity;
import com.kakadurf.cv4.domain.transport.dto.ParcelDto;
import com.kakadurf.cv4.framework.jwt.JwtAuth;
import com.kakadurf.cv4.framework.jwt.JwtProvider;
import com.kakadurf.cv4.framework.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    private MessageSource messageSource;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        ParcelDto parcel = objectMapper.readValue(message.getPayload(),ParcelDto.class);
        /*webSocketSessions.add(session);
        for(WebSocketSession aSession : webSocketSessions){
            aSession.sendMessage(message);
        }*/
        Authentication authentication = jwtProvider.authenticate(new JwtAuth(parcel.getToken()));
        session.sendMessage(message);
        messageSource.save(MessageEntity.builder()
                .userEntity(((UserDetailsImpl) authentication.getPrincipal()).user)
                .name(parcel.getUserName())
                .text(parcel.getText())
                .build());
    }
}
