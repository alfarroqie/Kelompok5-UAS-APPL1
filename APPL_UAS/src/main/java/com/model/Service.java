package com.model;

import java.io.Serializable;

public class Service implements Serializable{
	private int itemno;
    private int quantity;   
    private float price;
    
    public float getPrice(){
        return price;
    }

    public int getItemno() {
        return itemno;
    }


    public void setItemno(int itemno) {
        this.itemno = itemno;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
