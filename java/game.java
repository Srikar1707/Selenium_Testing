import java.util.Random;
import java.util.Scanner;



        public class game {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();

                String[] options = {"rock", "paper", "scissors"};

                while (true) {
                    System.out.print("Enter your move (rock, paper, scissors, or quit): ");
                    String playerMove = scanner.nextLine().toLowerCase();

                    if (playerMove.equals("quit")) {
                        break;
                    }

                    if (!isValidMove(playerMove, options)) {
                        System.out.println("Invalid move. Please try again.");
                        continue;
                    }

                    String computerMove = options[random.nextInt(options.length)];
                    System.out.println("Computer chose: " + computerMove);

                    String result = getResult(playerMove, computerMove);
                    System.out.println(result);
                }

                System.out.println("Thanks for playing!");
            }

            private static boolean isValidMove(String move, String[] options) {
                return java.util.Arrays.asList(options).contains(move);
            }

            private static String getResult(String playerMove, String computerMove) {
                if (playerMove.equals(computerMove)) {
                    return "It's a tie!";
                } else if (playerMove.equals("rock")) {
                    return computerMove.equals("scissors") ? "You win!" : "You lose!";
                } else if (playerMove.equals("paper")) {
                    return computerMove.equals("rock") ? "You win!" : "You lose!";
                } else { // scissors
                    return computerMove.equals("paper") ? "You win!" : "You lose!";
                }
            }
        }
