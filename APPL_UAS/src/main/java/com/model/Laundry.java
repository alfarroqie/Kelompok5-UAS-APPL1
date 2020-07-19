package com.model;
/**
*
* @author Chofief
*/

public class Laundry extends Service {
	
    public Laundry(int itemno, int quantity) {
    	super.setItemno(itemno);
    	super.setQuantity(quantity);
    	
    	switch(itemno) {
    		case 1 :
    			super.setPrice(quantity * 7);
    			break;
    		case 2 :
    			super.setPrice(quantity * 5);
    			break;
    	}
    }

}
