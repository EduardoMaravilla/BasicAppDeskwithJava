package org.eduardomaravill.bankapp.views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.eduardomaravill.bankapp.controllers.admin.AdminController;
import org.eduardomaravill.bankapp.controllers.client.ClientController;
import org.kordamp.bootstrapfx.BootstrapFX;

import static org.eduardomaravill.bankapp.views.AccountTypeChoiceBoxLogin.*;

public class ViewFactory {

    private AccountTypeChoiceBoxLogin loginAccountType;
    //Client view
    private final ObjectProperty<ClientMenuOption> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionView;
    private AnchorPane accountsView;

    /*
    Clients view factory section
     */
    public ViewFactory() {
        this.loginAccountType = CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public void setLoginAccountType(AccountTypeChoiceBoxLogin loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public AccountTypeChoiceBoxLogin getLoginAccountType() {
        return loginAccountType;
    }

    public ObjectProperty<ClientMenuOption> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/client/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionView() {
        if (transactionView == null){
            try {
                transactionView = new FXMLLoader(getClass().getResource("/fxml/client/Transaction.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionView;
    }

    public AnchorPane getAccountsView(){
        if (accountsView == null){
            try {
                accountsView = new FXMLLoader(getClass().getResource("/fxml/client/Accounts.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return accountsView;
    }
    /*
    Clients view factory section
     */

    //Admin View
    private final ObjectProperty<AdminMenuOption> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositView;
     /*
    Admin view factory section
      */
    public ObjectProperty<AdminMenuOption> getAdminSelectedMenuItem(){
        return adminSelectedMenuItem;
    }

    public AnchorPane getCreateClientView() {
        if (createClientView == null){
            try {
                createClientView = new FXMLLoader(getClass().getResource("/fxml/admin/CreateClient.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return createClientView;
    }
    public AnchorPane getClientsView() {
        if (clientsView == null){
            try {
                clientsView = new FXMLLoader(getClass().getResource("/fxml/admin/Clients.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return clientsView;
    }

    public AnchorPane getDepositView() {
        if (depositView == null){
            try {
                depositView = new FXMLLoader(getClass().getResource("/fxml/admin/Deposit.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return depositView;
    }
    /*
    Admin view factory section
      */


    public void showStartWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ImageStart.fxml"));
        createStage(loader);
    }

    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        createStage(loader);
    }

    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }

    public void createStage(FXMLLoader fxmlLoader){
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Bank");
        stage.setResizable(false);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/money.jpg")));
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }


}
