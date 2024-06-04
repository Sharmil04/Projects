import java.util.*;
public class RockPaperScissor{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"rock", "paper", "scissors"};
        int userScore = 0;
        int computerScore = 0;
        
        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your move (rock, paper, scissors). To exit the game, type exit: ");
            String userMove = scanner.nextLine().toLowerCase();

            if (userMove.equals("exit")) {
                System.out.println("Thanks for playing! Final Score - You: " + userScore + ", Computer: " + computerScore);
                break;
            }

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            int randomIndex = random.nextInt(3);
            String computerMove = choices[randomIndex];

            System.out.println("Computer move: " + computerMove);

            if (userMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if ((userMove.equals("rock") && computerMove.equals("scissors")) ||
                       (userMove.equals("paper") && computerMove.equals("rock")) ||
                       (userMove.equals("scissors") && computerMove.equals("paper"))) {
                System.out.println("You win!");
                userScore++;
            } else {
                System.out.println("You lose!");
                computerScore++;
            }

            System.out.println("Current Score - You: " + userScore + ", Computer: " + computerScore);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Final Score - You: " + userScore + ", Computer: " + computerScore);
                break;
            }
        }
        
        scanner.close();
    }
}
