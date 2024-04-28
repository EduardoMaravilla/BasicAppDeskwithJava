package org.eduardomaravill.bankapp.controllers.admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.eduardomaravill.bankapp.models.Model;
import static org.eduardomaravill.bankapp.views.AdminMenuOption.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button createClientButton;
    public Button clientsButton;
    public Button depositButton;
    public Button logoutButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       addListeners();
    }

    private void addListeners() {
        createClientButton.setOnAction(e->onCreateClient());
        clientsButton.setOnAction(e->onClients());
        depositButton.setOnAction(e->onDeposit());
    }

    private void onDeposit() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(DEPOSIT);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(CLIENTS);
    }

    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(CREATE_CLIENT);
    }
}
