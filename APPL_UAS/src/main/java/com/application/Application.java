package com.application;

import com.controller.HotelController;
import com.model.Hotel;
import com.utility.Holder;
import com.utility.Write;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Application {
        private static  final int ROOM_DETAILS = 1;
        private static final int ROOM_AVAILABILITY = 2;
        private static final int BOOK_ROOM = 3;
        private static final int ORDER_FOOD = 4;
        private static final int CHECKOUT = 5;
        private static final int MOVE_ROOM = 6;
        private static final int SPA = 7;
        private static final int FITNESS = 8;
        private static final int LAUNDRY = 9;
        private static final int UPGRADE_ROOM = 10;
        private static final int EXIT = 11;
        
        static Scanner sc;
        
    public static void main(String[] args){
        Hotel hotel;
        HotelController hotelController;
        int choiceMenu, choiceSubMenu;
        char wish;
        int[] room;
        boolean exit = false;
        
        try{
            sc = new Scanner(System.in);
            hotelController = new HotelController();
        do{
            printMenu();
            choiceMenu = sc.nextInt();
            switch(choiceMenu){
                case ROOM_DETAILS:
                    printRoomType();
                    choiceSubMenu = sc.nextInt();
                    hotelController.features(choiceSubMenu);
                    break;
                    
                case ROOM_AVAILABILITY:
                    printRoomType();
                    choiceSubMenu = sc.nextInt();
                    hotelController.availability(choiceSubMenu);
                    break;
                    
                case BOOK_ROOM:
                    printRoomType();
                    choiceSubMenu = sc.nextInt();
                    hotelController.bookRoom(choiceSubMenu);                     
                    break;
                    
                case ORDER_FOOD:
                     room = getRoomNumberInput();
                     hotelController.orderFood(room[0], room[1]);
                     break;
                         
                case CHECKOUT:                 
                    room = getRoomNumberInput();
                    hotelController.checkOut(room[0], room[1]);
                    break;
                
                case MOVE_ROOM:
                	room = getRoomNumberInput();
                	hotelController.moveRoom(room[0], room[1]);
                	break;
                	
                case SPA:
                	room = getRoomNumberInput();
                	hotelController.orderSpa(room[0], room[1]);
                	break;
                	
                case FITNESS:
                	room = getRoomNumberInput();
                	hotelController.orderFitness(room[0], room[1]);
                	break;
                	
                case LAUNDRY:
                	room = getRoomNumberInput();
                	hotelController.orderLaundry(room[0], room[1]);
                	break;
                
                case UPGRADE_ROOM :
                	room = getRoomNumberInput();
                	hotelController.upgradeRoom(room[0], room[1]);
                	break;
                	
                case EXIT:
                    exit = true;
                    break;

            }
                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0); 
                if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0); 
                }

        }while((wish=='y'||wish=='Y') && !exit);
        
        }        
        catch(Exception e){
                System.out.println("Not a valid input");
        }
    }
    
    static private void printMenu(){
        System.out.println("\nMENU :");
        System.out.println(ROOM_DETAILS+". Display room details:");
        System.out.println(ROOM_AVAILABILITY+". Display room availability");
        System.out.println(BOOK_ROOM+". Book");
        System.out.println(ORDER_FOOD+". Order food");
        System.out.println(CHECKOUT+". Checkout");
        System.out.println(SPA+". Spa");
        System.out.println(FITNESS+". Fitness");
        System.out.println(LAUNDRY+". Laundry");
        System.out.println(UPGRADE_ROOM+". Upgrade Room");
        
        System.out.println(EXIT+". Exit");
        System.out.print("Choice : ");
    }
    
    static private void printRoomType(){
        System.out.println("Choose room type : "); 
        System.out.println("1.Luxury Double Room"); 
        System.out.println("2.Deluxe Double Room");
        System.out.println("3.Luxury Single Room");
        System.out.println("4.Deluxe Single Room");
    
    }
    
    static private int[] getRoomNumberInput(){
        System.out.print("Room Number : ");
        int inp = sc.nextInt();
        int room[] = {0, 0};
        
        if(inp>60)
            System.out.println("Room doesn't exist");
        else if(inp>40){
            room[0] = inp-41;
            room[1] = HotelController.DELUXE_SINGLEROOM;
        }
        else if(inp>30){
            room[0] = inp-31;
            room[1] = HotelController.LUXURY_SINGLEROOM;
        }
        else if(inp>10){
            room[0] = inp-11;
            room[1] = HotelController.DELUXE_DOUBLEROOM;
        }
        else if(inp>0){
            room[0] = inp-1;
            room[1] = HotelController.LUXURY_SINGLEROOM;
        }
        else
            System.out.println("Room doesn't exist");
            
        return room;
    }
}