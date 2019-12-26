package com.example.booksystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TypeMapper {
    @Select("select typename from type where typeid=#{typeId}")
    String getBookType(int typeId);

    @Select("select typeid from type where typename=#{typeName}")
    int getTypeId(String typeName);
}
