package com.company;

import java.util.ArrayList;

public class Map {
    public Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Map() {
        Room room1 = new Room("Room 1", "Greetings earthling! look around, there is a shoe and an axe - See if you want them. Continue to the next room to see what what lays within", true);
        Room room2 = new Room("Room 2", "Its very humid, remember to get yourself hydrated - Look around to see if there is something do drink and eat", false);
        Room room3 = new Room("Room 3", "", false);
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
        Weapon dagger = new Weapon("dagger", "a dagger made of silver", 10);
        room7.addItem(dagger);
        Food water = new Food("Water", "make sure it's clean enough to drink", 5, false);
        Food bread = new Food("bread", "a large loaf of bread", 10, false);
        Food meat = new Food("meat", "some old horse meat", 15, true);
        room2.addItem(water);
        room9.addItem(bread);
        room9.addItem(meat);
        Weapon axe = new Weapon("axe", "use it if you want to", 5, 5);
        room1.addItem(axe);
        Item shoe = new Item("shoe", " gives you more style for the ladies out there");
        room1.addItem(shoe);

        Enemy orc = new Enemy(20, 3, "orc", "a big ugly orc", room8);
        room8.addEnemy(orc);

    }
}
