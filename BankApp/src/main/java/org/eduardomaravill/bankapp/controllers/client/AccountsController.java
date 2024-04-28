package org.eduardomaravill.bankapp.controllers.client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsController implements Initializable {
    public Label checkingAccountNumber;
    public Label checkingTransactionLimit;
    public Label checkingAccountDateCreate;
    public Label checkingAccountBalance;
    public Label savingsAccountNumber;
    public Label savingsWithdrawalLimit;
    public Label savingsAccountDateCreate;
    public Label savingsAccountBalance;
    public TextField fundsToSavingsAccount;
    public Button buttonTransferToSavingsAccount;
    public TextField fundsToCheckingAccount;
    public Button buttonTransferToCheckingAccount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
