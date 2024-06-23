package org.sk.designpatterns.strategy;

public class CreditCardPayment extends PaymentProcess {

    @Override
    public void autoPay(AccountHolder accountHolder) {
        System.out.println(amount + " INR payed via " + paymentType() + " successfully.");
    }

    @Override
    public PaymentType paymentType() {
        return PaymentType.CREDIT_CARD;
    }
}
