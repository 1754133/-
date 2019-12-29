package com.example.booksystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReturnInfoMapper {
    @Insert("insert into return_info(book_id,user_id,borrow_date,sh_return_date,return_date,cond,fine,remark) values(#{bookId},#{userId},#{borrowDate},#{shReturnDate},#{returnDate},#{condition},#{fine},#{remark})")
    void addReturnInfo(int bookId, int userId, String borrowDate, String shReturnDate, String returnDate, String condition, int fine, String remark);
}
