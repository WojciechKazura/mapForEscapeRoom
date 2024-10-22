package com.escapeRoomMap;

import java.util.List;

public class GameDTO {

    private int id;
    private String name;
    private RoomDTO firstRoom;
    private int howManyRooms;
    private int activeRoom;
    private List<ConnectionView> connections;
    private List<RoomDTO> rooms;


    public GameDTO() {
    }

    public GameDTO(int id,String name, int howManyRooms, RoomDTO roomDTO, List<ConnectionView> connections, int activeRoom, List<RoomDTO>roomsList ) {
        this.id = id;
        this.name=name;
        this.howManyRooms=howManyRooms;
        this.firstRoom =roomDTO;
        this.connections = connections;
        this.activeRoom=activeRoom;
        this.rooms=roomsList;
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

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public List<ConnectionView> getConnections() {
        return connections;
    }

    public int getActiveRoom() {
        return activeRoom;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstRoom(RoomDTO firstRoom) {
        this.firstRoom = firstRoom;
    }

    public void setConnections(List<ConnectionView> connections) {
        this.connections = connections;
    }

    public void setActiveRoom(int activeRoom) {
        this.activeRoom = activeRoom;
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
