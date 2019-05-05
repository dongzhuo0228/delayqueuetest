package com.example.delayqueuetest.mapper;

import org.apache.ibatis.annotations.Insert;

public interface QuestionMapper {
    @Insert("insert into question(question) value('11111111')")
    void save();
}
