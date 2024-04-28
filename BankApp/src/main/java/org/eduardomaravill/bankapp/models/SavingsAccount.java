package org.eduardomaravill.bankapp.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account{
    //The withdrawal limit from the savings
    private final DoubleProperty withdrawalLimit ;

    public SavingsAccount(String owner, String accountNumber, Double balance, double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this,"Withdrawal Limit",withdrawalLimit);
    }
}
