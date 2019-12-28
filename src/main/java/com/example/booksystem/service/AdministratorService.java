package com.example.booksystem.service;

import com.example.booksystem.entity.Administrator;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorService {
    Administrator getAdministrator(String name, String password);
}
