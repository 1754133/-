package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.BorrowInfo;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.BorrowInfoMapper;
import com.example.booksystem.mapper.TypeMapper;
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

    @Autowired
    private BorrowInfoMapper borrowInfoMapper;

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

    public void borrowBook(int bookId, int userId){
        Book book = bookMapper.getBookById(bookId);
        int remain = book.getRemain();
        remain--;
        bookMapper.updateBookRemain(bookId, remain);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Date borrowDate = new Date();
        gregorianCalendar.setTime(borrowDate);
        gregorianCalendar.add(2, +1);
        borrowInfoMapper.addBorrowInfo(bookId, userId, borrowDate, gregorianCalendar.getTime(), true);
    }

    public List<Map<String, Object>> getBorrowInfo(){
        List<BorrowInfo> borrowInfoList = borrowInfoMapper.getBorrowInfo();
        List<Map<String, Object>> borrowInfoMapList = new ArrayList<>();
        return null;
    }

    //封装book详细的结果
    private Map<String, Object> getBookMap(Book book){
        int typeId = book.getTypeid();
        Map<String, Object> map = new HashMap<>();
        map.put("bookId", book.getId());
        map.put("name", book.getName());
        map.put("press", book.getPress());
        map.put("author", book.getAuthor());
        map.put("shelfId", book.getShelfId());
        map.put("synopsis", book.getSynopsis());
        map.put("type", typeMapper.getBookType(typeId));
        map.put("remain", book.getRemain());
        return map;
    }

    private Map<String, Object> getBorrowInfoMap(BorrowInfo borrowInfo){
        int bookId = borrowInfo.getBookId();
        return null;
    }

}
