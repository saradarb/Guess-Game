package learn.game.service;

import learn.game.model.GameSession;

import java.util.Scanner;

public class GameService {
    Scanner scanner = new Scanner(System.in);

    public GameSession startGame() {
        GameSession gameSession = new GameSession();
        int winnerNumber = gameSession.getTargetNumber();

        System.out.println("Entre a number[1-100]: ");
        int playerNumber = Integer.parseInt(scanner.nextLine());

        int attempts = gameSession.getAttempts();

        while (attempts < 5) {

            if (playerNumber == winnerNumber) {
                gameSession.isWinner = true;
                gameSession.setStatus("Your winner is " + winnerNumber);
            } else if (playerNumber < winnerNumber) {
                gameSession.setStatus("Your guess too low");
            } else if (playerNumber > winnerNumber) {
                gameSession.setStatus("Your guess too high");
            } else if (playerNumber - winnerNumber == 3) {
                gameSession.setStatus("Your are so close");
            }
        }

        attempts++;

    return null;
    };
}
