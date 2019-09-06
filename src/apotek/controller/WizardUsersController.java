/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.controller;

import apotek.connection.koneksi;
import apotek.function.navigation;
import apotek.model.wizardModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WizardUsersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    navigation nav = new navigation();
    FXMLLoader loader = new FXMLLoader();
    koneksi k = new koneksi();
    wizardModel model = new wizardModel();
    private MainController main;
    @FXML private AnchorPane wizardUsers;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private void handleAddUsers(ActionEvent e) throws IOException{
        wizardUsers.getChildren().clear();
        AnchorPane pane = loader.load(getClass().getResource(nav.getWizardIdentity()));
        wizardUsers.getChildren().setAll(pane);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        try {
            k.db();
            k.rs=k.st.executeQuery(model.getWizardUsers());
            if(k.rs.next()){
                username.setText(k.rs.getString("username"));
                main.setTextUsername(k.rs.getString("username"));
                password.setText(k.rs.getString("password"));
                main.setTextPassword(k.rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(WizardUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }                    
    }    
    public void init(MainController mainController) {
        main = mainController;
    }
    @FXML private void handleTextUsername(KeyEvent event){
        if(username.getText().isEmpty()){
           main.setTextUsername(null); 
        }else{
           main.setTextUsername(username.getText());
        }        
    }
    @FXML private void handleTextPassword(KeyEvent event){
        if(password.getText().isEmpty()){
            main.setTextPassword(null);
        }else{
            main.setTextPassword(password.getText());
        }
    }
}
