package ru.example.websockettestback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.websockettestback.model.TestWSRequest;
import ru.example.websockettestback.service.WebSocketService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/test/ws")
public class PirateCrewController {
    private final WebSocketService webSocketService;

    @GetMapping
    public void
    getDictionary() {
        TestWSRequest testWSRequest = new TestWSRequest();
        testWSRequest.setProjectId("ProjectId1");
        testWSRequest.setUserId("UserId1");
        webSocketService.sendNotification(testWSRequest);
    }
}