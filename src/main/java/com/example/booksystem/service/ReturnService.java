package com.example.booksystem.service;

import org.springframework.stereotype.Service;

@Service
public interface ReturnService {
    //还书
    void addReturnInfo(int borrowId, String condition, int fine, String remark);
}
