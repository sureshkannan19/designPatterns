package org.sk.designpatterns.proxy;

public class ProxyApplication {

    public static void main(String[] args) {
        DatabaseProxyService proxy = new DatabaseProxyService();
        proxy.connect("Suresh", "12345");
        proxy.connect("Suresh", "Suresh");
        proxy.connect("Barry", "Barry");
        proxy.connect("Bruce", "Wayne");
    }
}
