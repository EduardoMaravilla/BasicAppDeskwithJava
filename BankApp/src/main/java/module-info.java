module org.eduardomaravill.bankapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.postgresql.jdbc;
    requires de.jensd.fx.glyphs.fontawesome;

    opens org.eduardomaravill.bankapp to javafx.fxml;
    exports org.eduardomaravill.bankapp;
    exports org.eduardomaravill.bankapp.controllers;
    exports org.eduardomaravill.bankapp.controllers.admin;
    exports org.eduardomaravill.bankapp.controllers.client;
    exports org.eduardomaravill.bankapp.controllers.client.dashboard;
    exports org.eduardomaravill.bankapp.controllers.transaction;
    exports org.eduardomaravill.bankapp.controllers.client.acounts;
    exports org.eduardomaravill.bankapp.models;
    exports org.eduardomaravill.bankapp.views;
}