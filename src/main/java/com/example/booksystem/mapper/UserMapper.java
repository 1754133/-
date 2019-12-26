package com.example.booksystem.mapper;

import com.example.booksystem.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getById(int id);

    @Select("select * from user where email=#{email}")
    User getByEmail(String email);

    @Select("select * from user where email=#{email} and password=#{password}")
    User getByEmailAndPassword(String email, String password);

    @Insert("insert into user(email,password) values(#{email},#{password})")
    void addUser(String email, String password);

    @Update("update user set password=#{password} where id=#{id}")
    void modifyPassword(String id, String password);

    @Update("update user set name=#{name}, sex=#{sex}, age=#{age} where id=#{id}")
    void modifyUserInformation(String id, String name, String sex, int age);


}
