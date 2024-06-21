package org.sk.designpatterns.strategy;

public class PaymentFactory {

    private PaymentFactory() {
    }

    public static PaymentProcess getPaymentProcess(AccountType payment) {
        if (AccountType.SAVINGS.equals(payment)) {
            return new DebitCardPayment();
        } else if (AccountType.CURRENT.equals(payment)) {
            return new CreditCardPayment();
        }
        return null;
    }
}
