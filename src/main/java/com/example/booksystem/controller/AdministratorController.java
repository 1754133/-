package com.example.booksystem.controller;

import com.example.booksystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/administrators")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping(value = "/login")
    public boolean AdminLogin(@RequestParam String name, @RequestParam String password){
        return (administratorService.getAdministrator(name, password) != null);
    }
}
