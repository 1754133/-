package com.example.booksystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TypeMapper {
    @Select("select type_name from type where type_id=#{typeId}")
    String getBookType(int typeId);

    @Select("select type_id from type where type_name=#{typeName}")
    int getTypeId(String typeName);
}
