package com.mine.rxspringboot.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mine.rxspringboot.data.entity.UserMaster;
import com.mine.rxspringboot.data.model.UserType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserMasterRepository extends ReactiveMongoRepository<UserMaster, String> {

    Mono<UserMaster> findByUsername(String username);

    Flux<UserMaster> findByUserType(UserType userType);
}