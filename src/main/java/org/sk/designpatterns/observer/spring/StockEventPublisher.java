package org.sk.designpatterns.observer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class StockEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(final StockEvent stockEvent) {
        applicationEventPublisher.publishEvent(stockEvent);
    }
}