package com.model;


import java.io.Serializable;

public class Food extends Service implements Serializable
{
    public Food(int itemno,int quantity)
    {
        super.setItemno(itemno);
        super.setQuantity(quantity);
        switch(itemno)
        {
            case 1:
            	setPrice(quantity * 50);
                break;
            case 2:
            	setPrice(quantity * 60);
                break;
            case 3:
            	setPrice(quantity * 70);
                break;
            case 4:
            	setPrice(quantity * 80);
                break;
        }
    }
    
}