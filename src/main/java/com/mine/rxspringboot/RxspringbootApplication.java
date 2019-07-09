package com.mine.rxspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableReactiveMongoRepositories(basePackages = "com.mine.rxspringboot.data.repository")
public class RxspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RxspringbootApplication.class, args);
    }

}
