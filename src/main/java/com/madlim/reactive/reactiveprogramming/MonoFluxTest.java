package com.madlim.reactive.reactiveprogramming;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void TestMono(){
        //any datatype can be inserted
        Mono<?> monoString =  Mono.just("madlim")
                .then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring-Boot", "TestVar")
                .concatWithValues("Added Value")
                .concatWith(Flux.error(new RuntimeException("Runtime Exception Occured:::")))
                .concatWithValues("Random String")
                .log();
        stringFlux.subscribe(System.out::println); //emit the event
    }
}
