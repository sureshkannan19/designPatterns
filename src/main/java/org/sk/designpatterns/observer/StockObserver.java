package org.sk.designpatterns.observer;

public interface StockObserver {

    void updateStockPrice(String stockSymbol, double stockPrice);

}
