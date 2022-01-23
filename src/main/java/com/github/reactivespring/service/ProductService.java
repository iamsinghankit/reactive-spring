package com.github.reactivespring.service;

import com.github.reactivespring.model.Product;
import com.github.reactivespring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author iamsinghankit
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> products() {
        return productRepository.findAll().delayElements(Duration.ofSeconds(2));
    }
}
