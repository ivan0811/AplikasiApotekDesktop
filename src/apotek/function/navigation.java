/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.function;

/**
 *
 * @author User
 */
public class navigation {
    private String started = "/apotek/view/wizard.fxml";
    private String wizardAdmin = "/apotek/view/wizardAdmin.fxml";
    private String wizardUsers = "/apotek/view/wizardUsers.fxml";
    private String wizardIdentity = "/apotek/view/wizardIdentity.fxml";
    private String wizardFinish = "/apotek/view/wizardFinish.fxml";
    public String getStarted(){
        return started;
    }
    public String getWizardAdmin(){
        return wizardAdmin;
    }
    public String getWizardUsers(){
        return wizardUsers;
    }
    public String getWizardFinish(){
        return wizardFinish;
    }
    public String getWizardIdentity(){
        return wizardIdentity;
    }
}
