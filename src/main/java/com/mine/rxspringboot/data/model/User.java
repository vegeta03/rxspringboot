package com.mine.rxspringboot.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String email;
    private String firstname;
    private String lastname;
    private String profileImage;
}
