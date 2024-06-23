package org.sk.designpatterns.observer;

public class StockClient implements StockObserver {
    private final String clientName;

    public StockClient(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void updateStockPrice(String stockSymbol, double stockPrice) {
        System.out.println("Client " + clientName + " received update: " + stockSymbol + " is now $" + stockPrice);
    }
}
