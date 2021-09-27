package com.company;

public class Room {
    private String roomName;
    private String roomDescription;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private boolean currentRoom;

    public boolean isCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(boolean currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room(String roomName, String roomDescription, boolean currentRoom) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.currentRoom = currentRoom;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getRoomName() {
        return roomName;
    }


    public void setDirection(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    @Override
    public String toString() {
        return roomName + " " + roomDescription;
    }
}
