package org.sk.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class PaymentStrategyApplication {

    /**
     * Strategy Pattern: To decide which strategy to follow based on the input
     *
     * @param args
     */
    public static void main(String[] args) {
        List<AccountHolder> accountHolders = new ArrayList<>();
        accountHolders.add(new AccountHolder("SK", AccountType.SAVINGS, 200));
        accountHolders.add(new AccountHolder("Suresh", AccountType.CURRENT, 5000));
        for (AccountHolder accountHolder : accountHolders) {
            PaymentProcess pp = PaymentFactory.getPaymentProcess(accountHolder.getAccountType());
            pp.autoPay(accountHolder);
        }
    }
}
