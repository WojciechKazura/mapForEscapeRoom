package com.escapeRoomMap;

public class RoomDTO {

    private int id;

    public RoomDTO(int id) {
        this.id = id;

    }

    public RoomDTO() {

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                '}';
    }
}
