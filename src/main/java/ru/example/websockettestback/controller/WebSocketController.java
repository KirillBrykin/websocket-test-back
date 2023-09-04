package ru.example.websockettestback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.websockettestback.model.TestWSRequest;
import ru.example.websockettestback.service.WebSocketService;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/test/ws")
public class WebSocketController {
    private final WebSocketService webSocketService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/send")
    public void
    sendNotification() {
        String str = String.valueOf(new Date().getTime());
        String randomStr = str.substring(str.length() - 2);
        TestWSRequest testWSRequest = new TestWSRequest();
        testWSRequest.setProjectId("ProjectId" + randomStr);
        testWSRequest.setUserId("UserId" + randomStr);
        webSocketService.sendNotification(testWSRequest);
    }

    @MessageMapping("/messageFromFront")
    public void receiveMessage(@Payload String message) {
        System.out.println("receive message: " + message);
        simpMessagingTemplate.convertAndSend("/topic/messageFromFront", message);
    }
}