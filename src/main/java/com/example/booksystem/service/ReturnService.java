package com.example.booksystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReturnService {
    //还书
    void addReturnInfo(int borrowId, String condition, int fine, String remark);

    //查看借阅历史
    List<Map<String, Object>> getBorrowHistory(int userId);
}
