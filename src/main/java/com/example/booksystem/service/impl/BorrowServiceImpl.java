package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.BorrowInfo;
import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.BorrowInfoMapper;
import com.example.booksystem.mapper.UserMapper;
import com.example.booksystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BorrowInfoMapper borrowInfoMapper;

    @Autowired
    private UserMapper userMapper;

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
        for (BorrowInfo borrowInfo : borrowInfoList){
            borrowInfoMapList.add(getBorrowInfoMap(borrowInfo));
        }
        return borrowInfoMapList;
    }

    public boolean ifBorrowed(int bookId, int userId){
        return borrowInfoMapper.getBorrowInfoByBookIdAndUserId(bookId, userId) == null;
    }

    private Map<String, Object> getBorrowInfoMap(BorrowInfo borrowInfo){
        int bookId = borrowInfo.getBookId();
        int userId = borrowInfo.getUserId();
        Book book = bookMapper.getBookById(bookId);
        User user = userMapper.getById(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("bookName", book.getName());
        map.put("isbn", book.getIsbn());
        map.put("userEmail", user.getEmail());
        map.put("borrowDate", borrowInfo.getBorrowDate());
        map.put("shReturnDate", borrowInfo.getShReturnDate());
        map.put("renew", borrowInfo.isRenew());
        return map;
    }

}
