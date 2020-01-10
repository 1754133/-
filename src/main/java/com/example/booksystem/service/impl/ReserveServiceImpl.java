package com.example.booksystem.service.impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.Reservation;
import com.example.booksystem.mapper.BookMapper;
import com.example.booksystem.mapper.ReservationMapper;
import com.example.booksystem.service.BorrowService;
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

    @Autowired
    private BorrowService borrowService;

    //添加预定
    public void addReservation(int bookId, int userId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        reservationMapper.addReservation(bookId, userId, simpleDateFormat.format(new Date()));
    }

    //删除预定
    public void deleteReservation(int bookId){
        List<Reservation> reservationList = reservationMapper.getReservationByBookId(bookId);
        if (reservationList.size() != 0){
            int userId = reservationList.get(0).getUserId();
            borrowService.borrowBook(bookId, userId, true);
            reservationMapper.deleteReservation(reservationList.get(0).getId());
        }
    }

    //取消预定
    public void cancelReservation(int bookId, int userId){
        reservationMapper.deleteReservationByBookIdAndUserId(bookId, userId);
    }

    //根据读者id查看预定
    public List<Map<String, Object>> getReservationByUserId(int userId){
        List<Reservation> reservationList = reservationMapper.getReservationByUserId(userId);
        List<Map<String, Object>> reservationMapList = new ArrayList<>();
        for (Reservation reservation : reservationList){
            Map<String, Object> map = new HashMap<>();
            Book book = bookMapper.getBookById(reservation.getBookId());
            map.put("bookId", book.getId());
            map.put("bookName", book.getName());
            map.put("author", book.getAuthor());
            map.put("isbn", book.getIsbn());
            map.put("reservationDate", reservation.getReservationDate());
            reservationMapList.add(map);
        }
        return reservationMapList;
    }

    public boolean ifReserved(int bookId, int userId){
        if (reservationMapper.getReservationByBookIdAndUserId(bookId, userId) != null){
            return true;
        }
        return false;
    }
}
