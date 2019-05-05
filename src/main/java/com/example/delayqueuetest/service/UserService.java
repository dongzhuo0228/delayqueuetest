package com.example.delayqueuetest.service;

import com.example.delayqueuetest.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void save(User user);

    List<User> searchCity(Integer pageNumber, Integer pageSize, String searchContent);
}
