package com.example.booksystem.controller;


import com.example.booksystem.entity.User;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/{email}/{password}")
    public User getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getUserByEmailAndPassword(email, password);
    }

    @PutMapping(value = "/information")
    public void modifyUserInformation(@RequestParam String id, @RequestParam String name, @RequestParam String sex, @RequestParam int age){
        userService.modifyUserInformation(id, name, sex, age);
    }
}
