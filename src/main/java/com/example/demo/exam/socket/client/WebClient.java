package com.example.demo.exam.socket.client;



import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

public class WebClient {

    public static void main(String[] args) {

        int number = 6;
        WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(
                        URI.create("ws://localhost:8080/socketserver"),
                        session -> session.send(
                                        Mono.just(session.textMessage(String.valueOf(number))))
                                .thenMany(session.receive()
                                        .map(WebSocketMessage::getPayloadAsText)
                                        .log())
                                .then())
                .block(Duration.ofSeconds(10L));
    }
}
