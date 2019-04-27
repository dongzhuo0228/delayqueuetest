package com.example.delayqueuetest.Interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.delayqueuetest.filter.HttpHelper;
import com.example.delayqueuetest.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    RedisService redisService;

   public LoginInterceptor( RedisService redisService){
     this.redisService = redisService;
   }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String bodyString = HttpHelper.getBodyString(request);
        JSONObject jsonObject = JSON.parseObject(bodyString);
        String token = String.valueOf(jsonObject.get("token"));
        Object token1 = redisService.get(token);
        if(token1 == null){
            throw new Exception("token失效!,登录失效");
        }
         redisService.set(token,token,60L);
        return true;
    }

}
