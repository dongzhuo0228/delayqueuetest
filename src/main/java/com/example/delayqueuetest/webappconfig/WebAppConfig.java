package com.example.delayqueuetest.webappconfig;

import com.example.delayqueuetest.interceptor.LoginInterceptor;
import com.example.delayqueuetest.filter.HttpServletRequestReplacedFilter;
import com.example.delayqueuetest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RedisService redisService;
    @Value("${privatekeystring}")
    String privateKeyString;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor(new LoginInterceptor(redisService,privateKeyString)).excludePathPatterns("/login");
    }
    @Bean
    public FilterRegistrationBean httpServletRequestReplacedRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestReplacedFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("httpServletRequestReplacedFilter");
        registration.setOrder(1);
        return registration;
    }



}