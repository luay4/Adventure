package com.company;

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        Room room1 = new Room("room1", "description");
        Room room2 = new Room("room2", "description");
        Room room3 = new Room("room3", "description");
        Room room4 = new Room("room4", "description");
        Room room5 = new Room("room5", "description");
        Room room6 = new Room("room6", "description");
        Room room7 = new Room("room7", "description");
        Room room8 = new Room("room8", "description");
        Room room9 = new Room("room9", "description");
        Room currentRoom = room1;

        System.out.println("Which direction do you want to go to?: ");
        String input = in.nextLine();



        if (input.equals("go north")) {
            System.out.println("going north");
        } else if (input.equals("go west")) {
            System.out.println("going west");
        } else if (input.equals("go east")) {
            System.out.println("going east");
        } else if (input.equals("go south")) {
            System.out.println("going south");
        } else if (input.equals("look")) {
            System.out.println(currentRoom);
        }
    }
}