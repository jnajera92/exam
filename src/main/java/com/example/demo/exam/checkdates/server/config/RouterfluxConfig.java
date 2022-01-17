package com.example.demo.exam.checkdates.server.config;

import com.example.demo.exam.checkdates.server.infrastructure.DateController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class RouterfluxConfig {
    @Bean
    RouterFunction<?> routes(DateController requestHandler) {
    return RouterFunctions
            .route(RequestPredicates.GET("/date"),
                    requestHandler::getData);
}
}