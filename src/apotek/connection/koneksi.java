/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public class koneksi {
    public Connection con;
    public ResultSet rs;
    public Statement st;
    public void db(){
        String id, pass, url, driver;
        id="root";
        pass="";
        url="jdbc:mysql://localhost/apotek";
        driver="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,id,pass);
            st=con.createStatement();
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Check koneksi");
//            alert.setHeaderText(null);
//            alert.setContentText("Koneksi OK");
//            alert.showAndWait();
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
