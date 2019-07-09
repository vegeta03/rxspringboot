package com.mine.rxspringboot.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Organization {
    private String name;
    private String logoImage;
    private String url;
}
