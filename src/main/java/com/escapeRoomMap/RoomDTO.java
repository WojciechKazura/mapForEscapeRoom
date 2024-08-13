package com.escapeRoomMap;



public class RoomDTO {

    private int id;
    private RoomDTO nextRoom;

    public RoomDTO(int id, RoomDTO nextRoom) {
        this.id = id;
        this.nextRoom = nextRoom;
    }

    public RoomDTO() {

    }

    public int getId() {
        return id;
    }

    public RoomDTO getNextRoom() {
        return nextRoom;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                ", nextRoom=" + nextRoom +
                '}';
    }
}
