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

   List<ConnectionView> getConnectionsDts(){
        List<ConnectionView> connectionViews=new ArrayList<>();
        for(Room room : nextRooms ){
            ConnectionDTO connectionDTO = new ConnectionDTO(id, room.id);
            connectionViews.add(connectionDTO);
        }
        return connectionViews;
    }
}
