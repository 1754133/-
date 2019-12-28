package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Administrator;
import com.example.booksystem.mapper.AdministratorMapper;
import com.example.booksystem.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    public Administrator getAdministrator(String name, String password){
        return administratorMapper.getAdministrator(name, password);
    }
}
