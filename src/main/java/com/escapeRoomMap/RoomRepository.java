package com.escapeRoomMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer>{

    @Query("from Room r where r.game.id = :gameId")
    List<Room> getRooms(int gameId);
    
}
