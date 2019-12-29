package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Reservation;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.ReservationMapper;
import com.example.booksystem.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private BookMapper bookMapper;

    //添加预定
    public void addReservation(int bookId, int userId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        reservationMapper.addReservation(bookId, userId, simpleDateFormat.format(new Date()));
    }

    //删除预定
    public void deleteReservation(int id){
        reservationMapper.deleteReservation(id);
    }

    //根据读者id查看预定
    public List<Map<String, Object>> getReservationByUserId(int userId){
        List<Reservation> reservationList = reservationMapper.getReservationByUserId(userId);
        List<Map<String, Object>> reservationMapList = new ArrayList<>();
        for (Reservation reservation : reservationList){
            Map<String, Object> map = new HashMap<>();
            Book book = bookMapper.getBookById(reservation.getBookId());
            map.put("bookName", book.getName());
            map.put("isbn", book.getIsbn());
            map.put("reservationDate", reservation.getReservationDate());
            reservationMapList.add(map);
        }
        return reservationMapList;
    }
}
