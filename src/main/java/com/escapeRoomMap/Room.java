package com.escapeRoomMap;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Game game;

    @OneToOne(cascade = CascadeType.ALL)
    private Room nextRoom;

    public Room() {

    }

    public Room(Game game) {
        this.game =game;
    }

    public Room(Room nextRoom,Game game) {
        this.nextRoom = nextRoom;
        this.game = game;
    }

    public int getId() {
        return id;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    RoomDTO covertRoomToRoomDTO() {
        RoomDTO nextRoomDTO=null;
        if (nextRoom != null) {
            nextRoomDTO = nextRoom.covertRoomToRoomDTO();
        }
        return new RoomDTO(id, nextRoomDTO);
    }

}
