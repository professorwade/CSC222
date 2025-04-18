public class ConcentrationGame {

    private final Player player;
    private final Card[][] board;
    private final int BOARD_SIZE = 4;

    public enum GameState {GUESS_AGAIN, GAME_OVER, RE_GUESS }

    ConcentrationGame(String name) {
        player = new Player(name, BOARD_SIZE);
        board = new Card[BOARD_SIZE][BOARD_SIZE];
        Deck deck = new Deck();
        // randomly deal out half the board

        while (!allPlaced()) {
            // randomly pick a place to deal a card
            int row, col;
            while (true) {
                row = (int) Math.round(Math.random() * (BOARD_SIZE - 1));
                col = (int) Math.round(Math.random() * (BOARD_SIZE - 1));
                if (board[row][col] == null) {
                    board[row][col] = deck.dealCard();
                    break;
                }
            }

            while (true) {
                int row2 = (int) Math.round(Math.random() * (BOARD_SIZE - 1));
                int col2 = (int) Math.round(Math.random() * (BOARD_SIZE - 1));
                if (board[row2][col2] == null) {
                    board[row2][col2] = deck.getValueMatch(board[row][col].getValue());
                    break;
                }
            }
        }
    }

    private boolean allPlaced() {
        boolean allPlaced = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == null) {
                    allPlaced = false;
                    break;
                }
            }
        }
        return allPlaced;
    }

    public void peek(int delay) throws InterruptedException {
        boolean[][] displayVal = new boolean[BOARD_SIZE][BOARD_SIZE];

        // make visible
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                displayVal[i][j] = board[i][j].faceUp;
                board[i][j].faceUp = true;
            }
        }

        displayBoard();
        Thread.sleep(delay * 1000L);
        clearScreen();

        // reset visibility
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j].faceUp = displayVal[i][j];
            }
        }
        displayBoard();
    }

    private void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    private String padLeft(String txt) {
        StringBuilder sb = new StringBuilder();
        int totalPad = 8 - txt.length();
        sb.append(" ".repeat(Math.max(0, totalPad / 2)));
        return sb.toString();
    }

    private String padRight(String txt) {
        int mod = (txt.length() % 2 == 0 ? 0 : 1);
        StringBuilder sb = new StringBuilder();
        int totalPad = 8 - txt.length();
        sb.append(" ".repeat(Math.max(0, totalPad / 2 + mod)));
        return sb.toString();
    }

    public boolean isSolved() {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                if (!board[i][j].faceUp)
                    return false;
        return true;
    }

    public int getScore() {
        return player.getScore();
    }
    public int getHighScore() { return player.getHighScore(); }
    public void setScore(int val) { player.setScore(val); }
    public void setHighScore(int val) { player.setHighScore(val);}
    public String getName() { return player.getName(); }

    public void setVisible(int r, int c, boolean visibility) {
        board[r][c].faceUp = visibility;
    }

    public GameState setGuess(int peekTime) throws InterruptedException {
        peek(peekTime);
        player.decreaseScore();
        if (player.getScore() == 0)
            return GameState.GAME_OVER;
        return GameState.GUESS_AGAIN;
    }

    /**
     * Enters two cards on the board to guess match
     * @param r1 - Row for Card 1
     * @param c1 - Column for Card 1
     * @param r2 - Row for Card 2
     * @param c2 - Column for Card 2
     * @return - GameState indicating the player can guess again or that the game is over
     */
    public GameState setGuess(int r1, int c1, int r2, int c2) {
        GameState state = GameState.GUESS_AGAIN;
        if (board[r1 - 1][c1 - 1].matched || board[r2 - 1][c2 - 1].matched) {
            System.out.println("Don't waste a guess on a matched card!");
            return GameState.RE_GUESS;
        }

        board[r1 - 1][c1 - 1].faceUp = true;
        board[r2 - 1][c2 - 1].faceUp = true;
        displayBoard();
        if (board[r1 - 1][c1 - 1].getValue().equals(board[r2 - 1][c2 - 1].getValue())) {
            System.out.println("Match!");
            board[r1 - 1][c1 - 1].matched = true;
            board[r2 - 1][c2 - 1].matched = true;
            player.increaseScore();
            return state;

        } else {
            setVisible(r1 - 1,c1 - 1,false);
            setVisible(r2 - 1,c2 - 1,false);

            board[r2 - 1][c2 - 1].faceUp = false;
            player.decreaseScore();
            if (player.getScore() == 0) {
                System.out.println("Game Over!");
                state = GameState.GAME_OVER;
            }
        }
        System.out.println("Current Score: " + getScore());
        return state;
    }

    public void displayBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.println(" ----------- ----------- ----------- -----------");
            System.out.println(" |         | |         | |         | |         | ");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].faceUp) {
                    String val = board[i][j].getValue();
                    if (board[i][j].matched) {
                        val = "*" + val + "*";
                    }
                    sb.append(" | ").append(padLeft(val)).append(val).append(padRight(val)).append("|");
                    val = board[i][j].getSuit();
                    sb2.append(" | ").append(padLeft(val)).append(val).append(padRight(val)).append("|");
                } else {
                    sb.append(" |         |");
                    sb2.append(" |         |");
                }
            }
            System.out.println(sb + "\n" + sb2);
            System.out.println(" |         | |         | |         | |         |");
            System.out.println(" ----------- ----------- ----------- -----------");
        }
    }
}
