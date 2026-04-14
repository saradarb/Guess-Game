package learn.game.service;

import learn.game.model.GameSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class GameService {

    private final Map<String, GameSession> sessions = new HashMap<>();
    private final Random random = new Random();

    // 1. The Gatekeeper
    public GameSession get(String id) {
        // We use a lambda here. It will only call createFreshGame if the ID is missing.
        return sessions.computeIfAbsent(id, k -> createFreshGame());
    }

    // 2. The Reset/Start Logic
    public GameSession startNewGame(String id) {
        GameSession session = createFreshGame();
        sessions.put(id, session); // Manual put is safe here because it's not inside computeIfAbsent
        return session;
    }

    // 3. The Object Creator
    // This is private because only the Service should use it to build the game object.
    private GameSession createFreshGame() {
        GameSession session = new GameSession();
        session.setTargetNumber(random.nextInt(1, 101));
        session.setAttempts(0);
        session.setStatus("New game started! Guess a number between 1 and 100.");
        session.setWinner(false);
        return session; // No sessions.put() here!
    }

    // 4. The Game Logic
    public GameSession makeGuess(String id, int guess) {
        GameSession session = get(id);

        if (session.isWinner() || session.getAttempts() >= 5) {
            return session;
        }

        session.setAttempts(session.getAttempts() + 1);
        int target = session.getTargetNumber();

        if (guess == target) {
            session.setWinner(true);
            session.setStatus("Winner! The number was " + target);
        } else if (Math.abs(guess - target) <= 3) {
            session.setStatus("You are so close!");
        } else if (guess < target) {
            session.setStatus("Too low.");
        } else {
            session.setStatus("Too high.");
        }

        if (!session.isWinner() && session.getAttempts() >= 5) {
            session.setStatus("Game Over. The number was " + target);
        }

        return session;
    }
}