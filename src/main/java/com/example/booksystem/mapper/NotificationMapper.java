package com.example.booksystem.mapper;

import com.example.booksystem.entity.Notification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NotificationMapper {
    @Insert("insert into notification(content,date) values(#{content},#{date})")
    void addNotification(String content, String date);

    @Select("select * from notification")
    List<Notification> getNotification();

    @Delete("delete from notification where id=#{id}")
    void deleteNotification(int id);
}
