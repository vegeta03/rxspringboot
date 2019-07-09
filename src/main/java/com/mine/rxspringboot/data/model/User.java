package com.mine.rxspringboot.data.model;

import lombok.Data;

@Data
public class User {
    private String email;
    private String firstname;
    private String lastname;
    private String profileImage;
}
