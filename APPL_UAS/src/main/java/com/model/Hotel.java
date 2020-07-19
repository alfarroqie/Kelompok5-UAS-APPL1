package com.model;

import com.model.Doubleroom;
import com.model.Food;
import com.model.Singleroom;
import com.utility.Holder;
import com.utility.NotAvailable;
import java.util.Scanner;

public class Hotel
{
    Holder holder;
    
    public Hotel(){
        this.holder = new Holder();
    }
    
    public Holder getHolder(){
        return holder;
    }
}



        