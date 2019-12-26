package com.example.booksystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BookService {
    Map<String, Object> getBookById(int bookId);

    List<Map<String, Object>> getBooksByType(String typeName);

    List<Map<String, Object>> getBooksByKeywords(String keywords);

    //借书
    void borrowBook(int bookId, int userId);

    //查看借阅信息
    List<Map<String, Object>> getBorrowInfo();
}
