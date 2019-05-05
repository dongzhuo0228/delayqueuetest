package com.example.delayqueuetest.api;

import com.example.delayqueuetest.model.User;
import com.example.delayqueuetest.service.QuestionService;
import com.example.delayqueuetest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class DemoController {


    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/api/save/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
         userService.save(user);
         questionService.save();
    }

    @RequestMapping(value = "/api/save/search", method = RequestMethod.POST)
    public List<User> searchUser(@RequestBody User user) {
        Integer pageNumber = user.getPageNumber();
        Integer pageSize = user.getPageSize();
        String searchContent = user.getSearchContent();
        return userService.searchCity(pageNumber,pageSize,searchContent);
    }

}
