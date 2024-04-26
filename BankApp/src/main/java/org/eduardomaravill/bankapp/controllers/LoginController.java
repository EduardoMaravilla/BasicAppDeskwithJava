package org.eduardomaravill.bankapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.eduardomaravill.bankapp.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox selectTypeAccount;
    public TextField textUsername;
    public TextField textPassword;
    public Button buttonLogin;
    public Text errorLoginText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonLogin.setOnAction(e-> onButtonLogin());
    }

    private void onButtonLogin(){
        Stage stage = (Stage) errorLoginText.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showClientWindow();
    }
}
