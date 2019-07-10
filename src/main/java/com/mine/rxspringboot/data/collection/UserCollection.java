package com.mine.rxspringboot.data.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class UserCollection {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String firstname;
    private String lastname;
    private String profileImage;
    private Boolean verified;

//    @DBRef
//    private OrganizationCollection organization;


    public UserCollection(String email, String firstname, String lastname, String profileImage, Boolean verified) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profileImage = profileImage;
        this.verified = verified;
    }
}
