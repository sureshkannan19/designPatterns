package org.sk.designpatterns.strategy;

public class DebitCardPayment extends PaymentProcess {

    @Override
    public void autoPay(AccountHolder accountHolder) {
        System.out.println(amount + " INR payed via " + paymentType() + " successfully.");
    }

    @Override
    public PaymentType paymentType() {
        return PaymentType.DEBIT_CARD;
    }

}
