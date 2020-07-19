package com.utility;


import com.model.Customer;
import com.model.Doubleroom;
import com.model.Singleroom;
import java.awt.SecondaryLoop;
import java.io.Serializable;

public class Holder implements Serializable
{   
    private Doubleroom luxury_doubleroom[];
    private Doubleroom deluxe_doubleroom[];
    private Singleroom luxury_singleroom[];
    private Singleroom deluxe_singleroom[];
    
    public Holder(){
        luxury_doubleroom = new Doubleroom[10]; //Luxury
        deluxe_doubleroom = new Doubleroom[20]; //Deluxe
        luxury_singleroom = new Singleroom[10]; //Luxury
        deluxe_singleroom = new Singleroom[20]; //Deluxe
    }
    
    public void addCustomerToLuxuryDoubleroom(int roomNumber, Customer customer, Customer secondCustomer){
        luxury_doubleroom[roomNumber] = new Doubleroom(customer, secondCustomer);
    }
    
    public void addCustomerToDeluxeDoubleroom(int roomNumber, Customer customer, Customer secondCustomer){
        deluxe_doubleroom[roomNumber] = new Doubleroom(customer, secondCustomer);
    }
        
    public void addCustomerToLuxurySingleroom(int roomNumber, Customer customer){
        luxury_singleroom[roomNumber] = new Singleroom(customer);
    }
            
    public void addCustomerToDeluxeSingleroom(int roomNumber, Customer customer){
        deluxe_singleroom[roomNumber] = new Singleroom(customer);
    }

    public Doubleroom[] getLuxury_doubleroom() {
        return luxury_doubleroom;
    }

    public Doubleroom[] getDeluxe_doubleroom() {
        return deluxe_doubleroom;
    }

    public Singleroom[] getLuxury_singleroom() {
        return luxury_singleroom;
    }

    public Singleroom[] getDeluxe_singleroom() {
        return deluxe_singleroom;
    }
}