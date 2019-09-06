/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apotek.function;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class datePickerChange {
    public String getDateQuery(){
        Date tgl = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return(sdf.format(tgl));
    }
}
