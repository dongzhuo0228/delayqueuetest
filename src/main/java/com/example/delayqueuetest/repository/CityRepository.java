package com.example.delayqueuetest.repository;

import com.example.delayqueuetest.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface CityRepository extends  ElasticsearchRepository<User, Integer>{


}
