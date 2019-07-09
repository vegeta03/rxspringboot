package com.mine.rxspringboot.data.entity;

import com.mine.rxspringboot.data.model.User;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserMaster {
    @Id
    private String id;
    private String username;
    private String password;
    private String userType;
    private User user;
    private Organization organization;
}
