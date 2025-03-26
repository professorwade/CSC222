import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to Concentration! What is your name? ");
        String name = scan.next();
        System.out.println("Welcome " + name);
        ConcentrationGame game = new ConcentrationGame(name);

        // game loop
        while (!game.isSolved()) {
            ConcentrationGame.GameState state;
            System.out.print("Guess two cards by specifying the rows and columns: r1 c1 r2 c2 > ");
            int row1 = scan.nextInt();
            int col1 = scan.nextInt();
            int row2 = scan.nextInt();
            int col2 = scan.nextInt();
            state = game.setGuess(row1, col1, row2, col2);
            if (state == ConcentrationGame.GameState.RE_GUESS)
                continue;
            if (state == ConcentrationGame.GameState.GAME_OVER)
                break; // terminate game
            System.out.print("Want a peek for a point? Y or N");
            char answer = scan.next().charAt(0);
            if (Character.toUpperCase(answer) == 'Y') {
                state = game.setGuess(5); // allow peek for 1 second
                if (state == ConcentrationGame.GameState.GAME_OVER)
                    break;
            }

        }
        if (game.isSolved()) {
            System.out.println("Congratulations! " + game.getName() +
                    "You solved the board. Your final score is " + game.getScore());
            if (game.getHighScore() < game.getScore()) {
                System.out.println("You have a new high score!");
                game.setHighScore(game.getScore());
            }
        }
    }
}

