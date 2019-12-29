package com.example.booksystem.mapper;

import com.example.booksystem.entity.BorrowInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface BorrowInfoMapper {
    @Insert("insert into borrow_info(book_id,user_id,borrow_date,sh_return_date,renew) values(#{bookId},#{userId},#{borrowDate},#{shReturnDate},#{renew})")
    void addBorrowInfo(int bookId, int userId, String borrowDate, String shReturnDate, boolean renew);

    @Update("update borrow_info set sh_return_date=#{shReturnDate}, renew=#{renew}")
    void renewBook(String shReturnDate, boolean renew);

    @Select("select * from borrow_info")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "borrow_date", property = "borrowDate"),
            @Result(column = "sh_return_date", property = "shReturnDate"),
    })
    List<BorrowInfo> getBorrowInfo();

    @Select("select * from borrow_info where book_id=#{bookId} and user_id=#{userId}")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "borrow_date", property = "borrowDate"),
            @Result(column = "sh_return_date", property = "shReturnDate"),
    })
    BorrowInfo getBorrowInfoByBookIdAndUserId(int bookId, int userId);

    @Select("select * from borrow_info where user_id=#{userId}")
    @Results({
            @Result(column = "book_id", property = "bookId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "borrow_date", property = "borrowDate"),
            @Result(column = "sh_return_date", property = "shReturnDate"),
    })
    List<BorrowInfo> getBorrowInfoByUserId(int userId);

    @Delete("delete from borrow_info where id=#{id}")
    void deleteBorrowInfo(int id);
}
