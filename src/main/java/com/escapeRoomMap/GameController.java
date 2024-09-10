package com.escapeRoomMap;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    private GameService gameService;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/games")
    GameDTO createGame(@RequestBody GameDTO gameDTO) {
        return gameService.saveGame(gameDTO);
    }

    @GetMapping("/games/{id}/connections")
    List<ConnectionView> getConnections(@PathVariable int id) {
        return gameService.getConnections(id);
    }

    @PostMapping("/games/{id}/moves")
    void addMove(int nextRoomId, @PathVariable int id) {
       gameService.move(nextRoomId, id);
    }


    //wyslanie przez ciało:   w zapytaniu ma być json w ciele np: { "id":1 }
   /* @GetMapping("/games")
    GameDTO getGameByBody(@RequestBody GameDTO gameDTO) {
        System.out.println("Szukam po id: " + gameDTO.getId());
        return gameService.getGame(gameDTO.getId());
    }*/

    //wysłanie przez parametr: w zapytaniu w ścieżce: localhost:8080/games?id=1
  /*  @GetMapping("/games")
    GameDTO getGame(int id) {
        System.out.println("Szukam po id: " + id);
        return gameService.getGame(id);
    }*/

    //bezpośrednio w ścieżce: localhost:8080/games/1

    @GetMapping("/games/{id}")
    GameDTO getGame(@PathVariable int id) {
        System.out.println("Szukam po id: " + id);
        return gameService.getGame(id);
    }

}
