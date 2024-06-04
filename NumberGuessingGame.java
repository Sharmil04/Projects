import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String play = "yes";

        while (play.equalsIgnoreCase("yes")) {
            playGame(sc);
            System.out.println("Would you like to play again? Yes or No:");
            play = sc.next();
        }
        sc.close();
    }

    private static void playGame(Scanner sc) {
        Random random = new Random();
        int targetNumber = random.nextInt(101); // Range 0 to 100 inclusive
        int guess = -1;
        int tries = 0;

        System.out.println("Guess a number between 0 and 100:");

        while (guess != targetNumber) {
            guess = getValidGuess(sc);
            tries++;

            if (guess == targetNumber) {
                System.out.println("Hey..Awesome! You guessed the number");
                System.out.println("You took only " + tries + " tries to guess the correct number.");
            } else if (guess > targetNumber) {
                System.out.println("Oops...Your guess is too high...Try again.");
            } else {
                System.out.println("Oops..Your guess is too low...Try again.");
            }
        }
    }

    private static int getValidGuess(Scanner sc) {
        while (true) {
            try {
                System.out.print("Enter your guess: ");
                return Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer between 0 and 100.");
            }
        }
    }
}
