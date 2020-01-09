package com.example.booksystem.mapper;

import com.example.booksystem.entity.Reservation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReservationMapper {
    @Insert("insert into reservation(book_id,user_id,reservation_date) values(#{bookId},#{userId},#{reservationDate})")
    void addReservation(int bookId, int userId, String reservationDate);

    @Delete("delete from reservation where id=#{id}")
    void deleteReservation(int id);

    @Delete("delete from reservation where user_id=#{userId}")
    void deleteReservationByUserId(int userId);

    @Delete("delete from reservation where book_id=#{bookId} and user_id=#{userId}")
    void deleteReservationByBookIdAndUserId(int bookId, int userId);

    @Select("select * from reservation where book_id=#{bookId}")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "reservation_date", property = "reservationDate")
    })
    List<Reservation> getReservationByBookId(int bookId);

    @Select("select * from reservation where user_id=#{userId}")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "reservation_date", property = "reservationDate")
    })
    List<Reservation> getReservationByUserId(int userId);

    @Select("select * from reservation where book_id=#{bookId} and user_id=#{userId}")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "reservation_date", property = "reservationDate")
    })
    Reservation getReservationByBookIdAndUserId(int bookId, int userId);
}
