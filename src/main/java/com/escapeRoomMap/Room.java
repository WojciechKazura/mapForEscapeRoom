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

    @Transient
    private  List<Room> connectionsRoom;

    public Room() {

    }



    public Room(Game game) {
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

    public List<Room> getConnectionsRoom() {
        return connectionsRoom;
    }

    public void setConnectionsRoom(List<Room> connectionsRoom) {
        this.connectionsRoom = connectionsRoom;
    }

    RoomDTO covertRoomToRoomDTO() {
        return new RoomDTO(id);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", game=" + game +
                ", connectionsRoom=" + connectionsRoom +
                '}';
    }
}
