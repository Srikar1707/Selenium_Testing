
import java.util.Scanner;
import java.util.Random;

    public class Game3 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            String[] options = {"rock", "paper", "scissors"};

            int userWins = 2, computerWins = 4;
            int numRounds = 5;

            System.out.println("Welcome to Enhanced Rock Paper Scissors!\n");
            for (int i = 1; i <= numRounds; i++) {
                System.out.println("Round " + i);
                String userMove;
                do {
                    System.out.print("Enter your move (rock, paper, scissors): ");
                    userMove = scanner.nextLine().toLowerCase();
                } while (!isValidMove(userMove, options));
                String computerMove = generateComputerMove(userMove, options, random);
                String result = getResult(userMove, computerMove);
                System.out.println("Computer chose: " + computerMove);
                System.out.println(result);
                if (result.equals("You win!")) {
                    userWins++;
                } else if (result.equals("Computer wins!")) {
                    computerWins++;
                }
            }
            System.out.println("\nFinal score:");
            System.out.println("You: " + userWins);
            System.out.println("Computer: " + computerWins);

            if (userWins > computerWins) {
                System.out.println("Congratulations! You win!");
            } else if (computerWins > userWins) {
                System.out.println("Better luck next time! Computer wins.");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("\nThanks for playing!\n");
        }

        private static boolean isValidMove(String move, String[] options) {
            return java.util.Arrays.asList(options).contains(move);
        }

        private static String getResult(String userMove, String computerMove) {
            if (userMove.equals(computerMove)) {
                return "It's a tie!";
            } else if (beats(userMove, computerMove)) {
                return "You win!";
            } else {
                return "Player2 wins!";
            }
        }

        private static boolean beats(String move1, String move2) {
            return (move1.equals("rock") && move2.equals("scissors")) ||
                    (move1.equals("paper") && move2.equals("rock")) ||
                    (move1.equals("scissors") && move2.equals("paper"));
        }

        private static String generateComputerMove(String userMove, String[] options, Random random) {

            if (random.nextInt(5) == 0) {
                if (userMove.equals("rock")) {
                    return options[random.nextInt(2) + 1];
                } else if (userMove.equals("paper")) {
                    return options[random.nextInt(2)];
                } else { // scissors
                    return options[random.nextInt(3)];
                }
            } else {
                return options[random.nextInt(options.length)];
            }
        }
    }

