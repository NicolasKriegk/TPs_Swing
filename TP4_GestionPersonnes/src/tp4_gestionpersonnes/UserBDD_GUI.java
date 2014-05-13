/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4_gestionpersonnes;

import java.text.SimpleDateFormat;
import model.Person;
import model.PersonGUI;

/**
 *
 * @author imie
 */
public class UserBDD_GUI {
    private SimpleDateFormat sdf;
    
    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat){
        this.sdf = simpleDateFormat;
    }
    
    public PersonGUI UserBDDToGUI(Person userGUI){
        PersonGUI personGUI = new PersonGUI();
        personGUI.setName(userGUI.getName());
        personGUI.setFirstname(userGUI.getFirstname());
//        personGUI.setBirthDate(userGUI.getBirthDate());
        personGUI.setCursus(userGUI.getCursus());
        return personGUI;
    }
    
    
    
}
