package com.example.booksystem.mapper;

import com.example.booksystem.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(column = "if_banned", property = "ifBanned"),
    })
    User getById(int id);

    @Select("select * from user where email=#{email}")
    @Results({
            @Result(column = "if_banned", property = "ifBanned"),
    })
    User getByEmail(String email);

    @Select("select * from user where email=#{email} and password=#{password}")
    @Results({
            @Result(column = "if_banned", property = "ifBanned"),
    })
    User getByEmailAndPassword(String email, String password);

    @Insert("insert into user(email,password,if_banned) values(#{email},#{password},#{ifBanned})")
    void addUser(String email, String password, boolean ifBanned);

    @Update("update user set password=#{password} where id=#{id}")
    void modifyPassword(int id, String password);

    @Update("update user set name=#{name},sex=#{sex},age=#{age},telephone=#{telephone},speciality=#{speciality} where id=#{id}")
    void modifyUserInformation(int id, String name, String sex, int age, String telephone, String speciality);

    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);

    @Update("update user set if_banned=#{ifBanned} where id=#{id}")
    void banUser(int id, boolean ifBanned);
}
