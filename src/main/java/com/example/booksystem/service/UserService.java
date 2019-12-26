package com.example.booksystem.service;

import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUserById(int id);

    public User getUserByEmail(String email);

    public User getUserByEmailAndPassword(String email, String password);

    public void addUser(String email, String password);

    public void modifyUserInformation(String id, String name, String sex, int age);
}
