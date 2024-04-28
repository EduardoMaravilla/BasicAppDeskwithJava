package org.eduardomaravill.bankapp.controllers.admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public TextField firstNameClient;
    public TextField lastNameClient;
    public TextField passwordClient;
    public CheckBox payeeAddressCheckBox;
    public Label payeeAddressLabel;
    public CheckBox addCheckingAccountCheckBox;
    public TextField checkingAccountBalance;
    public CheckBox addSavingsAccountCheckBox;
    public TextField savingsAccountBalance;
    public Button createNewClientButton;
    public Text textError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
