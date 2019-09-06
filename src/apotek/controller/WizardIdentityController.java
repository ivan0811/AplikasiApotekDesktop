/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.controller;

import apotek.function.navigation;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WizardIdentityController implements Initializable {

    /**
     * Initializes the controller class.
     */
    FXMLLoader loader = new FXMLLoader();
    navigation nav = new navigation();
    @FXML private ImageView logo = new ImageView();
    private MainController main;
    @FXML private AnchorPane wizardIdentity;
    @FXML
    private Pane uploadImage;
    @FXML
    private ImageView pill1;
    @FXML
    private ImageView pill11;
    @FXML
    private ImageView pill111;
    
//    @FXML public void handleAddIdentitiy(ActionEvent e) throws IOException{
//        wizardIdentity.getChildren().clear();
//        AnchorPane pane = loader.load(getClass().getResource(nav.getWizardFinish()));
//        wizardIdentity.getChildren().setAll(pane);
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML public void dragIdentityOver(DragEvent event){
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.ANY);            
        }        
    }    
        
    @FXML public void handleDropIdentity(DragEvent event) throws FileNotFoundException, IOException{
        List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));  
        FileChooser filec = new FileChooser();        
        logo.setFitHeight(170);        
        logo.setFitWidth(170);       
        JOptionPane.showMessageDialog(null, );
        logo.setImage(img);        
        logo.setOpacity(1);
        logo.toFront();         
    }
    
    public void init(MainController mainController) {
        main = mainController;
    }
    
}
