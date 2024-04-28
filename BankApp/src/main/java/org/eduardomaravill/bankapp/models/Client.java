package org.eduardomaravill.bankapp.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingsAccount;
    private final ObjectProperty<LocalDate> dateCreated;

    public Client(String firstName, String lastName, String payeeAddress, Account checkingAccount, Account savingsAccount, LocalDate dateCreated) {
        this.firstName = new SimpleStringProperty(this, "FirstName", firstName);
        this.lastName = new SimpleStringProperty(this, "LastName", lastName);
        this.payeeAddress = new SimpleStringProperty(this, "PayeeAddress", payeeAddress);
        this.checkingAccount = new SimpleObjectProperty<>(this, "CheckingAccount", checkingAccount);
        this.savingsAccount = new SimpleObjectProperty<>(this, "SavingsAccount", savingsAccount);
        this.dateCreated = new SimpleObjectProperty<>(this, "DateCreated", dateCreated);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getPayeeAddress() {
        return payeeAddress.get();
    }

    public StringProperty payeeAddressProperty() {
        return payeeAddress;
    }

    public Account getCheckingAccount() {
        return checkingAccount.get();
    }

    public ObjectProperty<Account> checkingAccountProperty() {
        return checkingAccount;
    }

    public Account getSavingsAccount() {
        return savingsAccount.get();
    }

    public ObjectProperty<Account> savingsAccountProperty() {
        return savingsAccount;
    }

    public LocalDate getDateCreated() {
        return dateCreated.get();
    }

    public ObjectProperty<LocalDate> dateCreatedProperty() {
        return dateCreated;
    }
}
