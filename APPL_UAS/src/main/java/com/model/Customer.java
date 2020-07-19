package com.model;

/**
 *
 * @author Evan
 */
public class Customer {
    private String name;
    private String gender;
    private String contact;
    
    public Customer(){
        this.name = "";
        this.gender = "";
        this.contact = "";
    }
    
    public Customer(String name, String gender, String contact){
        this.name = name;
        this.gender = gender;
        this.contact = contact;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
