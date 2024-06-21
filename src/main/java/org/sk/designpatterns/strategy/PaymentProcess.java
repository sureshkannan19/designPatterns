package org.sk.designpatterns.strategy;

public abstract class PaymentProcess {

    public final double amount = 200;

    abstract public void autoPay(AccountHolder accountHolder);

    abstract public PaymentType paymentType();

}
