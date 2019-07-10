package com.mine.rxspringboot.configuration.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mine.rxspringboot.data.collection.UserMasterCollection;
import com.mine.rxspringboot.data.repository.UserMasterRepository;

import reactor.core.publisher.Mono;

@Component
public class UserMasterHandler {

    @Autowired
    private UserMasterRepository userMasterRepository;

    public Mono<ServerResponse> listUsersOfAllUserType(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON_UTF8)
                .body(userMasterRepository.findAll(), UserMasterCollection.class);
    }

    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        Mono<UserMasterCollection> userMasterMono = serverRequest.bodyToMono(UserMasterCollection.class);
        return userMasterMono.flatMap(userMaster -> ServerResponse
                .status(HttpStatus.CREATED)
                .contentType(APPLICATION_JSON_UTF8)
                .body(userMasterRepository.save(userMaster), UserMasterCollection.class));
    }

    public Mono<ServerResponse> getUser(ServerRequest serverRequest) {
        String username = serverRequest.pathVariable("username");
        Mono<ServerResponse> notFoundMono = ServerResponse.notFound().build();
        Mono<UserMasterCollection> userMono = userMasterRepository.findByUsername(username);
        return userMono
                .flatMap(user -> ServerResponse
                        .ok()
                        .contentType(APPLICATION_JSON_UTF8)
                        .body(fromObject(user)))
                .switchIfEmpty(notFoundMono);
    }


}
