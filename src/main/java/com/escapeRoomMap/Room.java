package com.escapeRoomMap;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    public static int nextId = 1;
    private int debugId;

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Game game;

    @ManyToMany(cascade = CascadeType.ALL)
    private  List<Room> nextRooms;

    public Room() {
    }

    public Room(Game game) {
        debugId = nextId++;
        this.game = game;
    }

    public List<RoomDTO> getConnectedRoomsId(){
       /* List<Integer>connectedRoomsId= new ArrayList<>();
        Room room = this;
        connectedRoomsId.add(room.getId());
        while (room.nextRoom!=null){
            connectedRoomsId.add(room.nextRoom.getId());
            room=room.nextRoom;
        }
        return connectedRoomsId.stream()
                .distinct()
                .map(RoomDTO::new)
                .toList();*/


        return new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public List<Room> getNextRooms() {
        return nextRooms;
    }

    public void setNextRooms(List<Room> nextRooms) {
        this.nextRooms = nextRooms;
    }

    RoomDTO covertRoomToRoomDTO() {
        return new RoomDTO(id);
    }

    @Override
    public String toString() {
        String nextIds = "Next rooms: ";
        for (Room nextRoom : nextRooms) {
            nextIds +=nextRoom.debugId + ", ";
        }
        return "Room{" +
                "id=" + id +
                "debug=" + debugId +
                nextIds +
                '}';
    }
}
