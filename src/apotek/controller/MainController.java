/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author User
 */
public class MainController {
    @FXML wizardController wizardController;
    @FXML WizardIdentityController wizardIdentity;
    @FXML WizardFinishController wizardFinish;
    @FXML WizardUsersController wizardUsers;
    @FXML WizardAdminController wizardAdmin;
    private static String AdminName;
    private static String AdminNoHP;
    private static String AdminJK;
    private static String AdminAddress;
    private static String AdminDate;
    private static String Username;
    private static String Password;    
    @FXML public void initialize(){
        wizardController.init(this);
        wizardIdentity.init(this);
        wizardFinish.init(this);
        wizardUsers.init(this);
        wizardAdmin.init(this);
    }        
    public static String getTextAdminAddress(){
        return AdminAddress;
    }
    public static String getTextAdminName(){
        return AdminName;
    }
    public static String getTextAdminNoHP(){
        return AdminNoHP;
    }
    public static String getJKAdmin(){
        return AdminJK;
    }
    public static String getDateAdmin(){
        return AdminDate;
    }    
    public static void setTextAdminNoHP(String admin_no_hp){
        AdminNoHP = admin_no_hp;
    }
    public static void setJKAdmin(String admin_jk){
        AdminJK = admin_jk;
    }
    public static void setTextAdminName(String admin_name){
        AdminName = admin_name;
    }
    public static void setTextAdminAddress(String admin_address){
        AdminAddress = admin_address;
    }
    public static void setTextAdminDate(String admin_date){
        AdminDate = admin_date;
    }    
    public static String getTextUsername(){
        return Username;
    }
    public static void setTextUsername(String username){
        Username = username;
    }
    public static String getTextPassword(){
        return Password;
    }
    public static void setTextPassword(String password){
        Password = password;
    }
}
