package com.example.booksystem.controller;


import com.example.booksystem.entity.Administrator;
import com.example.booksystem.entity.User;
import com.example.booksystem.service.AdministratorService;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorService administratorService;

    @PostMapping
    public Map<String, Object> login(@RequestParam String email, @RequestParam String password){
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUserByEmailAndPassword(email, password);
        if (user != null){
            map.put("status", true);
            map.put("userId", userService.getUserByEmailAndPassword(email, password).getId());
            map.put("ifBanned", user.isIfBanned());
        }else {
            map.put("status", false);
        }
        return map;
    }

    @PostMapping(value = "/admin")
    public boolean AdminLogin(@RequestParam String name, @RequestParam String password){
        return (administratorService.getAdministrator(name, password) != null);
    }
}
