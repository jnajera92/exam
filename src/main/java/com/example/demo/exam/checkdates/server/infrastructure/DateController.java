package com.example.demo.exam.checkdates.server.infrastructure;

import com.example.demo.exam.checkdates.server.application.ChangeDateFormat;
import com.example.demo.exam.checkdates.server.domain.DateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class DateController {
    @Autowired
    ChangeDateFormat dateClient;
    //empoint del servicio "localhost:8080/date"
    public Mono<ServerResponse> getData(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dateClient.formatDate(), DateDto.class);

    }
}
