/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WizardFinishController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private MainController main;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void init(MainController mainController) {
        main = mainController;
    }
    
}
