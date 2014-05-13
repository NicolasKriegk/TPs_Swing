/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author imie
 */
public class PersonGUI {
    
    private String name;
    private String firstname;
    
    private String birthDate;
    private String cursus;
    private String[] fields;
    
    public PersonGUI(){
    }
    
    public PersonGUI(String name){
        this.name = name;
    }
    
    public PersonGUI(String name, String firstname){
        this.firstname = name;
        this.firstname = firstname;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getBirthDate(){
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    
    public String getCursus(){
        return this.cursus;
    }
    
    public void setCursus(String cursus){
        this.cursus = cursus;
    }
    
}
