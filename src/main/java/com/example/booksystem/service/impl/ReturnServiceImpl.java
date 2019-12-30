package com.example.booksystem.service.impl;

import com.example.booksystem.entity.BorrowInfo;
import com.example.booksystem.entity.Reservation;
import com.example.booksystem.mapper.BorrowInfoMapper;
import com.example.booksystem.mapper.ReservationMapper;
import com.example.booksystem.mapper.ReturnInfoMapper;
import com.example.booksystem.service.BorrowService;
import com.example.booksystem.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnInfoMapper returnInfoMapper;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private BorrowInfoMapper borrowInfoMapper;

    public void addReturnInfo(int borrowId, String condition, int fine, String remark){
        BorrowInfo borrowInfo = borrowInfoMapper.getBorrowInfoById(borrowId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        returnInfoMapper.addReturnInfo(borrowInfo.getBookId(), borrowInfo.getUserId(), borrowInfo.getBorrowDate(), borrowInfo.getShReturnDate(), simpleDateFormat.format(new Date()), condition, fine, remark);
        borrowInfoMapper.deleteBorrowInfo(borrowId);
    }

}
