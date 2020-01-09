package com.example.booksystem.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReserveService {
    //添加预定
    void addReservation(int bookId, int userId);

    //删除预定
    void deleteReservation(int bookId);

    //取消预定
    void cancelReservation(int bookId, int userId);

    //根据读者id查看预定
    List<Map<String, Object>> getReservationByUserId(int userId);

    //检查某本书是否被预约
    boolean ifReserved(int bookId, int userId);
}
