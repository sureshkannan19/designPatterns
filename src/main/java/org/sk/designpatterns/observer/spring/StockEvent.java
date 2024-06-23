package org.sk.designpatterns.observer.spring;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class StockEvent extends ApplicationEvent {

    private final String stockSymbol;

    private final double stockPrice;

    public StockEvent(Object source, String stockSymbol, double stockPrice) {
        super(source);
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
    }


}
