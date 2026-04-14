package learn.game.model;

public class GameSession {
    // Fields should be private to protect the data
    private int targetNumber;
    private int attempts = 0;
    private String status;
    private boolean winner = false; // Standard naming: 'winner' or 'isWinner'

    // Multi-argument constructor
    public GameSession(int targetNumber, int attempts, String status, boolean winner) {
        this.targetNumber = targetNumber;
        this.attempts = attempts;
        this.status = status;
        this.winner = winner;
    }

    // Default constructor (Needed by Spring/Jackson)
    public GameSession() {
    }

    // --- GETTERS AND SETTERS ---
    // Note: We removed the 'Random' logic from here.
    // The Model should be "dumb"—it just stores data.

    public int getTargetNumber() {
        return targetNumber;
    }

    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Boolean getters usually start with 'is'
    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}