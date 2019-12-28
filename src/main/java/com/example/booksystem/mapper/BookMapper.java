package com.example.booksystem.mapper;

import com.example.booksystem.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {
    @Insert("insert into book(name,press,author,shelfid,synopsis,typeid,remain,isbn) values(#{name},#{press},#{author},#{shelfId},#{synopsis},#{typeId},#{remain},#{isbn})")
    void addBook(String name, String press, String author, String shelfId, String synopsis, int typeId, int remain, String isbn);

    @Delete("delete from book where id=#{id}")
    void deleteBookById(String id);

    @Select("select * from book where id=#{id}")
    Book getBookById(int id);

    @Select("select * from book where typeid=#{typeId}")
    List<Book> getBooksByType(int typeId);

    @Select("select * from book where name like '%${value}%'")
    List<Book> getBooksByKeywords(String keywords);

    @Select("select * from book where isbn=#{isbn}")
    Book getBookByIsbn(String isbn);

    @Update("update book set remain=#{remain} where id=#{id}")
    void updateBookRemain(int id, int remain);

    @Update("update book set name=#{name},press=#{press},author=#{author},shelfid=#{shelfId},synopsis=#{synopsis},typeid=#{typeId},remain=#{remain},isbn=#{isbn} where id=#{id}")
    void updateBookInfo(int id, String name, String press, String author, String shelfId, String synopsis, int typeId, int remain, String isbn);
}
