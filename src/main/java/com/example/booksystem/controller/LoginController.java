package com.example.booksystem.controller;


import com.example.booksystem.entity.User;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User login(@RequestParam String email, @RequestParam String password){
        return userService.getUserByEmailAndPassword(email, password);
    }

}
