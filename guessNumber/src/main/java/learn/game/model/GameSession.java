package learn.game.model;

import java.util.Random;

public class GameSession {
    public int targetNumber;
    public int attempts = 0;
    public String status;
    public boolean isWinner = false;

    public GameSession(int targetNumber, int attempts, String status, boolean isWinner) {
        this.targetNumber = targetNumber;
        this.attempts = attempts;
        this.status = status;
        this.isWinner = isWinner;
    }

    public GameSession() {
    }

    Random random = new Random();

    public int getTargetNumber() {
        targetNumber = random.nextInt(1,100);
        return targetNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getStatus() {
        return status;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }
}




