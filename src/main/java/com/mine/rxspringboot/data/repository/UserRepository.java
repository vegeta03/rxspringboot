package com.mine.rxspringboot.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mine.rxspringboot.data.collection.UserCollection;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<UserCollection, String> {

    Mono<UserCollection> findByEmail(String email);

//    Flux<UserCollection> findByOrganization(OrganizationCollection organization);
}
