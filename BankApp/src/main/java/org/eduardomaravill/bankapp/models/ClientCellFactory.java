package org.eduardomaravill.bankapp.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.eduardomaravill.bankapp.controllers.admin.ClientCellController;

public class ClientCellFactory extends ListCell<Client> {

    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if (empty || client == null) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin/ClientCell.fxml"));
            ClientCellController clientCellController = new ClientCellController(client);
            loader.setController(clientCellController);
            setText(null);
            try {
                setGraphic(loader.load());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
