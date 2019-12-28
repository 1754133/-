package com.example.booksystem.controller;


import com.example.booksystem.entity.User;
import com.example.booksystem.service.MailService;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/checkcode")
    public Map<String, Object> checkEmail(@RequestParam String email){
        Map<String, Object> map = new HashMap<>(3);
        if (userService.getUserByEmail(email) != null){
            map.put("status", false);
            return map;
        }
        else{
            String checkCode = String.valueOf(new Random().nextInt(799999) + 100000);
            String message = "您的注册验证码为："+checkCode;
            mailService.sendSimpleMail(email, "注册验证码", message);
            map.put("status", true);
            map.put("checkcode", checkCode);
            return map;
        }
    }

    @PostMapping
    public boolean addUser(@RequestParam String email, @RequestParam String password){
        userService.addUser(email, password);
        return true;
    }


}
