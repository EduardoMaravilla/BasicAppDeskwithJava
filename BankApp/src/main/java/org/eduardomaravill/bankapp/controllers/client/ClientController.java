package org.eduardomaravill.bankapp.controllers.client;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.eduardomaravill.bankapp.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane clientParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
             switch (newVal){
                 case TRANSACTIONS -> clientParent.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                 case ACCOUNTS -> clientParent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                 case DASHBOARD -> clientParent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
             }
        });
    }
}
