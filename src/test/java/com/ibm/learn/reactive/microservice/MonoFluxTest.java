package com.ibm.learn.reactive.microservice;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono(){

        //1. Mono - All events ending onComplete()
        Mono<String> stringMono = Mono.just("Reactive Programming").log();
        stringMono.subscribe(System.out::println);


        //2. Mono - All events ending onError
        Mono<Object> objectMono = Mono.just("Reactive Programming")
                .then(Mono.error(new NullPointerException("Exception")))
                .log();
        objectMono.subscribe(System.out::println, e -> System.out.println(e.getMessage()));

    }

    @Test
    public void testFlux(){
        //1. Flux - All events with multiple onNext() and ending with onComplete()
        Flux<String> stringFlux = Flux.just("Reactive", "Programming", "Springboot").log();
        stringFlux.subscribe(System.out::println);

        //2. Flux - All events with multiple onNext() and ending with onError()
        Flux<String> objectFlux = Flux.just("Reactive", "Programming", "Springboot")
                .concatWith(Flux.error(new RuntimeException("Exception in Flux")))
                .log();
        objectFlux.subscribe(System.out::println, e -> System.out.println(e.getMessage()));

    }
}
