package com.example.booksystem.service;

import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    User getUserById(int id);

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email, String password);

    Map<String, Object> login(String email, String password);

    void addUser(String email, String password, boolean ifBanned);

    void modifyUserInformation(int id, String name, String sex, int age, String telephone, String speciality);

    boolean modifyPassword(int id, String oldPassword, String newPassword);

    void deleteUser(int id);

    void banUser(int id);
}
