package com.model;

import com.model.Singleroom;
import java.io.Serializable;

public class Doubleroom extends Singleroom implements Serializable
{ 
    private Customer second_customer; 
    
    public Doubleroom(){
        super.setCustomer(new Customer());
        this.second_customer = new Customer();
    }
    
    public Doubleroom(Customer customer, Customer second_customer)
    {
        super.setCustomer(customer);
        this.second_customer = second_customer;
    }

    public Customer getSecondCustomer(){
        return this.second_customer;
    }
    
    public void setSecondCustomer(Customer customer){
        this.second_customer = customer;
    }
}