package com.example.booksystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BookService {
    Map<String, Object> getBookById(int bookId);

    List<Map<String, Object>> getBooksByKeywordsAndType(String keywords, int typeId);

    List<Map<String, Object>> getBooksByKeywords(String keywords);
    //添加书籍
    boolean addBook(String name, String press, String author, String shelfId, String synopsis, int typeId, int remain, String isbn);

    void updateBookInfo(int id, String name, String press, String author, String shelfId, String synopsis, int typeId, int remain, String isbn);

    void updateRemain(int id);
}
