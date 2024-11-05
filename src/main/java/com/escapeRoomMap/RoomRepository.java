package com.escapeRoomMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer>, CustomRoomRepository{

   /* @Query("select r.id from Room r where r.game.id = :gameId")
    List<Integer> getRoomIdsByGame(int gameId);

    @Query("from Room r where r.game.id = :gameId and r.nextRoom is not null")
    List<ConnectionView> getConnectionsView(int gameId);*/





    //derived query -> z nazwy metody
    //hql - JPQL -> uproszczony sql od strony obiektowej
            //?1 ?2 -> parametr 1 parametr dwa
            //:nazwaParametru
    //sql ->dosłowny sql - operowanie na id

    //@Query(nativeQuery = true,value = "")

}
