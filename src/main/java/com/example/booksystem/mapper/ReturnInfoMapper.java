package com.example.booksystem.mapper;

import com.example.booksystem.entity.ReturnInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReturnInfoMapper {
    @Insert("insert into return_info(book_id,user_id,borrow_date,sh_return_date,return_date,cond,fine,remark) values(#{bookId},#{userId},#{borrowDate},#{shReturnDate},#{returnDate},#{condition},#{fine},#{remark})")
    void addReturnInfo(int bookId, int userId, String borrowDate, String shReturnDate, String returnDate, String condition, int fine, String remark);

    @Select("select * from return_info where user_id=#{userId}")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "borrow_date", property = "borrowDate"),
            @Result(column = "sh_return_date", property = "shReturnDate"),
            @Result(column = "return_date", property = "returnDate"),
            @Result(column = "cond", property = "condition")
    })
    List<ReturnInfo> getUserReturnInfo(int userId);
}
