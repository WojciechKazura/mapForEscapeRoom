package com.escapeRoomMap;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    public List<RoomDTO> getConnectedRoomsId(){
        List<Integer>connectedRoomsId= new ArrayList<>();
        Room room = this;
        connectedRoomsId.add(room.getId());
        while (room.nextRoom!=null){
            connectedRoomsId.add(room.nextRoom.getId());
            room=room.nextRoom;
        }
        return connectedRoomsId.stream()
                .distinct()
                .map(RoomDTO::new)
                .toList();

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
        return new RoomDTO(id);
    }

}
