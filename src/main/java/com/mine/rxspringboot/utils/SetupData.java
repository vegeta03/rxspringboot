package com.mine.rxspringboot.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.mine.rxspringboot.data.collection.OrganizationCollection;
import com.mine.rxspringboot.data.collection.UserCollection;
import com.mine.rxspringboot.data.collection.UserMasterCollection;
import com.mine.rxspringboot.data.model.UserType;
import com.mine.rxspringboot.data.repository.OrganizationRepository;
import com.mine.rxspringboot.data.repository.UserMasterRepository;
import com.mine.rxspringboot.data.repository.UserRepository;

import reactor.core.publisher.Flux;

@Component
public class SetupData implements ApplicationRunner {

    @Autowired
    private UserMasterRepository userMasterRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private UserRepository userRepository;

    private List<UserCollection> users = new ArrayList<>();
    private List<OrganizationCollection> organizations = new ArrayList<>();
    private List<UserMasterCollection> userMasters = new ArrayList<>();

    public SetupData() {
        this.createOrganizations();
        this.createUsers();
        this.createUserMasters();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        organizationRepository.deleteAll()
                .thenMany(Flux.fromIterable(this.organizations))
                .flatMap(organizationRepository::save)
                .then()
                .doOnEach(System.out::println)
                .block();

        userRepository.deleteAll()
                .thenMany(Flux.fromIterable(this.users))
                .flatMap(userRepository::save)
                .then()
                .doOnEach(System.out::println)
                .block();

        organizationRepository.count()
                .filter(count -> count > 0)
                .and(userRepository.count()
                        .filter(count -> count > 0))
                .and(userMasterRepository.deleteAll())
                .thenMany(Flux.fromIterable(this.userMasters))
                .flatMap(userMasterRepository::save)
                .then()
                .doOnEach(System.out::println)
                .block();


        /*userMasterRepository.deleteAll()
                .thenMany(Flux.fromIterable(this.userMasters))
                .flatMap(userMasterRepository::save)
                .then()
                .doOnEach(System.out::println)
                .block();*/
    }

    private void createOrganizations() {
        this.organizations.add(new OrganizationCollection("asd@qwe.com", "asd", "asd-logo-image",
                "qwe.com", false));
    }

    private void createUsers() {
        this.users.add(new UserCollection("user1@asd.com", "user1-f", "user1-l",
                "user1-profile-image", false));
        this.users.add(new UserCollection("user2@asd.com", "user2-f", "user2-l",
                "user2-profile-image", false));
    }

    private void createUserMasters() {
        this.userMasters.add(new UserMasterCollection("asd@qwe.com", "asd", UserType.ORGANIZATION,
                new OrganizationCollection("asd@qwe.com", "asd", "asd-logo-image",
                        "qwe.com", false)));

        this.userMasters.add(new UserMasterCollection("user1@asd.com", "asd", UserType.USER,
                new UserCollection("user1@asd.com", "user1-f", "user1-l",
                        "user1-profile-image", false)));

        this.userMasters.add(new UserMasterCollection("user2@asd.com", "asd", UserType.USER,
                new UserCollection("user2@asd.com", "user2-f", "user2-l",
                        "user2-profile-image", false)));
    }
}
