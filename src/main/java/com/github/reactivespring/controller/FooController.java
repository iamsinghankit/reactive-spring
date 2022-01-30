package com.github.reactivespring.controller;

import com.github.reactivespring.subscriber.FooSubscriber;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author _singhankit
 */
@RestController
public class FooController {


    @GetMapping("/foo")
    public void foo() {

        Publisher<Integer> f1 = Flux.just(1, 2, 3, 4, 5, 6);
//        Flux<Integer> f2 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));
        Flux<Object> f2 = Flux.just(1,new RuntimeException(),3);
        var f3 = Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6));
//        f2.subscribe(System.out::println);
//        f2.doOnNext(e -> {
//              throw new RuntimeException("Noo");
//          })
          f2.subscribe(new FooSubscriber());
    }
}
