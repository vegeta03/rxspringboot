package com.mine.rxspringboot.data.entity;

import com.mine.rxspringboot.data.model.Organization;
import com.mine.rxspringboot.data.model.User;
import com.mine.rxspringboot.data.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userMaster")
public class UserMaster {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;
    private UserType userType;
    private User user;
    private Organization organization;

    public UserMaster(String username, String password, UserType userType, Organization organization) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.organization = organization;
    }

    public UserMaster(String username, String password, UserType userType, User user) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.user = user;
    }
}
