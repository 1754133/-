package com.example.booksystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NotifyService {
    void addNotification(String content);

    List<Map<String, Object>> getNotification();
}
