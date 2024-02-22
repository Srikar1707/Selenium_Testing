import java.util.Scanner;

public class  Game2{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] options = {"rock", "paper", "scissors"};

        while (true) {
            System.out.print("Player 1, enter your move (rock, paper, scissors, or quit): ");
            String player1Move = scanner.nextLine().toLowerCase();

            if (player1Move.equals("quit")) {
                break;
            }
            if (!isValidMove(player1Move, options)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            System.out.print("Player 2, enter your move (rock, paper, scissors, or quit): ");
            String player2Move = scanner.nextLine().toLowerCase();

            if (player2Move.equals("quit")) {
                break;
            }

            if (!isValidMove(player2Move, options)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            String result = getResult(player1Move, player2Move);
            System.out.println(result);
        }

        System.out.println("Thanks for playing!");
    }

    private static boolean isValidMove(String move, String[] options) {
        return java.util.Arrays.asList(options).contains(move);
    }

    private static String getResult(String player1Move, String player2Move) {
        if (player1Move.equals(player2Move)) {
            return "It's a tie!";
        } else if (beats(player1Move, player2Move)) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }

    private static boolean beats(String move1, String move2) {
        return (move1.equals("rock") && move2.equals("scissors")) ||
                (move1.equals("paper") && move2.equals("rock")) ||
                (move1.equals("scissors") && move2.equals("paper"));
    }
}
