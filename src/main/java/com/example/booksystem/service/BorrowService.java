package com.example.booksystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BorrowService {
    //借书
    void borrowBook(int bookId, int userId);

    //查看借阅信息
    List<Map<String, Object>> getBorrowInfo();

    //用户查看自己的借阅信息
    List<Map<String, Object>> getBorrowInfoByUserId(int userId);

    //检查是否已有借阅信息
    boolean ifBorrowed(int bookId, int userId);

}
