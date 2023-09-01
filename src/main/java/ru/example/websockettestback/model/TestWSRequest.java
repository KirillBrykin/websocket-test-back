package ru.example.websockettestback.model;

import lombok.Data;

@Data
public class TestWSRequest {
    private String projectId;
    private String userId;
}