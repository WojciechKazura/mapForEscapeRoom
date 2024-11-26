package com.escapeRoomMap;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    private RoomRepository roomRepository;
    private GameRepository gameRepository;

    public GameService(RoomRepository roomRepository, GameRepository gameRepository) {
        this.roomRepository = roomRepository;
        this.gameRepository = gameRepository;
    }

    GameDTO saveGame(GameDTO gameDTO) {
        Game game = new Game(gameDTO.getName(), gameDTO.getHowManyRooms());
        gameRepository.save(game);
        return mapToDTO(game);
    }

    GameDTO getGame(int id) {
        Game game = gameRepository.getReferenceById(id);
        return mapToDTO(game);
    }

    GameDTO mapToDTO(Game game) {
        List<Room> rooms = roomRepository.getRooms(game.getId());
        return new GameDTO(game.getId(), game.getName(),
                game.getHowManyRooms(),
                game.getFirtRoom().covertRoomToRoomDTO(),
                getConnections(game.getId()),
                game.getActiveRoom().getId(),
                rooms.stream().map(room -> new RoomDTO(room.getId())).toList());
    }


    List<ConnectionDTO> getConnections(int gameId) {
        List<Room> rooms = roomRepository.getRooms(gameId);
        List<ConnectionDTO> connectionViews = new ArrayList<>();
       for(Room room: rooms){
           connectionViews.addAll(room.getConnectionsDts());
       }
        return connectionViews;
    }

    void move(int nextRoomId, int gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        List<ConnectionDTO> connections = getConnections(gameId);
        boolean isConnection = false;
        for (ConnectionDTO connection : connections) {
            if (connection.getConnections().containsAll(List.of(nextRoomId, game.getActiveRoom().getId()))) {
                isConnection = true;
            }
        }
        if (isConnection) {
            game.setActiveRoom(roomRepository.findById(nextRoomId).orElseThrow());
            gameRepository.save(game);
        } else {
            throw new IllegalStateException("Nie udało się wykonać takiego ruchu");
        }


    }


}
