package com.example.booksystem.controller;


import com.example.booksystem.entity.User;
import com.example.booksystem.service.MailService;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
    public void modifyUserInformation(@PathVariable("id") int id, @RequestParam String name, @RequestParam String sex, @RequestParam int age, @RequestParam String telephone, @RequestParam String speciality){
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
            String checkCode = mailService.sendCheckCode(email);
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

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    public boolean banUser(@PathVariable("id") int id){
        userService.banUser(id);
        return true;
    }

    @PostMapping(value = "/email")
    public boolean sendOverDueMail(@RequestParam String email, @RequestParam String bookName){
        mailService.sendOverDueMail(email, bookName);
        return true;
    }
}
