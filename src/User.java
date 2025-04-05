package src;

public class User {
    private String username;
    private int score;

    // Constructor
    public User(String username, int score) {
        this.username = username;
        this.score = score;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // toString method to display user details
    @Override
    public String toString() {
        return "Username: " + username + ", Score: " + score;
    }
}