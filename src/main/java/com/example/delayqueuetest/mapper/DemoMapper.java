package com.example.delayqueuetest.mapper;

import com.example.delayqueuetest.model.Demo;

import java.util.List;

public interface DemoMapper {

//    @Select("SELECT * FROM test")
    List<Demo> getList();
}
