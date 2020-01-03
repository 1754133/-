package com.example.booksystem.service.impl;

import com.example.booksystem.entity.*;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.BorrowInfoMapper;
import com.example.booksystem.mapper.ReturnInfoMapper;
import com.example.booksystem.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnInfoMapper returnInfoMapper;

    @Autowired
    private BorrowInfoMapper borrowInfoMapper;

    @Autowired
    private BookMapper bookMapper;

    public void addReturnInfo(int borrowId, String condition, int fine, String remark){
        BorrowInfo borrowInfo = borrowInfoMapper.getBorrowInfoById(borrowId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        returnInfoMapper.addReturnInfo(borrowInfo.getBookId(), borrowInfo.getUserId(), borrowInfo.getBorrowDate(), borrowInfo.getShReturnDate(), simpleDateFormat.format(new Date()), condition, fine, remark);
        borrowInfoMapper.deleteBorrowInfo(borrowId);
    }

    public List<Map<String, Object>> getBorrowHistory(int userId){
        List<ReturnInfo> returnInfoList = returnInfoMapper.getUserReturnInfo(userId);
        List<Map<String, Object>> returnInfoMapList = new ArrayList<>();
        for (ReturnInfo returnInfo : returnInfoList){
            returnInfoMapList.add(getReturnInfoMap(returnInfo));
        }
        return returnInfoMapList;
    }

    //包装返回结果
    private Map<String, Object> getReturnInfoMap(ReturnInfo returnInfo){
        int bookId = returnInfo.getBookId();
        Book book = bookMapper.getBookById(bookId);
        Map<String, Object> map = new HashMap<>();
        map.put("bookName", book.getName());
        map.put("author", book.getAuthor());
        map.put("isbn", book.getIsbn());
        map.put("borrowDate", returnInfo.getBorrowDate());
        map.put("shReturnDate", returnInfo.getShReturnDate());
        map.put("returnDate", returnInfo.getReturnDate());
        map.put("condition", returnInfo.getCondition());
        map.put("fine", returnInfo.getFine());
        map.put("remark", returnInfo.getRemark());
        return map;
    }

}
