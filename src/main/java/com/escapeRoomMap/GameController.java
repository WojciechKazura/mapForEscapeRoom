package com.escapeRoomMap;

import org.springframework.http.ResponseEntity;
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
    GameDTO createGame(@RequestBody GameDTO gameDTO){
        GameDTO gameDTO1 = gameService.saveGame(gameDTO);
        return gameDTO1;
    }

    @GetMapping("/games/{id}/connections")
    List<ConnectionDTO> getConnections(@PathVariable int id) {
        return gameService.getConnections(id);
    }

    @PostMapping("/games/{id}/moves")
    ResponseEntity<String> addMove(int nextRoomId, @PathVariable int id) {
       try {
           gameService.move(nextRoomId, id);
           return ResponseEntity.ok("Poprawnie wykonany ruch");
       } catch (IllegalStateException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
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
        return gameService.getGame(id);
    }

}
