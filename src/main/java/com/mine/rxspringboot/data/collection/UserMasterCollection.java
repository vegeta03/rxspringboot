package com.mine.rxspringboot.data.collection;

import com.mine.rxspringboot.data.model.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userMaster")
public class UserMasterCollection {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;
    private UserType userType;

    @DBRef
    private UserCollection user;

    @DBRef
    private OrganizationCollection organization;

    public UserMasterCollection(String username, String password, UserType userType, OrganizationCollection organization) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.organization = organization;
    }

    public UserMasterCollection(String username, String password, UserType userType, UserCollection user) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.user = user;
    }
}
