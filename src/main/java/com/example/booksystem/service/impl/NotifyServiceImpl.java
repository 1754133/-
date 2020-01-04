package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Notification;
import com.example.booksystem.mapper.NotificationMapper;
import com.example.booksystem.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private NotificationMapper notificationMapper;

    public void addNotification(String content){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = simpleDateFormat.format(new Date());
        notificationMapper.addNotification(content, date);
    }

    public List<Notification> getNotification(){
        return notificationMapper.getNotification();
    }

    public void deleteNotification(int id){
        notificationMapper.deleteNotification(id);
    }
}
