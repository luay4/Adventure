package com.company;

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Room room1 = new Room("Room 1", "The first room you will start, will not take your life apart", true);
        Room room2 = new Room("Room 2", "Some rocks are lying at the bottom of the room, it is very humid", false);
        Room room3 = new Room("Room 3", "A princess is sleeping on a king size bed at the other end of the room", false);
        Room room4 = new Room("Room 4", "Get some pills for your health, use a little of your wealth. +10 energy", false);
        Room room5 = new Room("Room 5", "There is a chest in the middle of the room", false);
        Room room6 = new Room("Room 6", "On a table at the corner of the room there is a rusty old key", false);
        Room room7 = new Room("Room 7", "There is a silver dagger in a fancy glass box", false);
        Room room8 = new Room("Room 8", "In the middle of the room stands an ugly orc, who seems hostile. " +
                "He must die before you can continue", false);
        Room room9 = new Room("Room 9", "There is a cupboard with some bread and meat", false);
        int currentRoom = 0;

        Room[] rooms = {room1, room2, room3, room4, room5, room6, room7, room8, room9};

        room1.setDirection(null, room2, room4, null);
        room2.setDirection(null, room3, null, room1);
        room3.setDirection(null, null, room6, room2);
        room4.setDirection(room1, null, room7, null);
        room5.setDirection(null, null, room8, null);
        room6.setDirection(room3, null, room9, null);
        room7.setDirection(room4, room8, null, null);
        room8.setDirection(room5, room9, null, room7);
        room9.setDirection(room6, null, null, room8);
        System.out.println("You are now in " + rooms[currentRoom].getRoomName() + "\n " + rooms[currentRoom].getRoomDescription());

        while (true) {
            System.out.println("Which direction do you want to go to?: ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.equals("go north") || input.equals("north") || input.equals("n")) {

                for(int i = 0; i < rooms.length; i++){
                    if (rooms[i].isCurrentRoom() == true) {
                        if (rooms[i].getNorth() == null) {
                            System.out.println("you cannot go there");
                            break;
                        } else {
                            rooms[i].setCurrentRoom(false);
                            currentRoom = i;
                            rooms[i].getNorth().setCurrentRoom(true);
                            System.out.println("You are now in " + rooms[i].getNorth().getRoomName());
                            break;
                        }
                    }
                }

            } else if (input.equals("go south") || input.equals("south") || input.equals("s")) {
                for(int i = 0; i < rooms.length; i++){
                    if (rooms[i].isCurrentRoom() == true) {
                        if (rooms[i].getSouth() == null) {
                            System.out.println("you cannot go there");
                            break;
                        } else {
                            rooms[i].setCurrentRoom(false);
                            currentRoom = i;
                            rooms[i].getSouth().setCurrentRoom(true);
                            System.out.println("You are now in " + rooms[i].getSouth().getRoomName());
                            break;
                        }
                    }
                }
            } else if (input.equals("go east") || input.equals("east") || input.equals("e")) {
                for(int i = 0; i < rooms.length; i++){
                    if (rooms[i].isCurrentRoom() == true) {
                        if (rooms[i].getEast() == null) {
                            System.out.println("you cannot go there");
                            break;
                        } else {
                            rooms[i].setCurrentRoom(false);
                            currentRoom = i;
                            rooms[i].getEast().setCurrentRoom(true);
                            System.out.println("You are now in " + rooms[i].getEast().getRoomName());
                            break;
                        }
                    }
                }
            } else if (input.equals("go west") || input.equals("west") || input.equals("w")) {
                for(int i = 0; i < rooms.length; i++){
                    if (rooms[i].isCurrentRoom() == true) {
                        if (rooms[i].getWest() == null) {
                            System.out.println("you cannot go there");
                            break;
                        } else {
                            rooms[i].setCurrentRoom(false);
                            currentRoom = i;
                            rooms[i].getWest().setCurrentRoom(true);
                            System.out.println("You are now in " + rooms[i].getWest().getRoomName());
                            break;
                        }
                    }
                }
            }
            if (input.equals("look") || input.equals("l")) {
                System.out.println(rooms[currentRoom + 1].getRoomDescription());
            } else if (input.equals("help") || (input.equals("h"))) {
                System.out.println("Controls:\n Type 'look' to get the description of the current room" +
                        "\n Type any direction (north, east, south and west) to move to another room" +
                        "\n Type 'exit' to quit the game");
            }

        }
    }
}