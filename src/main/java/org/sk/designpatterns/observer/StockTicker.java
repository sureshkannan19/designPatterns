package org.sk.designpatterns.observer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StockTicker {

    private final Set<StockObserver> observers;
    private String stockSymbol;
    private double stockPrice;

    public StockTicker(String stockSymbol) {
        this.observers = new HashSet<>();
        this.stockSymbol = stockSymbol;
    }

    public void addObservers(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObservers(StockObserver observer) {
        observers.remove(observer);
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockObserver so : observers) {
            so.updateStockPrice(stockSymbol, stockPrice);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockTicker that = (StockTicker) o;
        return Objects.equals(stockSymbol, that.stockSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockSymbol);
    }

}
