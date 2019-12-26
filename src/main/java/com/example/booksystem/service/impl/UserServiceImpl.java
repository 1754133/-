package com.example.booksystem.service.impl;


import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.UserMapper;
import com.example.booksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public void addUser(String email, String password){
        userMapper.addUser(email, password);
    }

    public void modifyUserInformation(String id, String name, String sex, int age){
        userMapper.modifyUserInformation(id, name, sex, age);
    }
}
