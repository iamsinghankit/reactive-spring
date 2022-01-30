package com.github.reactivespring.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * @author iamsinghankit
 */
public class FooSubscriber implements Subscriber<Object> {
    Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("Subscribed" );
        subscription = s;
        s.request(1);
    }

    @Override
    public void onNext(Object integer) {
        System.out.println("onNext: " + integer);
        subscription.request(1); //Backpressure
//        if(integer==3)
//            throw new RuntimeException("Noooo");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError: " + t);
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
