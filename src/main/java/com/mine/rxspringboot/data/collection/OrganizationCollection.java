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
@Document(collection = "organization")
public class OrganizationCollection {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String name;
    private String logoImage;
    private String url;
    private Boolean verified;

    public OrganizationCollection(String email, String name, String logoImage, String url, Boolean verified) {
        this.email = email;
        this.name = name;
        this.logoImage = logoImage;
        this.url = url;
        this.verified = verified;
    }
}
