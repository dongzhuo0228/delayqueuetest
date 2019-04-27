package com.example.delayqueuetest.api;


import com.example.delayqueuetest.model.User;
import com.example.delayqueuetest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class LoginController {


    @Autowired
    RedisService redisService;

    @RequestMapping("/login")
    public User login(@RequestBody User user){
        String token = user.getUsername() + new Date().toString();
        redisService.set(token,token,60L);
        user.setToken(token);
        return user;
    }

    @RequestMapping("/loginout")
    public User loginout(@RequestBody User user){
        redisService.remove(user.getToken());
        return user;
    }
    @RequestMapping("/test")
    public User test(@RequestBody User user){
        return user;
    }

}
