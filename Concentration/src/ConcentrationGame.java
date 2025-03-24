
import java.util.Scanner;

public class ConcentrationGame {
    private Deck deck;
    private Player player1;
    private Player highScore;
    public Card[][] board;
    private final int BOARD_SIZE = 4;

    ConcentrationGame() {
        deck = new Deck();
        board = new Card[BOARD_SIZE][BOARD_SIZE]; // concentration board
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = deck.dealCard();
            }
        }
    }

    private String padLeft(String txt) {
        StringBuilder sb = new StringBuilder();
        int totalPad = 8 - txt.length();
        for (int i = 0; i < totalPad / 2; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String padRight(String txt) {
        int mod = (txt.length() % 2 == 0 ? 0 : 1);
        StringBuilder sb = new StringBuilder();
        int totalPad = 8 - txt.length();
        for (int i = 0; i < totalPad / 2 + mod; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public boolean isSolved() {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                if (!board[i][j].faceUp)
                    return false;
        return true;
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
                    sb.append(" | ").append(padLeft(val)).append(val).append(padRight(val)).append("|");
                    val = board[i][j].getSuit();
                    sb2.append(" | ").append(padLeft(val)).append(val).append(padRight(val)).append("|");
                } else {
                    sb.append(" |         |");
                    sb2.append(" |         |");
                }
            }
            System.out.println(sb.toString() + "\n" + sb2.toString());
            System.out.println(" |         | |         | |         | |         |");
            System.out.println(" ----------- ----------- ----------- -----------");
        }
    }

    public static void main(String[] args) {
        ConcentrationGame game = new ConcentrationGame();
        Scanner scan = new Scanner(System.in);
        int score = (int)Math.pow(game.BOARD_SIZE,2);
        while (!game.isSolved()) {
            System.out.print("Enter two cards to evaluate by specifying the row and column in the form: r1 c1 r2 c2");
            int row1 = scan.nextInt();
            int col1 = scan.nextInt();
            int row2 = scan.nextInt();
            int col2 = scan.nextInt();
            game.board[row1 - 1][col1 - 1].faceUp = true;
            game.board[row2 - 1][col2 - 1].faceUp = true;
            game.displayBoard();
            if (game.board[row1 - 1][col1 - 1].getValue().equals(game.board[row2 - 1][col2 - 1])) {
                System.out.println("Match!");
                score++;

            } else {
                game.board[row1 - 1][col1 - 1].faceUp = false;
                game.board[row2 - 1][col2 - 1].faceUp = false;
                score--;
                if (score == 0) {
                    System.out.println("Game Over!");
                    break;
                }
            }
            System.out.println("Current Score: " + score);
        }
    }


}
