package learn.game.controller;

import learn.game.model.GameSession;
import learn.game.service.GameService;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService service;
    // For a simple lab, we'll use one ID. In a real app, the client sends the ID.
    private final String sessionId = "player-1";

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public GameSession getStatus() {
        return service.get(sessionId);
    }

    @PostMapping("/guess")
    public GameSession guess(@RequestParam int guess) {
        return service.makeGuess(sessionId, guess);
    }

    @PostMapping("/reset")
    public GameSession reset() {
        return service.startNewGame(sessionId);
    }
}