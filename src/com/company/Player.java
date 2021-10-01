package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoomPlayer;

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void take(String item) {
        Item itemFound = findItem(item);
        inventory.add(itemFound);

    }

    public Room getCurrentRoomPlayer() {
        return currentRoomPlayer;
    }

    public void setCurrentRoomPlayer(Room currentRoomPlayer) {
        this.currentRoomPlayer = currentRoomPlayer;
    }

    public Item findItem(String itemName) {
        String requestedItem = "";
        for (int i = 0; i < currentRoomPlayer.itemList.size(); i++) {
            Item item = null;
            requestedItem = currentRoomPlayer.itemList.get(i).getItemName();
            if (requestedItem.equals(itemName)) {
                item = currentRoomPlayer.itemList.get(i);
            }
        }
        return null;
    }
}
