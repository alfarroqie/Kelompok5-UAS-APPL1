package com.model;


import com.model.Food;
import java.io.Serializable;
import java.util.ArrayList;

public class Singleroom implements Serializable
{
    private Customer customer;  
    private ArrayList<Service> service =new ArrayList<>();
   
    public Singleroom()
    {
        this.customer = new Customer();
    }
    
    public Singleroom(Customer customer)
    {
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void setService(ArrayList<Service> service) {
    	this.service = service;
    }
    
    public ArrayList<Service> getService(){
    	return this.service;
    }
}