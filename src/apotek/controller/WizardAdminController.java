/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.controller;

import apotek.connection.koneksi;
import apotek.function.datePickerChange;
import apotek.function.navigation;
import apotek.model.wizardModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WizardAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    koneksi k = new koneksi();
    wizardModel model = new wizardModel();
    FXMLLoader loader = new FXMLLoader();
    navigation nav = new navigation();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private MainController main;
    @FXML private AnchorPane wizardAdmin;
    @FXML private Button btn_next;
    @FXML private TextField nama_admin, no_negara, no_hp_admin;
    @FXML private RadioButton jk_l, jk_p;
    @FXML private DatePicker tgl_lahir;
    @FXML private TextArea alamat_admin;    
    @FXML private Label label1;
    @FXML private void handleAddAdmin(ActionEvent e) throws IOException{        
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource(nav.getStarted()));                           
        Parent root = loader2.load();
        wizardController controller = loader2.getController();               
        controller.setStepUsers(new Image("/apotek/img/checked_26px.png"), Color.WHITE);        
        wizardAdmin.getChildren().clear();
        AnchorPane pane = loader.load(getClass().getResource(nav.getWizardUsers()));
        wizardAdmin.getChildren().add(pane);                               
    }     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO                 
        try {
            k.db();
            k.rs=k.st.executeQuery(model.getWizardAdmin());
            if(k.rs.next()){
                nama_admin.setText(k.rs.getString("nama"));                
                main.setTextAdminName(k.rs.getString("nama"));                        
                no_hp_admin.setText(k.rs.getString("no_hp"));
                main.setTextAdminNoHP(k.rs.getString("no_hp"));     
                alamat_admin.setText("alamat");
                main.setTextAdminAddress(k.rs.getString("alamat"));                
                if(k.rs.getString("jk").equals("L")){
                    jk_l.setSelected(true);                    
                }else if(k.rs.getString("jk").equals("P")){
                    jk_p.setSelected(true);
                }
                main.setJKAdmin(k.rs.getString("jk"));
                tgl_lahir.setValue(k.rs.getDate("tgl_lahir").toLocalDate());
                main.setTextAdminDate(k.rs.getString("tgl_lahir"));
            }else{
                nama_admin.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(WizardAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    
    @FXML private void handleGenderMale(ActionEvent e){
        jk_l.setSelected(true);
        jk_p.setSelected(false);
        main.setJKAdmin(null);
        main.setJKAdmin("L");
    }
    @FXML private void handleGenderfemale(ActionEvent e){
        jk_p.setSelected(true);
        jk_l.setSelected(false);
        main.setJKAdmin(null);
        main.setJKAdmin("P");        
    }
    public void StoreAdmin(){       
       JOptionPane.showMessageDialog(null, label1.getText());       
    }
    @FXML private void handleStoreName(KeyEvent e){     
        if(nama_admin.getText().isEmpty()){
            main.setTextAdminName(null);                        
        }
        else{
            main.setTextAdminName(nama_admin.getText());                        
        }            
    }
    @FXML private void handleStoreNoHP(KeyEvent e){
        if(no_hp_admin.getText().isEmpty()){
            main.setTextAdminNoHP(null);     
        }else{
            main.setTextAdminNoHP(no_hp_admin.getText());       
        }
    }
        @FXML private void handleStoreAddress(KeyEvent e){
        if(alamat_admin.getText().isEmpty()){
            main.setTextAdminAddress(null);                
        }else{
            main.setTextAdminAddress(alamat_admin.getText());                
        }
    }
    @FXML private void handleDate(ActionEvent e){
        String getConvertDate = sdf.format(Date.valueOf(tgl_lahir.getValue()));
        if(tgl_lahir.getValue() == null){
           main.setTextAdminDate(null);
        }else{
           main.setTextAdminDate(getConvertDate);
        }        
    }
    public void init(MainController mainController) {
        main = mainController;
    }            
    public TextField getNamaAdmin(){
        return nama_admin;
    }
    public TextField getNoHP(){
        return no_hp_admin;
    }
    public TextArea getAddress(){
        return alamat_admin;
    }
    public RadioButton getJKL(){
        return jk_l;
    }    
    public RadioButton getJKP(){
        return jk_p;
    }
    public DatePicker getDatePicker(){
        return tgl_lahir;
    }
}
