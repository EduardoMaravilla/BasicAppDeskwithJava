package org.eduardomaravill.bankapp.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.eduardomaravill.bankapp.controllers.client.TransactionCellController;

public class TransactionCellFactory extends ListCell<Transaction> {
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if (empty || transaction == null) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/client/TransactionCell.fxml"));
            TransactionCellController transactionCell=new TransactionCellController(transaction);
            loader.setController(transactionCell);
            setText(null);
            try {
                setGraphic(loader.load());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
