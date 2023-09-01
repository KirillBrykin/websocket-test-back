package ru.example.websockettestback.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ru.example.websockettestback.model.TestWSRequest;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebSocketServiceImpl implements WebSocketService {
    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void sendNotification(TestWSRequest testWSRequest) {
        System.out.println("WebSocketServiceImpl.sendNotification");
        if (Objects.isNull(testWSRequest)) {
            log.error("empty object");
        } else {
            System.out.println("sending a message");
            System.out.println("testWSRequest: " + testWSRequest);
            messagingTemplate.convertAndSend("/topic/events", testWSRequest);
        }
    }
}