package com.example.booksystem.controller;

import com.example.booksystem.entity.Notification;
import com.example.booksystem.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotifyController {
    @Autowired
    private NotifyService notifyService;

    @PostMapping
    public boolean addNotification(@RequestParam String content){
        notifyService.addNotification(content);
        return true;
    }

    @GetMapping
    public List<Notification> getNotification(){
        return notifyService.getNotification();
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteNotification(@PathVariable("id") int id){
        notifyService.deleteNotification(id);
        return true;
    }
}
