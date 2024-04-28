package org.eduardomaravill.bankapp.models;

import javafx.beans.property.*;

public abstract class Account {

    private final StringProperty owner;
    private final StringProperty accountNumber;
    private final DoubleProperty balance;

    public Account(String owner, String accountNumber, Double balance) {
        this.owner = new SimpleStringProperty(this,"owner",owner);
        this.accountNumber = new SimpleStringProperty(this,"Account Number",accountNumber);
        this.balance = new SimpleDoubleProperty(this,"Balance",balance);
    }

    public String getOwner() {
        return owner.get();
    }

    public StringProperty ownerProperty() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public StringProperty accountNumberProperty() {
        return accountNumber;
    }

    public double getBalance() {
        return balance.get();
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }
}
