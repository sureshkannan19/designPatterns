package org.sk.designpatterns.observer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockEventPublisher publisher;

    public void updateStock() {
        publisher.publishEvent(new StockEvent(this, "Wayne Enterprises", 10000));
    }
}
