package com.mine.rxspringboot.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mine.rxspringboot.data.collection.UserMasterCollection;
import com.mine.rxspringboot.data.model.UserType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserMasterRepository extends ReactiveMongoRepository<UserMasterCollection, String> {

    Mono<UserMasterCollection> findByUsername(String username);

    Flux<UserMasterCollection> findByUserType(UserType userType);
}