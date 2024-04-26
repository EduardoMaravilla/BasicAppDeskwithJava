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
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, newVal, oldVal) -> {
             switch (oldVal){
                 case "Transactions" -> clientParent.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                 case "Accounts" -> clientParent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                 default -> clientParent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
             }
        });
    }
}
