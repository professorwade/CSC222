public class Player {
    private int score;

    /**
     * Get players high score
     * @return highscore
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

    private int highScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
