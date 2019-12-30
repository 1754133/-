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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        bookMapper.updateBookRemain(bookId, --remain);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String borrowDate = simpleDateFormat.format(date1);
        gregorianCalendar.setTime(date1);
        gregorianCalendar.add(2, +1);
        String shReturnDate = simpleDateFormat.format(gregorianCalendar.getTime());
        borrowInfoMapper.addBorrowInfo(bookId, userId, borrowDate, shReturnDate, true);
    }

    public List<Map<String, Object>> getBorrowInfo(){
        List<BorrowInfo> borrowInfoList = borrowInfoMapper.getBorrowInfo();
        List<Map<String, Object>> borrowInfoMapList = new ArrayList<>();
        for (BorrowInfo borrowInfo : borrowInfoList){
            borrowInfoMapList.add(getBorrowInfoMap(borrowInfo));
        }
        return borrowInfoMapList;
    }

    public List<Map<String, Object>> getBorrowInfoByUserId(int userId){
        List<BorrowInfo> borrowInfoList = borrowInfoMapper.getBorrowInfoByUserId(userId);
        List<Map<String, Object>> borrowInfoMapList = new ArrayList<>();
        for (BorrowInfo borrowInfo : borrowInfoList){
            borrowInfoMapList.add(getBorrowInfoMap(borrowInfo));
        }
        return borrowInfoMapList;
    }

    public List<Map<String, Object>> getBorrowInfoByEmail(String email){
        User user = userMapper.getByEmail(email);
        List<BorrowInfo> borrowInfoList = borrowInfoMapper.getBorrowInfoByUserId(user.getId());
        List<Map<String, Object>> borrowInfoMapList = new ArrayList<>();
        for (BorrowInfo borrowInfo : borrowInfoList){
            borrowInfoMapList.add(getBorrowInfoMap1(borrowInfo));
        }
        return borrowInfoMapList;
    }

    public boolean ifBorrowed(int bookId, int userId){
        return borrowInfoMapper.getBorrowInfoByBookIdAndUserId(bookId, userId) == null;
    }

    public void renew(int id, String shReturnDate) throws ParseException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        gregorianCalendar.setTime(dateFormat.parse(shReturnDate));
        gregorianCalendar.add(5, +15);
        borrowInfoMapper.renewBook(id,dateFormat.format(gregorianCalendar.getTime()), false);
    }

    public List<Map<String, Object>> checkOverdue(int userId) throws ParseException {
        List<BorrowInfo> borrowInfoList = borrowInfoMapper.getBorrowInfoByUserId(userId);
        List<Map<String, Object>> borrowInfoMapList = new ArrayList<>();
        for (BorrowInfo borrowInfo : borrowInfoList){
            if (checkDate(borrowInfo)){
                borrowInfoMapList.add(getBorrowInfoMap1(borrowInfo));
            }
        }
        return borrowInfoMapList;
    }

    //判断是否临近期限
    private boolean checkDate(BorrowInfo borrowInfo) throws ParseException {
        String shReturnDate = borrowInfo.getShReturnDate();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        gregorianCalendar.setTime(date);
        gregorianCalendar.add(5, +3);
        if (gregorianCalendar.getTime().before(dateFormat.parse(shReturnDate))){
            return false;
        }
        return true;
    }

    //包装返回结果
    private Map<String, Object> getBorrowInfoMap(BorrowInfo borrowInfo){
        int bookId = borrowInfo.getBookId();
        int userId = borrowInfo.getUserId();
        Book book = bookMapper.getBookById(bookId);
        User user = userMapper.getById(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("id", borrowInfo.getId());
        map.put("bookId", bookId);
        map.put("bookName", book.getName());
        map.put("author", book.getAuthor());
        map.put("isbn", book.getIsbn());
        map.put("userEmail", user.getEmail());
        map.put("borrowDate", borrowInfo.getBorrowDate());
        map.put("shReturnDate", borrowInfo.getShReturnDate());
        map.put("renew", borrowInfo.isRenew());
        return map;
    }

    //包装返回结果
    private Map<String, Object> getBorrowInfoMap1(BorrowInfo borrowInfo){
        int bookId = borrowInfo.getBookId();
        Book book = bookMapper.getBookById(bookId);
        Map<String, Object> map = new HashMap<>();
        map.put("id", borrowInfo.getId());
        map.put("bookId", bookId);
        map.put("bookName", book.getName());
        map.put("author", book.getAuthor());
        map.put("isbn", book.getIsbn());
        map.put("borrowDate", borrowInfo.getBorrowDate());
        map.put("shReturnDate", borrowInfo.getShReturnDate());
        return map;
    }

}
