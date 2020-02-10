import java.util.*;

public class GuessingGame {

    public static final int max = 100;

    public static void main(String[] args){
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        haiku();

        int guesses = playGame(r,s);;
        int games = 1;
        int best = guesses;
        int totalGuesses = guesses;
        
        while (playAgain(s)) {
            guesses = playGame(r, s);
            totalGuesses += guesses;
            if(guesses < best) {
                best = guesses;
            }
            games += 1;
        }
        printResults(best, totalGuesses, games);

    }

    public static int playGame(Random r, Scanner s) {
        int guesses = 0;
        int number = r.nextInt(max) + 1;
        int guess;
        System.out.println("\nI'm thinking of a number between 1 and " + max + "...");

        do{
            System.out.print("Your guess? ");
            guess = s.nextInt();
            if (guess < number) {
                System.out.println("It's higher.");
            }
            if (guess > number) {
                System.out.println("It's lower.");
            }
            guesses += 1;
        } while (guess != number);

        if(guesses == 1) {
            System.out.println("You got it right in " + guesses + " guess!");
        } else {
            System.out.println("You got it right in " + guesses + " guesses!");
        }

        return guesses;
    }

    public static boolean playAgain(Scanner s) {
        System.out.print("Do you want to play again? ");
        String answer = s.next().toUpperCase();
        if(answer.startsWith("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public static void printResults(int best, int totalGuesses, int games) {
        System.out.println("\nOverall results:");
        System.out.println("Total games   = " + games);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/game  = " + (double)totalGuesses / games);
        System.out.println("Best game     = " + best);
    }

    public static void haiku() {
        System.out.println("A random number\nTry to guess it if you can\nIt's not all that hard");
    }
}