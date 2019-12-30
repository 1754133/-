package com.example.booksystem.controller;


import com.example.booksystem.entity.User;
import com.example.booksystem.service.MailService;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/{email}/{password}")
    public User getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getUserByEmailAndPassword(email, password);
    }

    @GetMapping(value = "/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }

    @PutMapping(value = "/information/{id}")
    public void modifyUserInformation(@PathVariable("id") String id, @RequestParam String name, @RequestParam String sex, @RequestParam int age, @RequestParam String telephone, @RequestParam String speciality){
        userService.modifyUserInformation(id, name, sex, age, telephone, speciality);
    }

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestParam String email, @RequestParam String password){
        return userService.login(email, password);
    }

    @PostMapping(value = "/register")
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
        userService.addUser(email, password, false);
        return true;
    }
}
