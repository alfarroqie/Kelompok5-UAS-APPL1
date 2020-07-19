package com.model;
/**
*
* @author Chofief
*/

public class Fitness extends Service {
	
    public Fitness(int itemno, int quantity) {
    	super.setItemno(itemno);
    	super.setQuantity(quantity);;
    	
    	switch(itemno) {
    		case 1 :
    			super.setPrice(quantity * 25 + 25);
    			break;
    		case 2 :
    			super.setPrice(quantity * 25);
    			break;
    	}
    }

}
