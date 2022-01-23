package com.github.reactivespring.proxy;

import com.github.reactivespring.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {

    private final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> getAll() {
        return webClient.get().uri("/products")
                        .exchangeToFlux(res -> res.bodyToFlux(Product.class))
                       .onErrorResume(e->Flux.just(new Product("Default")));
//                       .onErrorResume(WebClientRequestException.class,e->Flux.just(new Product("Default")));
//                       .onErrorResume(e->e instanceof WebClientRequestException,e->Flux.just(new Product("Default")));
//                       .onErrorReturn(new Product("Default"));
//                       .onErrorReturn(WebClientRequestException.class,new Product("Default"));
//                       .onErrorReturn(e->e instanceof WebClientRequestException,new Product("Default"));
//                       .onErrorMap(RuntimeException::new);
//                       .onErrorMap(WebClientRequestException.class,RuntimeException::new);
//                       .onErrorMap(e->e instanceof WebClientRequestException,RuntimeException::new);
                        //skips the error
//                        .onErrorContinue((throwable,o)-> System.out.println(throwable.getMessage()));
//                        .onErrorContinue(RuntimeException.class, (throwable,o)-> System.out.println(throwable.getMessage()));
//                        .onErrorContinue(e->e instanceof RuntimeException, (throwable,o)-> System.out.println(throwable.getMessage()));
//                       .retry();
    }
}