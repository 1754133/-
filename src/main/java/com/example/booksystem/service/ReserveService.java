package com.example.booksystem.service;

import com.example.booksystem.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReserveService {
    //添加预定
    void addReservation(int bookId, int userId);

    //删除预定
    void deleteReservation(int id);

    //根据读者id查看预定
    List<Map<String, Object>> getReservationByUserId(int userId);
}
