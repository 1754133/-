package com.example.booksystem.controller;

import com.example.booksystem.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notification")
public class NotifyController {
    @Autowired
    private NotifyService notifyService;

    @PostMapping
    public void addNotification(@RequestParam String content){
        notifyService.addNotification(content);
    }

    @GetMapping
    public List<Map<String, Object>> getNotification(){
        return notifyService.getNotification();
    }
}
