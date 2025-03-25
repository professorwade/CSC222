public class Player {
    private int score;
    private int highScore;
    private String name;

    Player(String n, int boardSize) {
        score = boardSize * boardSize;
        highScore = 0;
        name = n;
    }

    /**
     * Get players high score
     * @return Players High Score
     */
    public int getHighScore() {
        return highScore;
    }

    /**
     * Set Players high score
     * @param highScore
     */
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /**
     * Retrieve players current score
     * @return
     */
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseScore() {
        score++;
    }

    public void decreaseScore() {
        score--;
    }
}
