/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.function;

import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public class alert {
    public void ShowAlert(Alert.AlertType type, String title, String header, String text){
        Alert show = new Alert(type);
        show.setTitle(title);
        show.setHeaderText(header);
        show.setContentText(text);
        show.showAndWait();
    }
}
