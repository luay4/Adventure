package com.company;

import java.util.ArrayList;

public class Map {
    public Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Map() {
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
        currentRoom = room1;

        room1.setDirection(null, room2, room4, null);
        room2.setDirection(null, room3, null, room1);
        room3.setDirection(null, null, room6, room2);
        room4.setDirection(room1, null, room7, null);
        room5.setDirection(null, null, room8, null);
        room6.setDirection(room3, null, room9, null);
        room7.setDirection(room4, room8, null, null);
        room8.setDirection(room5, room9, null, room7);
        room9.setDirection(room6, null, null, room8);


        Item rock = new Item("rock", "a mossy rock");
        room2.addItem(rock);
        Item coins = new Item("coins", "some gold coins");
        room2.addItem(coins);
        Item key = new Item("key", "a rusty old key");
        room6.addItem(key);
        Item dagger = new Item("dagger", "a dagger made of silver");
        room7.addItem(dagger);
    }
}
