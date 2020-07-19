/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Hotel;
import com.model.Laundry;
import com.model.Service;
import com.model.Customer;
import com.model.Doubleroom;
import com.model.Fitness;
import com.model.Food;
import com.model.Singleroom;
import com.model.Spa;
import com.utility.NotAvailable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Evan
 */
public class HotelController {
    static Scanner sc;
    Hotel hotel;
    
    public final static int LUXURY_DOUBLEROOM = 1;
    public final static int DELUXE_DOUBLEROOM = 2;
    public final static int LUXURY_SINGLEROOM = 3;
    public final static int DELUXE_SINGLEROOM = 4;
    
    public HotelController(){
        sc = new Scanner(System.in);
        this.hotel = new Hotel();
    }
    
    public void bookRoom(int roomType){
        int j;
        int roomNumber;
        ArrayList<Integer> emptyRoom;
        
        System.out.println("\nChoose room number from : ");
        
        switch (roomType) {
            case LUXURY_DOUBLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_doubleroom());
                printRoomList(emptyRoom, 1);
                System.out.print("\nEnter room number: ");
                
                try{
                    roomNumber = sc.nextInt();
                    roomNumber--;
                    
                    if(hotel.getHolder().getLuxury_doubleroom()[roomNumber] != null)
                        throw new NotAvailable();
                    
                    customerDetails(LUXURY_DOUBLEROOM,roomNumber);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
                
            case DELUXE_DOUBLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getDeluxe_doubleroom());
                printRoomList(emptyRoom, 11);
                System.out.print("\nEnter room number: ");
                
                try{
                roomNumber = sc.nextInt();
                roomNumber -= 11;
                
                if(hotel.getHolder().getDeluxe_doubleroom()[roomNumber] != null)
                    throw new NotAvailable();
                
                customerDetails(DELUXE_DOUBLEROOM, roomNumber);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
                
            case LUXURY_SINGLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_singleroom());
                printRoomList(emptyRoom, 31);
                System.out.print("\nEnter room number: ");
                
                try{
                roomNumber = sc.nextInt();
                roomNumber -= 31;
                
                if(hotel.getHolder().getLuxury_singleroom()[roomNumber] != null)
                    throw new NotAvailable();
                
                customerDetails(LUXURY_SINGLEROOM, roomNumber);
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                    return;
                }
                break;
                
            case DELUXE_SINGLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getDeluxe_singleroom());
                printRoomList(emptyRoom, 41);
                System.out.print("\nEnter room number: ");
                
                try{
                roomNumber = sc.nextInt();
                roomNumber -= 41;
                
                if(hotel.getHolder().getDeluxe_singleroom()[roomNumber]!=null)
                    throw new NotAvailable();
                
                customerDetails(DELUXE_SINGLEROOM, roomNumber);
                }
                catch(Exception e)
                {
                   System.out.println("Invalid Option");
                    return;
                }
                break;
            
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked!!!");
    }
    
    public void customerDetails(int roomType, int roomNumber){
        String name, contact, gender;
        String name2, contact2, gender2;
        Customer customer = new Customer();
        Customer secondCustomer = new Customer();
        
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        
        customer = new Customer(name, gender, contact);
        
        if(roomType == LUXURY_DOUBLEROOM || roomType == DELUXE_DOUBLEROOM){
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2=sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next();
            
            secondCustomer = new Customer(name2, gender2, contact2);
        }      
          switch (roomType) {
            case 1:
                hotel.getHolder().addCustomerToLuxuryDoubleroom(roomNumber, customer, secondCustomer);
                break;
            case 2:
                hotel.getHolder().addCustomerToDeluxeDoubleroom(roomNumber, customer, secondCustomer);
                break;
            case 3:
                hotel.getHolder().addCustomerToLuxurySingleroom(roomNumber, customer);
                break;
            case 4:
                hotel.getHolder().addCustomerToDeluxeSingleroom(roomNumber, customer);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }
    
    public void features(int roomType){
        switch (roomType) {
            case LUXURY_DOUBLEROOM:
                System.out.println("Double Bed");
                System.out.println("AC : Yes");
                System.out.println("Free Breakfast : Yes");
                System.out.println("Charge : $400");
                break;
            case DELUXE_DOUBLEROOM:
                System.out.println("Double Bed");
                System.out.println("AC : No");
                System.out.println("Free Breakfast : Yes");
                System.out.println("Charge : $300");
                break;
            case LUXURY_SINGLEROOM:
                System.out.println("Single Bed");
                System.out.println("AC : Yes");
                System.out.println("Free Breakfast : Yes");
                System.out.println("Charge : $220");
                break;
            case DELUXE_SINGLEROOM:
                System.out.println("Single Bed");
                System.out.println("AC : No");
                System.out.println("Free Breakfast : Yes");
                System.out.println("Charge : $120");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    
    public void availability(int roomType){
        ArrayList<Integer> emptyRoom;
        
        switch(roomType) {
            case LUXURY_DOUBLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_doubleroom());
                break;
            case DELUXE_DOUBLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getDeluxe_doubleroom());
                break;
            case LUXURY_SINGLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_singleroom());
                break;
            case DELUXE_SINGLEROOM:
                emptyRoom = getEmptyRoomList(hotel.getHolder().getDeluxe_doubleroom());
                break;
            default:
                System.out.println("Enter valid option");
                return;
        }
        
        System.out.println("Number of rooms available : " + emptyRoom.size());
    }
    
    public void bill(int roomNumber,int roomType){
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
               
        switch(roomType){
            case LUXURY_DOUBLEROOM:
                amount+=400;
                    System.out.println("\nRoom Charge - "+400);
                    System.out.println("\n===============");
                    System.out.println("Service Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Service obb : hotel.getHolder().getLuxury_doubleroom()[roomNumber].getService())
                    {
                        amount += obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1], obb.getQuantity(),obb.getPrice() );
                    }
                break;
            case DELUXE_DOUBLEROOM:
                    amount+=300;
                    System.out.println("Room Charge - "+300);
                    System.out.println("\nService Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Service obb: hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1], obb.getQuantity(),obb.getPrice() );
                    }
                break;
            case LUXURY_SINGLEROOM:
                    amount+=220;
                    System.out.println("Room Charge - "+220);
                    System.out.println("\nService Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Service obb : hotel.getHolder().getLuxury_singleroom()[roomNumber].getService())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1], obb.getQuantity(),obb.getPrice() );
                    }
                break;
            case DELUXE_SINGLEROOM:
                    amount+=120;
                    System.out.println("Room Charge - "+120);
                    System.out.println("\nService Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Service obb :  hotel.getHolder().getDeluxe_singleroom()[roomNumber].getService())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1], obb.getQuantity(),obb.getPrice() );
                    }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }
    
    public void checkOut(int roomNumber,int roomType){
        int j;
        char choice;
        Singleroom room = new Singleroom();
        
        switch (roomType) {
            case LUXURY_DOUBLEROOM :               
                if(hotel.getHolder().getLuxury_doubleroom()[roomNumber]!=null){
                    room = hotel.getHolder().getLuxury_doubleroom()[roomNumber];
                    System.out.println("Room used by " + room.getCustomer().getName());
                }
                else {    
                    System.out.println("Empty Already");
                        return;
                }
                
                System.out.println("Do you want to checkout ?(y/n)");
                choice = sc.next().charAt(0);
                 
                if(choice == 'y'|| choice == 'Y'){
                    bill(roomNumber, roomType);
                    hotel.getHolder().getDeluxe_doubleroom()[roomNumber] = null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            case DELUXE_DOUBLEROOM :
                if(hotel.getHolder().getDeluxe_doubleroom()[roomNumber]!=null){
                    room = hotel.getHolder().getDeluxe_doubleroom()[roomNumber];
                    System.out.println("Room used by " + room.getCustomer().getName());
                }
                else {    
                    System.out.println("Empty Already");
                    return;
                }
                
                System.out.println("Do you want to checkout ?(y/n)");
                choice = sc.next().charAt(0);
                 
                if(choice == 'y'|| choice == 'Y'){
                    bill(roomNumber, roomType);
                    hotel.getHolder().getDeluxe_doubleroom()[roomNumber] = null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            case LUXURY_SINGLEROOM:
                if(hotel.getHolder().getLuxury_singleroom()[roomNumber]!=null){
                    room = hotel.getHolder().getLuxury_singleroom()[roomNumber];
                    System.out.println("Room used by " + room.getCustomer().getName());
                }
                else {    
                    System.out.println("Empty Already");
                        return;
                }
                
                System.out.println("Do you want to checkout ?(y/n)");
                choice = sc.next().charAt(0);
                 
                if(choice == 'y'|| choice == 'Y'){
                    bill(roomNumber, roomType);
                    hotel.getHolder().getDeluxe_doubleroom()[roomNumber] = null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            case DELUXE_SINGLEROOM:
                if(hotel.getHolder().getDeluxe_singleroom()[roomNumber]!=null){
                    room = hotel.getHolder().getDeluxe_singleroom()[roomNumber];
                    System.out.println("Room used by " + room.getCustomer().getName());
                }
                else {    
                    System.out.println("Empty Already");
                        return;
                }
                
                System.out.println("Do you want to checkout ?(y/n)");
                choice = sc.next().charAt(0);
                 
                if(choice == 'y'|| choice == 'Y'){
                    bill(roomNumber, roomType);
                    hotel.getHolder().getDeluxe_doubleroom()[roomNumber] = null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }
    
    public void orderFood(int roomNumber,int roomType){
        int food, quantity;
        char wish;
        
        try{
             System.out.println("\n==========\n   ");
             System.out.println("Menu:  ");
             System.out.println("==========");
             System.out.println("1.Sandwich\t$.50");
             System.out.println("2.Pasta\t\t$.60");
             System.out.println("3.Noodles\t$.70");
             System.out.println("4.Coke\t\t$.30");
             System.out.print("Choice : ");
            do
            {
                food = sc.nextInt();
                System.out.print("Quantity- ");
                quantity =sc.nextInt();

                switch(roomType){
                    case LUXURY_DOUBLEROOM: 
                        hotel.getHolder().getLuxury_doubleroom()[roomNumber].getService().add(new Food(food, quantity));
                        break;
                    case DELUXE_DOUBLEROOM: 
                        hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Food(food, quantity));
                        break;
                    case LUXURY_SINGLEROOM: 
                        hotel.getHolder().getLuxury_singleroom()[roomNumber].getService().add(new Food(food, quantity));
                        break;
                    case DELUXE_SINGLEROOM: 
                        hotel.getHolder().getDeluxe_singleroom()[roomNumber].getService().add(new Food(food, quantity));
                        break;                                                 
                }

                System.out.println("Do you want to order anything else ? (y/n)");
                wish=sc.next().charAt(0); 
            }while(wish=='y'||wish=='Y');  
        
        }
        catch(NullPointerException e){
                System.out.println("\nRoom not booked");
        }
        
        catch(Exception e){
             System.out.println("Cannot be done");
         }
    }
    
    public void moveRoom(int roomNumber, int roomType) {
    	int j;
    	int newRoomNumber;
    	ArrayList<Integer> emptyRoom;
    	
    	System.out.println("Choose New Room Number : ");
    	
    	switch(roomType) {
    		case LUXURY_DOUBLEROOM :
    			emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_doubleroom());
    			printRoomList(emptyRoom, 1);
    			
    			try{
                    newRoomNumber = sc.nextInt();
                    newRoomNumber--;
                    
                    if(hotel.getHolder().getLuxury_doubleroom()[newRoomNumber] != null) {
                        throw new NotAvailable();
                    }
                    else {
                    	hotel.getHolder().getLuxury_doubleroom()[newRoomNumber] = hotel.getHolder().getLuxury_doubleroom()[roomNumber];
                    	hotel.getHolder().getLuxury_doubleroom()[roomNumber] = null;
                    	System.out.println("Move Done Succesfully");
                    }
                    
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                }
    			break;
    			
    		case DELUXE_DOUBLEROOM :
    			emptyRoom = getEmptyRoomList(hotel.getHolder().getDeluxe_doubleroom());
    			printRoomList(emptyRoom, 11);
    			
    			try{
                    newRoomNumber = sc.nextInt();
                    newRoomNumber--;
                    
                    if(hotel.getHolder().getDeluxe_doubleroom()[newRoomNumber] != null) {
                        throw new NotAvailable();
                    }
                    else {
                    	hotel.getHolder().getDeluxe_doubleroom()[newRoomNumber] = hotel.getHolder().getDeluxe_doubleroom()[roomNumber];
                    	hotel.getHolder().getDeluxe_doubleroom()[roomNumber] = null;
                    	System.out.println("Move Done Succesfully");
                    }
                    
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                }
    			break;
    			
    		case LUXURY_SINGLEROOM :
    			emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_singleroom());
    			printRoomList(emptyRoom, 31);
    			
    			try{
                    newRoomNumber = sc.nextInt();
                    newRoomNumber--;
                    
                    if(hotel.getHolder().getLuxury_singleroom()[newRoomNumber] != null) {
                        throw new NotAvailable();
                    }
                    else {
                    	hotel.getHolder().getLuxury_singleroom()[newRoomNumber] = hotel.getHolder().getLuxury_singleroom()[roomNumber];
                    	hotel.getHolder().getLuxury_singleroom()[roomNumber] = null;
                    	System.out.println("Move Done Succesfully");
                    }
                    
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                }
    			break;
    			
    		case DELUXE_SINGLEROOM:
    			emptyRoom = getEmptyRoomList(hotel.getHolder().getDeluxe_singleroom());
    			printRoomList(emptyRoom, 41);
    			
    			try{
                    newRoomNumber = sc.nextInt();
                    newRoomNumber--;
                    
                    if(hotel.getHolder().getDeluxe_singleroom()[newRoomNumber] != null) {
                        throw new NotAvailable();
                    }
                    else {
                    	hotel.getHolder().getDeluxe_singleroom()[newRoomNumber] = hotel.getHolder().getDeluxe_singleroom()[roomNumber];
                    	hotel.getHolder().getDeluxe_singleroom()[roomNumber] = null;
                    	System.out.println("Move Done Succesfully");
                    }
                    
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Option");
                }
    			break;
    	}
    	
    }
    
    public void orderSpa(int roomNumber, int roomType) {
    	int spaPackage, quantity;
    	char wish;
    	
    	try {
            System.out.println("\n==========\n   ");
            System.out.println("Menu:  ");
            System.out.println("==========");
            System.out.println("1. Single Package\t$50");
            System.out.println("2. Double Package\t$100");
            System.out.println("3. Special Package\t$175");
            System.out.println("4. Full Package\t$250");
            System.out.print("Choice : ");
    		
            do {
               spaPackage = sc.nextInt();
               System.out.print("Quantity- ");
               quantity =sc.nextInt();
               
               switch(roomType) {
               		case LUXURY_DOUBLEROOM :
               			hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Spa(spaPackage, quantity));
               			break;
               			
               		case DELUXE_DOUBLEROOM :
               			hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Spa(spaPackage, quantity));
               			break;
               			
               		case LUXURY_SINGLEROOM :
               			hotel.getHolder().getLuxury_singleroom()[roomNumber].getService().add(new Spa(spaPackage, quantity));
               			break;
               			
               		case DELUXE_SINGLEROOM :
               			hotel.getHolder().getDeluxe_singleroom()[roomNumber].getService().add(new Spa(spaPackage, quantity));
               }
               System.out.println("Do you want to order anything else ? (y/n)");
               wish=sc.next().charAt(0);
    		}while(wish == 'y' || wish == 'Y');
    	}
        catch(NullPointerException e){
            System.out.println("\nRoom not booked");
        }
    
	    catch(Exception e){
	         System.out.println("Cannot be done");
	     }
    }
    
    public void orderFitness(int roomNumber, int roomType) {
    	int fitnessPackage, person;
    	try {
    		System.out.println("\n==========\n   ");
            System.out.println("Menu:  ");
            System.out.println("==========");
            System.out.println("1. With trainer\t$25/person + $25 trainer");
            System.out.println("2. Without trainer\t$25/person");
            System.out.print("Choice : ");
            
            fitnessPackage = sc.nextInt();
            System.out.println("How many person?: ");
            person = sc.nextInt();
            
            switch(roomType) {
       		case LUXURY_DOUBLEROOM :
       			hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Fitness(fitnessPackage, person));
       			break;
       			
       		case DELUXE_DOUBLEROOM :
       			hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Fitness(fitnessPackage, person));
       			break;
       			
       		case LUXURY_SINGLEROOM :
       			hotel.getHolder().getLuxury_singleroom()[roomNumber].getService().add(new Fitness(fitnessPackage, person));
       			break;
       			
       		case DELUXE_SINGLEROOM :
       			hotel.getHolder().getDeluxe_singleroom()[roomNumber].getService().add(new Fitness(fitnessPackage, person));
            }
    	}catch(NullPointerException e){
            System.out.println("\nRoom not booked");
        }
    
	    catch(Exception e){
	         System.out.println("Cannot be done");
	     }
    }
    
    public void orderLaundry(int roomNumber, int roomType) {
    	int laundryPackage, quantity;
    	try {
    		System.out.println("\n==========\n   ");
            System.out.println("Menu:  ");
            System.out.println("==========");
            System.out.println("1. Complete (wash+iron)\t$7/kg");
            System.out.println("2. Just wash\t$5/kg");
            System.out.print("Choice : ");
            
            laundryPackage = sc.nextInt();
            System.out.println("Quantity(Kg)- ");
            quantity = sc.nextInt();
            
            switch(roomType) {
       		case LUXURY_DOUBLEROOM :
       			hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Laundry(laundryPackage, quantity));
       			break;
       			
       		case DELUXE_DOUBLEROOM :
       			hotel.getHolder().getDeluxe_doubleroom()[roomNumber].getService().add(new Laundry(laundryPackage, quantity));
       			break;
       			
       		case LUXURY_SINGLEROOM :
       			hotel.getHolder().getLuxury_singleroom()[roomNumber].getService().add(new Laundry(laundryPackage, quantity));
       			break;
       			
       		case DELUXE_SINGLEROOM :
       			hotel.getHolder().getDeluxe_singleroom()[roomNumber].getService().add(new Laundry(laundryPackage, quantity));
            }
    	}catch(NullPointerException e){
            System.out.println("\nRoom not booked");
        }
    
	    catch(Exception e){
	         System.out.println("Cannot be done");
	     }
    }
    
    public void upgradeRoom(int roomNumber, int roomType) {
    	int j;
    	int newRoomNumber;
    	ArrayList<Integer> emptyRoom;
    	
    	switch(roomType) {
    		case LUXURY_DOUBLEROOM :
    			System.out.println("Upgrade not available for this type...\n");
    			break;
    			
    		case DELUXE_DOUBLEROOM :
    			System.out.println("Choose Room Number : ");
    			emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_doubleroom());
    			printRoomList(emptyRoom, 1);
                newRoomNumber = sc.nextInt();
                newRoomNumber--;
                
                hotel.getHolder().getLuxury_doubleroom()[newRoomNumber] = hotel.getHolder().getDeluxe_doubleroom()[roomNumber];
                hotel.getHolder().getDeluxe_doubleroom()[roomNumber] = null;
    			System.out.println("Upgrading to Luxury Doubleroom from Deluxe Doubleroom...");
    			break;
    			
    		case LUXURY_SINGLEROOM :
    			System.out.println("Upgrade not available for this type...\n");
    			break;
    			
    		case DELUXE_SINGLEROOM :
    			System.out.println("Choose Room Number : ");
    			emptyRoom = getEmptyRoomList(hotel.getHolder().getLuxury_singleroom());
    			printRoomList(emptyRoom, 31);
                newRoomNumber = sc.nextInt();
                newRoomNumber--;
                
                hotel.getHolder().getLuxury_singleroom()[newRoomNumber] = hotel.getHolder().getDeluxe_singleroom()[roomNumber];
                hotel.getHolder().getDeluxe_singleroom()[roomNumber] = null;
    			System.out.println("Upgrading to Luxury Singleroom from Deluxe Singleroom...");
    			break;
    	}
    }
    
    private ArrayList<Integer> getEmptyRoomList(Singleroom room[]){
        int count = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < room.length; i++){
            if(room[i] == null){
                result.add(i);
            }
        }
        
        return result;
    }
    
    private void printRoomList(ArrayList<Integer> list, int start){
        for(int room : list){
            System.out.print(room + start +", ");
        }
    }
    
}
