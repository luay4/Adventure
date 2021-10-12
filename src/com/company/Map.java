package com.company;

import java.util.ArrayList;

public class Map {
    public Room currentRoom;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Map() {
        Room room1 = new Room("Room 1", "Greetings earthling! look around in the woods, there is some shoes and an axe hidden behind the bushes- See if you want them. Continue to the next room to see what what lays within", true);
        Room room2 = new Room("Room 2", "The sun is over your head and it's hot, remember to get yourself hydrated - Look around to see if there is something do drink and eat", false);
        Room room3 = new Room("Room 3", "Dang it! you are up on a treehouse. you can see a village some miles ahead - look at the bookshelf to see if you can find something", false);
        Room room4 = new Room("Room 4", "You got yourself inside a rabbit hole. find anything there?", false);
        Room room5 = new Room("Room 5", "You have defeated the orc. there is a castle further ahead. dare to go inside?", false);
        Room room6 = new Room("Room 6", "The village is getting closer and closer and you are starting to get hungry now - see if you can find some food, dut be careful now!", false);
        Room room7 = new Room("Room 7", "it seems that someone forgot his sword - it could be helpful in the future", false);
        Room room8 = new Room("Room 8", "In the middle of the room stands an ugly orc, who seems hostile. He is guarding the porch that leads to something. Defeat him or die! ", false);
        Room room9 = new Room("Room 9", "get through the guards and pay them the toll to continue your journey", false);
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

        Weapon axe = new Weapon("axe", "use it if you want to", 5, 5);
        room1.addItem(axe);
        Item shoes = new Item("shoes", "a pair of shoes to comfort your bare feet");
        room1.addItem(shoes);
        Food water = new Food("Water", "make sure it's clean enough to drink", 5, false);
        room2.addItem(water);
        Item coins = new Item("coins", "some gold coins");
        room3.addItem(coins);
        Item rock = new Item("rock", "can it be helpful or just extra weight?");
        room4.addItem(rock);
        Food bread = new Food("bread", "a large loaf of bread", 10, false);
        Food meat = new Food("meat", "some old horse meat", 15, true);
        room6.addItem(bread);
        room6.addItem(meat);
        Weapon sword = new Weapon("sword", "Better than Excalibur", 10);
        room7.addItem(sword);
        Item key = new Item("key", "Maybe it's the key you need for something");
        room8.addItem(key);






        Weapon club = new Weapon("club","a bloodsoaked club", 8);

        Enemy orc = new Enemy(20, "orc", "a big ugly orc", club);
        room8.addEnemy(orc);
        orc.enemyItems.add(key);

    }
}
