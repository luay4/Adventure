package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom;
    private int health;

    public Player(Room currentroom) {
        this.currentRoom = currentroom;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void take(String item) {
        Item itemFound = findItem(item);
        if (itemFound != null) {
            inventory.add(itemFound);
            currentRoom.itemList.remove(itemFound);
            System.out.println(itemFound + " has been added to the inventory");
        } else {
            System.out.println("Could not find item");
        }
    }

    public void drop(String item) {
        Item itemFound = findItemInventory(item);
        if (itemFound != null) {
            currentRoom.itemList.add(itemFound);
            inventory.remove(itemFound);
            System.out.println(itemFound + " has been dropped");
        } else {
            System.out.println("Could not find item in inventory");
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Item findItem(String itemName) {
        for (int i = 0; i < currentRoom.itemList.size(); i++) {
            Item requestedItem = currentRoom.itemList.get(i);
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
        if (currentRoom.getNorth() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going north\n");
            setCurrentRoom(currentRoom.getNorth());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public void goEast() {
        if (currentRoom.getEast() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going east\n");
            setCurrentRoom(currentRoom.getEast());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public void goSouth() {
        if (currentRoom.getSouth() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going south\n");
            setCurrentRoom(currentRoom.getSouth());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public void goWest() {
        if (currentRoom.getWest() == null) {
            System.out.println("you cannot go there");
        } else {
            System.out.println("Going west\n");
            setCurrentRoom(currentRoom.getWest());
            System.out.println(currentRoom.getRoomName());
            System.out.println(currentRoom.getRoomDescription());
        }
    }

    public String printInventory() {
        String inventoryString = "Inventory:\n";
        for (int i = 0; i < inventory.size(); i++) {
            inventoryString += inventory.get(i).getItemName()+ "\n";

        }
        return inventoryString;
    }
}
