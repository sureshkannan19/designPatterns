package org.sk.designpatterns.strategy;

public class CreditCardPayment extends PaymentProcess {

    @Override
    public void autoPay(AccountHolder accountHolder) {
        if (amount <= accountHolder.getBalance()) {
            accountHolder.setBalance(accountHolder.getBalance() - amount);
            System.out.println(amount + " INR payed via " + paymentType() + " successfully.");
        } else {
            System.out.println(" Insufficient balance");
        }
        System.out.println("Remaining balance: " + accountHolder.getBalance());
    }

    @Override
    public PaymentType paymentType() {
        return PaymentType.CREDIT_CARD;
    }
}
