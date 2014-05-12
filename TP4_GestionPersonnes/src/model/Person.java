/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author imie
 */
public class Person {
    
    private String name;
    private String firstname;
    
    private Date birthDate;
    private String cursus;
    
    public Person(String name){
        this.name = name;
    }
    
    public Person(String name, String firstname){
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
    
    public Date getBirthDate(){
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
    
    public String getCursus(){
        return this.cursus;
    }
    
    public void setCursus(String cursus){
        this.cursus = cursus;
    }
    
}
