/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.controller;

import apotek.connection.koneksi;
import apotek.function.alert;
import apotek.function.navigation;
import apotek.model.wizardModel;
import java.awt.Panel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class wizardController implements Initializable {
    
    FXMLLoader loader;    
    navigation nav = new navigation();    
    Image checked;                 
    Label label;    
    alert alert = new alert();
    wizardModel model = new wizardModel();
    koneksi k = new koneksi();
    private MainController main;        
    @FXML private ImageView step2, step3, step4, step5;    
    @FXML public AnchorPane getStarted, wizardUsers, wizardAdmin, wizardIdentity, wizardMain;        
    @FXML private StackPane NavPane;
    @FXML private Label stepAdmin, stepIdentity, stepFinish, stepUsers;    
    @FXML private Button btn_next, btn_back;
    @FXML WizardAdminController adminController;
    Object step[] = {0,0,0,0,0};
    public wizardController() {
        this.loader = new FXMLLoader(getClass().getResource(nav.getStarted()));
    }    
    @FXML public void handleNext(ActionEvent e) throws IOException{
        if(step[0].equals(1)){                                                                    
            if(main.getTextAdminName() == null || main.getTextAdminNoHP() == null
                            || main.getDateAdmin() == null || main.getTextAdminAddress() == null
                            || main.getJKAdmin() == null){
                        alert.ShowAlert(Alert.AlertType.ERROR, "Peringatan!", null, "Data tidak boleh kosong");
            }else{
                try {
                    k.db();
                    k.rs=k.st.executeQuery(model.getWizardAdmin());
                    if(k.rs.next()){                                          
                        model.updateWizardAdmin(main.getTextAdminName(), 
                                main.getTextAdminAddress(),
                                main.getJKAdmin(), 
                                main.getTextAdminNoHP(),
                                main.getDateAdmin());
                        AdminNext();
                    }else{                    
                        model.storeWizardAdmin(main.getTextAdminName(), 
                                main.getTextAdminAddress(),
                                main.getJKAdmin(), 
                                main.getTextAdminNoHP(),
                                main.getDateAdmin());
                        AdminNext();                                               
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(wizardController.class.getName()).log(Level.SEVERE, null, ex);
                }                                                       
            }            
        }else if(step[1].equals(1)){
            if(main.getTextUsername() == null || main.getTextPassword() == null){
                alert.ShowAlert(Alert.AlertType.ERROR, "Peringatan", null, "Data tidak boleh kosong");
            }else{                
                try {
                    k.db();
                    k.rs=k.st.executeQuery(model.getWizardUsers());
                    if(k.rs.next()){
                        model.updateWizardUsers(main.getTextUsername(), main.getTextPassword());
                        UsersNext();
                    }else{
                        model.storeWizardUsers(main.getTextUsername(), main.getTextPassword());
                        UsersNext();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(wizardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if(step[2].equals(1)){            
            getStarted.getChildren().clear();
            AnchorPane pane = loader.load(getClass().getResource(nav.getWizardFinish()));
            getStarted.getChildren().setAll(pane);
            stepFinish.setTextFill(Color.WHITE);
            step5.setImage(new Image("/apotek/img/checked_26px.png"));    
            NavPane.setOpacity(1);                
            NavPane.toFront();    
            step[3] = 1;        
            step[2] = 0;
            btn_next.setText("Selesai");
        }else if(step[3].equals(1)){
            step[3] = 0;
        }
    }
    @FXML public void handleBack(ActionEvent e) throws IOException{
        if(step[3].equals(1)){
            getStarted.getChildren().clear();
            AnchorPane pane = loader.load(getClass().getResource(nav.getWizardIdentity()));
            getStarted.getChildren().setAll(pane);
            stepFinish.setTextFill(Color.web("#3d6b9c"));
            step5.setImage(new Image("/apotek/img/unchecked_circle_30px.png"));    
            NavPane.setOpacity(1);                
            NavPane.toFront();    
            step[2] = 1;
            step[3] = 0;
        }else if(step[2].equals(1)){
            getStarted.getChildren().clear();
            AnchorPane pane = loader.load(getClass().getResource(nav.getWizardUsers()));
            getStarted.getChildren().setAll(pane);
            stepIdentity.setTextFill(Color.web("#3d6b9c"));
            step4.setImage(new Image("/apotek/img/unchecked_circle_30px.png"));    
            NavPane.setOpacity(1);                
            NavPane.toFront();    
            step[2] = 0;        
            step[1] = 1;
        }else if(step[1].equals(1)){
            getStarted.getChildren().clear();
            AnchorPane pane = loader.load(getClass().getResource(nav.getWizardAdmin()));
            getStarted.getChildren().setAll(pane);
            stepUsers.setTextFill(Color.web("#3d6b9c"));
            step3.setImage(new Image("/apotek/img/unchecked_circle_30px.png"));    
            NavPane.setOpacity(1);                
            NavPane.toFront();    
            step[1] = 0;        
            step[0] = 1;
            btn_back.setVisible(false);
        }
    }
    @FXML public void handleStarted(ActionEvent e) throws IOException{                        
        getStarted.getChildren().clear();
        AnchorPane pane = loader.load(getClass().getResource(nav.getWizardAdmin()));
        getStarted.getChildren().setAll(pane);               
        stepAdmin.setTextFill(Color.WHITE);
        step2.setImage(new Image("/apotek/img/checked_26px.png"));    
        NavPane.setOpacity(1);                
        NavPane.toFront();    
        step[0] = 1;
        btn_back.setVisible(false); 
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {                                  
          
    }               
    public void setStepUsers(Image image, Color color) throws IOException{
        step3.setImage(image);
        stepUsers.setTextFill(color);
    }    
    
    public void init(MainController mainController) {
        main = mainController;
    }
    private void AdminNext() throws IOException{
        getStarted.getChildren().clear();
        AnchorPane pane = loader.load(getClass().getResource(nav.getWizardUsers()));
        getStarted.getChildren().setAll(pane);
        stepUsers.setTextFill(Color.WHITE);
        step3.setImage(new Image("/apotek/img/checked_26px.png"));    
        NavPane.setOpacity(1);                
        NavPane.toFront();    
        step[1] = 1;
        step[0] = 0;
        btn_back.setVisible(true);
    }
    private void UsersNext() throws IOException{
        getStarted.getChildren().clear();
            AnchorPane pane = loader.load(getClass().getResource(nav.getWizardIdentity()));
            getStarted.getChildren().setAll(pane);
            stepIdentity.setTextFill(Color.WHITE);
            step4.setImage(new Image("/apotek/img/checked_26px.png"));    
            NavPane.setOpacity(1);                
            NavPane.toFront();    
            step[2] = 1;        
            step[1] = 0;
    }
}
