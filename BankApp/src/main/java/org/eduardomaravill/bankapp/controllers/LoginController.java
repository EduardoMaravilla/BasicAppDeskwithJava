package org.eduardomaravill.bankapp.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.eduardomaravill.bankapp.models.Model;
import org.eduardomaravill.bankapp.views.AccountTypeChoiceBoxLogin;

import java.net.URL;
import java.util.ResourceBundle;

import static org.eduardomaravill.bankapp.views.AccountTypeChoiceBoxLogin.*;

public class LoginController implements Initializable {
    public ChoiceBox<AccountTypeChoiceBoxLogin> selectTypeAccount;
    public TextField textUsername;
    public TextField textPassword;
    public Button buttonLogin;
    public Text errorLoginText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectTypeAccount.setItems(FXCollections.observableArrayList(ADMIN,CLIENT));
        selectTypeAccount.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        selectTypeAccount.valueProperty().addListener(o-> Model.getInstance().getViewFactory().setLoginAccountType(selectTypeAccount.getValue()));
        buttonLogin.setOnAction(e-> onButtonLogin());
    }

    private void onButtonLogin(){
        Stage stage = (Stage) errorLoginText.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        switch (Model.getInstance().getViewFactory().getLoginAccountType()){
            case CLIENT -> Model.getInstance().getViewFactory().showClientWindow();
            case ADMIN -> Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}
