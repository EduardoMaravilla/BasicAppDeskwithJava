package org.eduardomaravill.bankapp.controllers.client.dashboard;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text username;
    public Label clientDate;
    public Label checkingAccount;
    public Label checkingAccountNumber;
    public Label savingsAccount;
    public Label savingsAccountNumber;
    public Label summaryIncome;
    public Label summaryExpenses;
    public ListView transactionListView;
    public TextField payeeAddres;
    public TextField amountSend;
    public TextArea messageSend;
    public Button buttonSendMoney;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
