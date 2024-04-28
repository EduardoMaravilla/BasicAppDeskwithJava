package org.eduardomaravill.bankapp.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account{
    //The number of transactions a client is allowed to do per day
    private final IntegerProperty transactionLimit;

    public CheckingAccount(String owner, String accountNumber, Double balance, int transactionLimit) {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this,"TransactionLimit",transactionLimit);
    }

    public int getTransactionLimit() {
        return transactionLimit.get();
    }

    public IntegerProperty transactionLimitProperty() {
        return transactionLimit;
    }
}
