package com.company;

public class Room {
    private String roomName;
    private String roomDescription;

    public Room(String roomName, String roomDescription) {
        this.roomName = roomName;
        this.roomDescription = roomDescription;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getRoomName() {
        return roomName;
    }

    @Override
    public String toString() {
        return roomName + " " + roomDescription;
    }
}
