package org.eduardomaravill.bankapp;

import javafx.application.Application;
import javafx.stage.Stage;
import org.eduardomaravill.bankapp.models.Model;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().showStartWindow();
    }
}
