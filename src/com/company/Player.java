package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoomPlayer;

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void take(String item) {
    }

    public Room getCurrentRoomPlayer() {
        return currentRoomPlayer;
    }

    public void setCurrentRoomPlayer(Room currentRoomPlayer) {
        this.currentRoomPlayer = currentRoomPlayer;
    }
}
