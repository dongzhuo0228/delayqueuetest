package com.example.delayqueuetest.mapper;

import com.example.delayqueuetest.model.Demo;
import com.example.delayqueuetest.model.User;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface DemoMapper {

//    @Select("SELECT * FROM test")
    List<Demo> getList();

    @Insert("insert into user(name) values ('111')")
    void save(User user);
}
