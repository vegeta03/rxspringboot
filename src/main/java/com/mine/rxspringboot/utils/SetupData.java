package com.mine.rxspringboot.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mine.rxspringboot.data.entity.UserMaster;
import com.mine.rxspringboot.data.model.Organization;
import com.mine.rxspringboot.data.model.User;
import com.mine.rxspringboot.data.model.UserType;
import com.mine.rxspringboot.data.repository.UserMasterRepository;

import reactor.core.publisher.Flux;

@Component
public class SetupData implements ApplicationRunner {

    @Autowired
    private UserMasterRepository userMasterRepository;

    private List<UserMaster> userMasters = new ArrayList<>();

    public SetupData() {
        this.userMasters.add(new UserMaster("asd@qwe.com", "asd", UserType.ORGANIZATION,
                new Organization("asd", "asd-logo-image", "qwe.com")));

        this.userMasters.add(new UserMaster("user1@asd.com", "asd", UserType.USER,
                new User("user1@asd.com", "user1-f", "user1-l", "user1-profile-image")));

        this.userMasters.add(new UserMaster("user2@asd.com", "asd", UserType.USER,
                new User("user2@asd.com", "user2-f", "user2-l", "user2-profile-image")));

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userMasterRepository.deleteAll()
                .thenMany(Flux.fromIterable(this.userMasters))
                .flatMap(userMasterRepository::save)
                .then()
                .doOnEach(System.out::println)
                .block();
    }
}
