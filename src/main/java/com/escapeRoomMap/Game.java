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
    @Transient
    private double chanceForSplit= 1.0;

    public Game() {
    }

    public Game(String name, int howManyRooms) {
        this.name = name;
        this.howManyRooms = howManyRooms;
        ////
        firtRoom = new Room(this);
        createRooms(firtRoom);
        this.activeRoom = firtRoom;
        System.out.println("Nowa gra");
        Room.nextId=1;
    }

    public void createRooms(Room room){
        List<Room> roomList= createConnections();
        room.setNextRooms(roomList);
        System.out.println(room);
        for(Room next : roomList){
           createRooms(next);
        }
    }

    public List<Room> createConnections() {
        Random random = new Random();
        double splitChance = random.nextDouble();
        List<Room> roomList = new ArrayList<>();
        if (splitChance < chanceForSplit) {
            for (int i = 0; i < 2; i++) {
                Room nextRoom = new Room(this);
                roomList.add(nextRoom);
            }
            chanceForSplit=chanceForSplit-0.05;
            return roomList;
        }
        double soloChance = random.nextDouble();
        if (soloChance < 0.5) {
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
