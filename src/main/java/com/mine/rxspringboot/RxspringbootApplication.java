package com.mine.rxspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.mine.rxspringboot.data.repository")
public class RxspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RxspringbootApplication.class, args);
    }

}
