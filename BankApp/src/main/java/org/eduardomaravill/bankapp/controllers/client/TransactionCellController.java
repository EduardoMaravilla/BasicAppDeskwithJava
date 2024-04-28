package org.eduardomaravill.bankapp.controllers.client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.eduardomaravill.bankapp.models.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public Label dateTransaction;
    public Label sender;
    public Label receiver;
    public Label amount;
    public FontAwesomeIconView inIco;
    public FontAwesomeIconView outIco;

    private final Transaction transaction;

    public TransactionCellController(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
