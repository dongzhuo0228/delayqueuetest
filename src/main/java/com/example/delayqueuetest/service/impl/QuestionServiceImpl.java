package com.example.delayqueuetest.service.impl;

import com.example.delayqueuetest.mapper.QuestionMapper;
import com.example.delayqueuetest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void save() {
        questionMapper.save();
    }
}
