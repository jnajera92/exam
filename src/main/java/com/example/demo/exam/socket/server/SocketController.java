package com.example.demo.exam.socket.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class SocketController implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {
        Flux<String> stringFlux = webSocketSession.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .map(x->{
                    try {
                        if (Integer.parseInt(x)%2==0){
                            return "el numero es par";
                        }else return "el numero es impar";
                    }catch (Exception e){
                        return "favor de ingresar un valor numerico";
                    }
                });
        return webSocketSession.send(stringFlux.map(webSocketSession::textMessage));
    }
}
