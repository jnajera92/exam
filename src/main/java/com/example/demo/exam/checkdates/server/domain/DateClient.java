package com.example.demo.exam.checkdates.server.domain;

import org.springframework.web.bind.annotation.GetMapping;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "date-service", url = "http://date.jsontest.com/")
public interface DateClient {

    @GetMapping()
    Mono<DateDto> getDate();
}
