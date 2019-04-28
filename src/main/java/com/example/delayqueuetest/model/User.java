package com.example.delayqueuetest.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName="user",type="test")
public class User implements Serializable {

    private static final long serialVersionUID = -1L;
    private int id;
    private String username;
    private Integer age;
    private String token;
    private Integer pageNumber;
    private Integer pageSize;
    private String searchContent;
}
