package com.mine.rxspringboot.configuration.router;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mine.rxspringboot.configuration.handler.UserMasterHandler;

@Configuration
public class UserMasterRouterConfig {

    @Bean
    public RouterFunction<ServerResponse> userMasterRoute(UserMasterHandler userMasterHandler) {
        return RouterFunctions
                .route(GET("/user/{username}")
                        .and(accept(APPLICATION_JSON_UTF8)), userMasterHandler::getUser)
                .andRoute(GET("/user")
                        .and(accept(APPLICATION_JSON_UTF8)), userMasterHandler::listUsersOfAllUserType)
                .andRoute(POST("/user")
                        .and(contentType(APPLICATION_JSON_UTF8)), userMasterHandler::createUser);
    }
}
