package com.escapeRoomMap;

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

    GameDTO saveGame(GameDTO gameDTO) {
        Game game = new Game(gameDTO.getName(), gameDTO.getHowManyRooms());
        gameRepository.save(game);
        gameDTO.setFirstRoom(game.getFirtRoom().covertRoomToRoomDTO());
        gameDTO.setId(game.getId());
        gameDTO.setConnections(getConnections(game.getId()));
        gameDTO.setActiveRoom(game.getActiveRoom().getId());
        return gameDTO;
    }

    GameDTO getGame(int id) {
        Game game = gameRepository.getReferenceById(id);
        return new GameDTO(id, game.getName(),
                game.getHowManyRooms(),
                game.getFirtRoom().covertRoomToRoomDTO(),
                getConnections(game.getId()),
                game.getActiveRoom().getId());
    }


    List<ConnectionView> getConnections(int gameId) {
        return roomRepository.getConnectionsView(gameId);
    }
    void move(int nextRoomId, int gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        List<ConnectionView> connections = getConnections(gameId);
        boolean isConnection = false;
        for (ConnectionView connection : connections) {
            if (connection.getConnections().containsAll(List.of(nextRoomId,game.getActiveRoom().getId()))){
                isConnection = true;
            }
        }
        if(isConnection){
            game.setActiveRoom(roomRepository.findById(nextRoomId).orElseThrow());
            gameRepository.save(game);
        }else{
            throw new IllegalStateException("Nie udało się wykonać takiego ruchu");
        }


    }


}
