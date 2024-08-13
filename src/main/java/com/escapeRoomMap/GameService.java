package com.escapeRoomMap;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameService {

    private RoomRepository roomRepository;
    private GameRepository gameRepository;



    public GameService(RoomRepository roomRepository, GameRepository gameRepository) {
        this.roomRepository = roomRepository;
        this.gameRepository = gameRepository;


    }

    @PostConstruct
    void vieRoomId(){
        System.out.println(roomRepository.getRoomIdsByGame(1));
    }

    GameDTO saveGame(GameDTO gameDTO) {
        Game game = new Game(gameDTO.getName(), gameDTO.getHowManyRooms());
        gameRepository.save(game);
        gameDTO.setFirstRoom(game.getFirtRoom().covertRoomToRoomDTO());
        gameDTO.setId(game.getId());
        System.out.println(gameDTO);
        return gameDTO;
    }

    GameDTO getGame(int id) {
        Game game = gameRepository.getReferenceById(id);
        System.out.println(game.getFirtRoom().covertRoomToRoomDTO());
        return new GameDTO(id, game.getName(), game.getHowManyRooms(), game.getFirtRoom().covertRoomToRoomDTO(), getConnections(game.getId()));
    }


    List<ConnectionView> getConnections(int gameId) {
        System.out.println(roomRepository.getConnectionsView(gameId));
        roomRepository.getConnectionsView(gameId).stream().forEach(con -> System.out.println(con.getId() + " " + con.getNextRoomId()));
       return roomRepository.getConnectionsView(gameId);
    }


}