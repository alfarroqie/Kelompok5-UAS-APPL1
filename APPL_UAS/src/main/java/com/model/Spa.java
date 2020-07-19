package com.model;

public class Spa extends Service {
    public Spa(int itemno, int quantity) {
    	super.setItemno(itemno);
    	super.setQuantity(quantity);;
    	
    	switch(itemno) {
    		case 1 :
    			super.setPrice(quantity * 50);
    			break;
    		
    		case 2 :
    			super.setPrice(quantity * 100);
    			break;
    			
    		case 3 :
    			super.setPrice(quantity * 175);
    			break;
    		
    		case 4 :
    			super.setPrice(quantity * 250);
    			break;
    	}
    }

}
