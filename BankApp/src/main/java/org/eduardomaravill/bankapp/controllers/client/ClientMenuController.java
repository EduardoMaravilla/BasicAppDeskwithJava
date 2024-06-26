package org.eduardomaravill.bankapp.controllers.client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.eduardomaravill.bankapp.models.Model;

import java.net.URL;
import java.util.ResourceBundle;
import static org.eduardomaravill.bankapp.views.ClientMenuOption.*;

public class ClientMenuController implements Initializable {
    public Button dashboardButton;
    public Button transactionButton;
    public Button accountButton;
    public Button profileButton;
    public Button logoutButton;
    public Button reportButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
        dashboardButton.setOnAction(e->onDashboard());
        transactionButton.setOnAction(e-> onTransaction());
        accountButton.setOnAction(e-> onAccount());
    }

    private void onTransaction() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(TRANSACTIONS);
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(DASHBOARD);
    }

    private void onAccount() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ACCOUNTS);
    }
}
