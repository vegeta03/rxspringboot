package com.mine.rxspringboot.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mine.rxspringboot.data.entity.UserMaster;

public interface UserMasterRepository extends ReactiveMongoRepository<UserMaster, String> {
    
}