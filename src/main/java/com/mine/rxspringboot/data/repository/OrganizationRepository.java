package com.mine.rxspringboot.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mine.rxspringboot.data.collection.OrganizationCollection;

import reactor.core.publisher.Mono;

public interface OrganizationRepository extends ReactiveMongoRepository<OrganizationCollection, String> {

    Mono<OrganizationCollection> findByEmail(String email);
}
