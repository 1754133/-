package com.example.booksystem.mapper;

import com.example.booksystem.entity.BorrowInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface BorrowInfoMapper {
    @Insert("insert into borrow_info(book_id,user_id,borrow_date,sh_return_date,renew) values(#{bookId},#{userId},#{borrowDate},#{shReturnDate},#{renew})")
    void addBorrowInfo(int bookId, int userId, Date borrowDate, Date shReturnDate, boolean renew);

    @Update("update borrow_info set sh_return_date=#{shReturnDate}, renew=#{renew}")
    void renewBook(Date shReturnDate, boolean renew);

    @Update("update borrow_info set return_date=#{returnDate}")
    void returnBook(Date returnDate);

    @Select("select * from borrow_info")
    List<BorrowInfo> getBorrowInfo();
}
