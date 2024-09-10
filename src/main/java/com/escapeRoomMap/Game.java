package com.escapeRoomMap;

import jakarta.persistence.*;


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
        Room firstRoom = new Room(this);
        this.firtRoom = firstRoom;
        this.activeRoom = firstRoom;
        Room beforeRoom = firstRoom;
        for (int i = 0; i < howManyRooms-1; i++) {
            Room room = new Room(this);
            beforeRoom.setNextRoom(room);
            beforeRoom=room;
        }
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
