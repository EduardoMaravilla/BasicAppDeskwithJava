package org.eduardomaravill.bankapp.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.eduardomaravill.bankapp.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    public Button initializeAppBank;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeAppBank.setOnAction(e->onInitializeAppBank());
    }

    private void onInitializeAppBank(){
        Stage stage = (Stage) initializeAppBank.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
