package com.example.delayqueuetest.api;

import com.example.delayqueuetest.mapper.DemoMapper;
import com.example.delayqueuetest.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoMapper demoMapper;

    @RequestMapping("/lists")
    public List<Demo> getList(){
        return demoMapper.getList();
    }

}
