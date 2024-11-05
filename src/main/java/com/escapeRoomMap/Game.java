package com.escapeRoomMap;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Entity
public class Game {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Room firtRoom;
    @OneToOne
    private Room activeRoom;
    private int howManyRooms;


    public Game() {
    }




    public Game(String name, int howManyRooms) {
        this.name = name;
        this.howManyRooms = howManyRooms;
        ////
        firtRoom = new Room(this);
        createRooms(firtRoom);
        System.out.println(firtRoom);
        this.activeRoom = firtRoom;
//        Room beforeRoom = firstRoom;
//        for (int i = 0; i < howManyRooms - 1; i++) {
//            Room room = new Room(this);
//            beforeRoom.setNextRoom(room);
//            beforeRoom = room;
//        }
    }

    public void createRooms(Room room){
        List<Room> roomList= createConnections();
        room.setConnectionsRoom(roomList);
        for(Room next : roomList){
           createRooms(next);
        }
    }

    public List<Room> createConnections() {
        Random random = new Random();
        double howManyConnections = random.nextDouble();
        List<Room> roomList = new ArrayList<>();
        if (howManyConnections < 0.3) {
            for (int i = 0; i < 2; i++) {
                Room nextRoom = new Room(this);
                roomList.add(nextRoom);
            }
        } else if (howManyConnections < 0.8) {
            Room nextRoom = new Room(this);
            roomList.add(nextRoom);
        }
        return roomList;
    }



    public int getId() {
        return id;
    }

    public int getHowManyRooms() {
        return howManyRooms;
    }

    public String getName() {
        return name;
    }

    public Room getFirtRoom() {
        return firtRoom;
    }

    public Room getActiveRoom() {
        return activeRoom;
    }

    public void setActiveRoom(Room activeRoom) {
        this.activeRoom = activeRoom;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
