package com.example.booksystem.mapper;

import com.example.booksystem.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdministratorMapper {
    @Select("select * from administrator where name=#{name} and password=#{password}")
    Administrator getAdministrator(String name, String password);
}
