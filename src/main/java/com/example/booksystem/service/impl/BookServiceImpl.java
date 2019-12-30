package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.BorrowInfoMapper;
import com.example.booksystem.mapper.TypeMapper;
import com.example.booksystem.mapper.UserMapper;
import com.example.booksystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private TypeMapper typeMapper;

    public Map<String, Object> getBookById(int bookid){
        Book book = bookMapper.getBookById(bookid);
        return getBookMap(book);
    }

    public List<Map<String, Object>> getBooksByType(String typeName){
        int typeId = typeMapper.getTypeId(typeName);
        List<Book> bookList = bookMapper.getBooksByType(typeId);
        List<Map<String, Object>> bookMapList = new ArrayList<>();
        for (Book book : bookList){
            bookMapList.add(getBookMap(book));
        }
        return bookMapList;
    }

    public List<Map<String, Object>> getBooksByKeywords(String keywords){
        List<Book> bookList = bookMapper.getBooksByKeywords(keywords);
        List<Map<String, Object>> bookMapList = new ArrayList<>();
        for (Book book : bookList){
            bookMapList.add(getBookMap(book));
        }
        return bookMapList;
    }

    public boolean addBook(String name, String press, String author, String shelfId, String synopsis, int typeId, int remain, String isbn){
        if (bookMapper.getBookByIsbn(isbn) == null){
            bookMapper.addBook(name, press, author, shelfId, synopsis, typeId, remain, isbn);
            return true;
        }
        return false;
    }

    public void updateBookInfo(int id, String name, String press, String author, String shelfId, String synopsis, int typeId, int remain, String isbn){
        bookMapper.updateBookInfo(id, name, press, author, shelfId, synopsis, typeId, remain, isbn);
    }

    public void updateRemain(int id){
        int remain = bookMapper.getBookById(id).getRemain();
        bookMapper.updateBookRemain(id, ++remain);
        System.out.println("库存为" + bookMapper.getBookById(id).getRemain());
    }

    //封装book详细的结果
    private Map<String, Object> getBookMap(Book book){
        int typeId = book.getTypeId();
        Map<String, Object> map = new HashMap<>();
        map.put("bookId", book.getId());
        map.put("name", book.getName());
        map.put("press", book.getPress());
        map.put("author", book.getAuthor());
        map.put("shelfId", book.getShelfId());
        map.put("synopsis", book.getSynopsis());//简介
        map.put("type", typeMapper.getBookType(typeId));
        map.put("remain", book.getRemain());
        map.put("isbn", book.getIsbn());
        return map;
    }


}
