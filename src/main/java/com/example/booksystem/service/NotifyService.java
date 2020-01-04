package com.example.booksystem.service;

import com.example.booksystem.entity.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotifyService {
    void addNotification(String content);

    List<Notification> getNotification();

    void deleteNotification(int id);
}
