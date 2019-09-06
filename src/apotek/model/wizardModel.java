/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.model;

import apotek.connection.koneksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class wizardModel {
    koneksi k = new koneksi();
    private String showWizardAdmin = "select * from karyawan where kd_karyawan = 'kry0001'";
    private String showWizardUsers = "select * from users where kd_karyawan = 'kry0001'";
    private String showWizardIdentity = "select * from identitas";
    public String getWizardAdmin(){        
        return showWizardAdmin;
    }
    public void storeWizardAdmin(String nama,String alamat,String jk,String no_hp,String tgl_lahir){
        try{
            k.db();
            k.st.execute("insert into karyawan values('kry0001','"+nama+"','"
            +alamat+"','"+jk+"','"+no_hp+"','"+tgl_lahir+"')");
        }catch(Exception e){
            
        }
    }
    public void updateWizardAdmin(String nama,String alamat,String jk,String no_hp,String tgl_lahir){
        try{
            k.db();
            k.st.executeUpdate("update karyawan set nama='"+nama+"', alamat='"+alamat+"', jk='"+jk
            +"', no_hp='"+no_hp+"', tgl_lahir='"+tgl_lahir+"' where kd_karyawan='kry0001'");
        }catch(Exception e){
            
        }
    }
    public String getWizardUsers(){
        return showWizardUsers;
    }
    public void storeWizardUsers(String username, String password){
        try{
            k.db();
            k.st.execute("insert into users "
            +"(`id_user`, `kd_karyawan`, `role`, `username`, `password`, `status`) "
            +"values (NULL, 'kry0001', 'admin', '"+username+"', '"+password+"', 'login')");
        }catch(Exception e){
            
        }
    }
    public void updateWizardUsers(String username, String password){
        try{
            k.db();
            k.st.executeUpdate("update users set username='"+username+"', password='"+password+"'"
            +" where kd_karyawan='kry0001'");
        }catch(Exception e){            
        }
    }
    public String getWizardIdentity(){
        return showWizardIdentity;
    }
    public void storeWizardIdentity(String logo, String nama, String alamat){
        try{
            k.db();
            k.st.execute("insert into identitas "
            +"('id_identitas', 'logo_apotek', 'nama_apotek', 'alamat_apotek')"
            +"(NULL,'"+logo+"','"+nama+"','"+alamat+"')");
        }catch(Exception e){
            
        }
    }
    public void updateWizardIdentity(String id,String logo, String nama, String alamat){
        try{
            k.db();
            k.st.executeUpdate("update identitas set logo_apotek='"+logo+"',"
            +" nama_apotek='"+nama+"', alamat_apotek='"+alamat+"' where id_identitas='"+id+"'");
        }catch(Exception e){
            
        }
    }
}
