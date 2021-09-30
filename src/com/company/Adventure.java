package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        ArrayList<Item> room1Items = new ArrayList<>();
        ArrayList<Item> room2Items = new ArrayList<>();
        ArrayList<Item> room3Items = new ArrayList<>();
        ArrayList<Item> room4Items = new ArrayList<>();
        ArrayList<Item> room5Items = new ArrayList<>();
        ArrayList<Item> room6Items = new ArrayList<>();
        ArrayList<Item> room7Items = new ArrayList<>();
        ArrayList<Item> room8Items = new ArrayList<>();
        ArrayList<Item> room9Items = new ArrayList<>();

        Item rock = new Item("rock", "a mossy rock");
        room2Items.add(rock);
        Item coins = new Item("coins", "some gold coins");
        room2Items.add(coins);
        Item key = new Item("key", "a rusty old key");
        room6Items.add(key);
        Item dagger = new Item("dagger", "a dagger made of silver");
        room7Items.add(dagger);


        Room room1 = new Room("Room 1", "The first room you will start, will not take your life apart", true, room1Items);
        Room room2 = new Room("Room 2", "Some rocks are lying at the bottom of the room, it is very humid", false, room2Items);
        Room room3 = new Room("Room 3", "A princess is sleeping on a king size bed at the other end of the room", false, room3Items);
        Room room4 = new Room("Room 4", "Get some pills for your health, use a little of your wealth. +10 energy", false,room4Items);
        Room room5 = new Room("Room 5", "There is a chest in the middle of the room", false, room5Items);
        Room room6 = new Room("Room 6", "On a table at the corner of the room there is a rusty old key", false, room6Items);
        Room room7 = new Room("Room 7", "There is a silver dagger in a fancy glass box", false, room7Items);
        Room room8 = new Room("Room 8", "In the middle of the room stands an ugly orc, who seems hostile. " +
                "He must die before you can continue", false, room8Items);
        Room room9 = new Room("Room 9", "There is a cupboard with some bread and meat", false, room9Items);
        Room currentRoom = room1;

        room1.setDirection(null, room2, room4, null);
        room2.setDirection(null, room3, null, room1);
        room3.setDirection(null, null, room6, room2);
        room4.setDirection(room1, null, room7, null);
        room5.setDirection(null, null, room8, null);
        room6.setDirection(room3, null, room9, null);
        room7.setDirection(room4, room8, null, null);
        room8.setDirection(room5, room9, null, room7);
        room9.setDirection(room6, null, null, room8);

        Player player = new Player();

        System.out.println("Welcome to this adventure game\n");

        System.out.println("You are now in " + currentRoom.getRoomName() + "\n " + currentRoom.getRoomDescription());
        System.out.println("Which direction do you want to go to?: ");
        while (true) {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine().toLowerCase();
        // requesteRoom = null;
         //   Room requestedRoom = currentRoom.getNorth();

            // public void setNorth(Room north) {
            //  this.north = north;
            //  if(north.south != this) {
            //  north.setSouth(this);
            //   }
            // }

            if (input.equals("go north") || input.equals("north") || input.equals("n")) {
                if (currentRoom.getNorth() == null) {
                    System.out.println("you cannot go there");
                } else {
                    System.out.println("Going north\n");
                    currentRoom = currentRoom.getNorth();
                    System.out.println(currentRoom.getRoomName());
                    System.out.println(currentRoom.getRoomDescription());
                }
            }

            else if (input.equals("go south") || input.equals("south") || input.equals("s")) {
                if (currentRoom.getSouth() == null) {
                    System.out.println("you cannot go there");
                } else {
                    System.out.println("Going south\n");
                    currentRoom = currentRoom.getSouth();
                    System.out.println(currentRoom.getRoomName());
                    System.out.println(currentRoom.getRoomDescription());
                }
            }

            else if (input.equals("go east") || input.equals("east") || input.equals("e")) {
                if (currentRoom.getEast() == null) {
                    System.out.println("you cannot go there");
                } else {
                    System.out.println("Going east\n");
                    currentRoom = currentRoom.getEast();
                    System.out.println(currentRoom.getRoomName());
                    System.out.println(currentRoom.getRoomDescription());
                }
            }

            else if (input.equals("go west") || input.equals("west") || input.equals("w")) {
                if (currentRoom.getWest() == null) {
                    System.out.println("you cannot go there");
                } else {
                    System.out.println("Going west\n");
                    currentRoom = currentRoom.getWest();
                    System.out.println(currentRoom.getRoomName());
                    System.out.println(currentRoom.getRoomDescription());
                }
            }
            else if (input.equals("look") || input.equals("l")) {
                System.out.println(currentRoom.getRoomDescription());
            } else if (input.equals("help") || (input.equals("h"))) {
                System.out.println("Controls:\n Type 'look' to get the description of the current room" +
                        "\n Type any direction (north, east, south and west) to move to another room" +
                        "\n Type 'exit' to quit the game");
            } else if (input.equals("exit") || input.equals("e")) {
                System.out.println("Thanks for playing");
                break;
            } else if (input.equals("inventory") || input.equals("i")) {
                System.out.println(player.getInventory());
            } else if (input.equals("take") || input.equals("t")) {

            } else if (input.equals("drop") || input.equals("d")) {

            } else {
                System.out.println("Cannot do that, try something else");
            }

        }
    }
}