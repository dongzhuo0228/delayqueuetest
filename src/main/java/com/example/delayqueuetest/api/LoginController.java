package com.example.delayqueuetest.api;


import com.example.delayqueuetest.model.User;
import com.example.delayqueuetest.service.RedisService;
import com.example.delayqueuetest.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {

    @Value("${publickeystring}")
    public String publicKeyString;
    @Autowired
    RedisService redisService;
    @RequestMapping("/login")
    public User login(@RequestBody User user) throws Exception {
        String token = RSAUtil.encryptByPubKey(user.getUsername(), publicKeyString);
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
