package ru.example.websockettestback.service;

import ru.example.websockettestback.model.TestWSRequest;

public interface WebSocketService {
    void sendNotification(TestWSRequest testWSRequest);
}