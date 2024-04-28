package org.eduardomaravill.bankapp.controllers.admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositController implements Initializable {
    public TextField payeeAddressText;
    public Button buttonSearchPayeeAddress;
    public ListView listViewDeposit;
    public TextField amountDeposit;
    public Button buttonDepositAmount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
