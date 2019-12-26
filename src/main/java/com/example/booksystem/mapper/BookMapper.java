package com.example.booksystem.mapper;

import com.example.booksystem.entity.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    @Insert("insert into book(name,press,author,synopsis,typeid,remain) values(#{name},#{press},#{author},#{synopsis},#{typeId},#{remain})")
    void addBook(String name, String press, String author, String synopsis, int typeId, int remain);

    @Delete("delete from book where id=#{id}")
    void deleteBookById(String id);

    @Select("select * from book where id=#{id}")
    Book getBookById(int id);

    @Select("select * from book where typeid=#{typeId}")
    List<Book> getBooksByType(int typeId);

    @Select("select * from book where name like '%${value}%'")
    List<Book> getBooksByKeywords(String keywords);
}
