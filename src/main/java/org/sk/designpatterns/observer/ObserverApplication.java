package org.sk.designpatterns.observer;

public class ObserverApplication {

    public static void main(String[] args) {
        StockClient client1 = new StockClient("Barry Allen");
        StockClient client2 = new StockClient("Suresh");
        StockClient client3 = new StockClient("Cristiano Ronaldo");

        StockTicker st1 = new StockTicker("SK");
        st1.addObservers(client1);
        st1.addObservers(client2);
        st1.addObservers(client3);

        st1.setStockPrice(10000);
        st1.removeObservers(client1);
        st1.setStockPrice(7000);

        StockTicker st2 = new StockTicker("Wayne Enterprises");
        st2.addObservers(client1);
        st2.addObservers(client2);
        st2.addObservers(client3);

        st2.setStockPrice(10000);
        st2.removeObservers(client2);
        st2.setStockPrice(7000);
    }
}
