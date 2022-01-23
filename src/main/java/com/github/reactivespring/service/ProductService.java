package com.github.reactivespring.service;

import com.github.reactivespring.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * @author iamsinghankit
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    public Flux<Product> getAll() {

        return Flux.fromStream(Stream.of(new Product("Beer"), new Product("Chocolate")))
           .delayElements(Duration.ofSeconds(3));
    }
}
