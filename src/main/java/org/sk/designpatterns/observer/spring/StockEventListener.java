package org.sk.designpatterns.observer.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class StockEventListener implements ApplicationListener<StockEvent> {
    @Override
    public void onApplicationEvent(StockEvent event) {
        System.out.println("Stock received update via ApplicationListener : " + event.getStockSymbol() + " is now $" + event.getStockPrice());
    }

    @EventListener
    @Order(1)
    public void listeningToStockEvent(StockEvent event) {
        System.out.println("Stock received update Via Annotation: " + event.getStockSymbol() + " is now $" + event.getStockPrice());
    }
}
