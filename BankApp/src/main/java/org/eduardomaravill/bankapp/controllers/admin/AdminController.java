package org.eduardomaravill.bankapp.controllers.admin;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.eduardomaravill.bankapp.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    public BorderPane adminParent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observable,oldValue,newValue) -> {
            switch (newValue) {
                case CREATE_CLIENT -> adminParent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
                case CLIENTS -> adminParent.setCenter(Model.getInstance().getViewFactory().getClientsView());
                case DEPOSIT -> adminParent.setCenter(Model.getInstance().getViewFactory().getDepositView());
            }
        });
    }
}
