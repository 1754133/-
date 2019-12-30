package com.example.booksystem.service.impl;


import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.UserMapper;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    public User getUserById(int id) {
        return userMapper.getById(id);
    }


    public User getUserByEmail(String email){
        return userMapper.getByEmail(email);
    }


    public User getUserByEmailAndPassword(String email, String password){
        return userMapper.getByEmailAndPassword(email, password);
    }

    public Map<String, Object> login(String email, String password){
        Map<String, Object> map = new HashMap<>();
        User user = userMapper.getByEmailAndPassword(email, password);
        if (user != null){
            map.put("status", true);
            map.put("userId", userMapper.getByEmailAndPassword(email, password).getId());
            map.put("ifBanned", user.isIfBanned());
        }else {
            map.put("status", false);
        }
        return map;
    }


    public void addUser(String email, String password, boolean ifBanned){
        userMapper.addUser(email, password, ifBanned);
    }

    public void modifyUserInformation(String id, String name, String sex, int age, String telephone, String speciality){
        userMapper.modifyUserInformation(id, name, sex, age, telephone, speciality);
    }
}
