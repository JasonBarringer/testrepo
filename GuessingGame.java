// Jason Barringer
// 02/11/2020
// CSE142
// TA: Esther Chien
// Assignment #5
//
// With this program, the user will be able to play a game where they guess a random munber.
// To be perfectly honest, I've played the game several times, and it's not all that fun.
// I could probably come up with a more fun game in like 10 minutes.

import java.util.*;

public class GuessingGame {

    //This is the max value of the random number. It's 100... or you could change it? Jk, jk... Unless?
    public static final int max = 100;

    //This is where the magic happens baby, the main method.
    //Okay soooo basically, it calls the haiku method, then runs the meat of the program
    //First, it runs that sweet playGame method and stores it into a variable
    //it initalizes all of the other variables too! (Wow!)
    //Then there's a while loop (neat!) If I'm being honest I'm not sure if thats even allowed!
    //It keeps track of all them fun variables, and repeatedly calls the
    //playGame and playAgain methods
    //then, finally, it prints the results with the variables its been counting
    public static void main(String[] args){
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        haiku();

        int guesses = playGame(r,s);;
        int games = 1;
        int best = guesses;
        int totalGuesses = guesses;
        
        while(playAgain(s)) {
            guesses = playGame(r, s);
            totalGuesses += guesses;
            if(guesses < best) {
                best = guesses;
            }
            games += 1;
        }
        printResults(best, totalGuesses, games);

    }

    //Zoo wee mama! This is the playGame method!
    //It's pretty simple, it just generates a random number, asks you to guess, records 
    //your guess, compares it to the answer, and tells you what your whole deal is. 
    //I want to clarify here that I asked if I could use a do-while loop and he said I could
    //so I'm not sure if we learned it in class but please don't take off points.
    //I used the do-while loop because I hadn't initialized guess yet the first time
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

    //This fun method asks you if you want to play again... and then it lets you play
    //again if you want to. It also uses that nice toUpperCase method to make it easier
    //to test the string. I'm not gonna lie to you, I spend more time on these comments than
    //I do on the programs themselves, so I hope you appreciate them
    public static boolean playAgain(Scanner s) {
        System.out.print("Do you want to play again? ");
        String answer = s.next().toUpperCase();
        if(answer.charAt(0) == 'Y') {
            return true;
        } else {
            return false;
        }
    }

    //printResults prints the results, but I didn't have to tell you that
    //It lines up all the = signs, which is kinda neat I guess. 
    public static void printResults(int best, int totalGuesses, int games) {
        System.out.println("\nOverall results:");
        System.out.println("Total games   = " + games);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/game  = %.1f\n", (double)totalGuesses / games);
        System.out.println("Best game     = " + best);
    }

    //This method prints out the haiku that I wrote for this program. The haiku is designed
    //to fit the game that the user will be playing.
    //First, it lets the player know that the number will be completely random.
    //Next, it alerts the user that they will be trying to guess that number.
    //Now, this kind of task can seem daunting and may turn some players off of this experience,
    //so the third and final line is there to comfort the player and let them know that
    //the game really isn't all that hard.
    public static void haiku() {
        System.out.println("A random number\nTry to guess it if you can\nIt's not all that hard");
    }
}