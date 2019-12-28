package com.example.booksystem.service;

import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserById(int id);

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email, String password);


    void addUser(String email, String password);

    void modifyUserInformation(String id, String name, String sex, int age);
}
