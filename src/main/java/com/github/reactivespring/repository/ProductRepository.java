package com.github.reactivespring.repository;

import com.github.reactivespring.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author iamsinghankit
 */
public interface ProductRepository extends ReactiveCrudRepository<Product,Integer> {

}
