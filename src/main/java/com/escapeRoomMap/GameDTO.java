package com.escapeRoomMap;

import java.util.List;

public class GameDTO {

    private int id;
    private String name;
    private RoomDTO firstRoom;
    private int howManyRooms;
    private List<ConnectionView> connections;

    public GameDTO() {
    }

    public GameDTO(int id,String name, int howManyRooms, RoomDTO roomDTO, List<ConnectionView> connections ) {
        this.id = id;
        this.name=name;
        this.howManyRooms=howManyRooms;
        this.firstRoom =roomDTO;
        this.connections = connections;
    }

    public int getId() {
        return id;
    }

    public int getHowManyRooms() {
        return howManyRooms;
    }

    public RoomDTO getFirstRoom() {
        return firstRoom;
    }

    public String getName() {
        return name;
    }

    public List<ConnectionView> getConnections() {
        return connections;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstRoom(RoomDTO firstRoom) {
        this.firstRoom = firstRoom;
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomDTO=" + firstRoom +
                ", howManyRooms=" + howManyRooms +
                '}';
    }
}
