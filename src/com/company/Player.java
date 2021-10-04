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
        if (itemFound != null) {
            inventory.add(itemFound);
            currentRoomPlayer.itemList.remove(itemFound);
            System.out.println(itemFound + " has been added to the inventory");
        } else {
            System.out.println("Could not find item");
        }
    }

    public void drop(String item) {
        Item itemFound = findItemInventory(item);
        if (itemFound != null) {
            currentRoomPlayer.itemList.add(itemFound);
            inventory.remove(itemFound);
            System.out.println(itemFound + " has been dropped");
        } else {
            System.out.println("Could not find item in inventory");
        }
    }

    public Room getCurrentRoomPlayer() {
        return currentRoomPlayer;
    }

    public void setCurrentRoomPlayer(Room currentRoomPlayer) {
        this.currentRoomPlayer = currentRoomPlayer;
    }

    public Item findItem(String itemName) {
        for (int i = 0; i < currentRoomPlayer.itemList.size(); i++) {
            Item requestedItem = currentRoomPlayer.itemList.get(i);
            if (requestedItem.getItemName().equals(itemName)) {
                return requestedItem;
            }
        }
        return null;
    }

    public Item findItemInventory(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item requestedItem = inventory.get(i);
            if (requestedItem.getItemName().equals(itemName)) {
                return requestedItem;
            }
        }
        return null;
    }

    public void goNorth() {
        if (currentRoomPlayer.getNorth() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going north\n");
            setCurrentRoomPlayer(currentRoomPlayer.getNorth());
            System.out.println(currentRoomPlayer.getRoomName());
            System.out.println(currentRoomPlayer.getRoomDescription());
        }
    }

    public void goEast() {
        if (currentRoomPlayer.getEast() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going east\n");
            setCurrentRoomPlayer(currentRoomPlayer.getEast());
            System.out.println(currentRoomPlayer.getRoomName());
            System.out.println(currentRoomPlayer.getRoomDescription());
        }
    }

    public void goSouth() {
        if (currentRoomPlayer.getSouth() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going south\n");
            setCurrentRoomPlayer(currentRoomPlayer.getSouth());
            System.out.println(currentRoomPlayer.getRoomName());
            System.out.println(currentRoomPlayer.getRoomDescription());
        }
    }

    public void goWest() {
        if (currentRoomPlayer.getWest() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going west\n");
            setCurrentRoomPlayer(currentRoomPlayer.getWest());
            System.out.println(currentRoomPlayer.getRoomName());
            System.out.println(currentRoomPlayer.getRoomDescription());
        }
    }
}
