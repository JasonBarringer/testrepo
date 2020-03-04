// Jason Barringer
// 03/3/2020
// CSE142
// TA: Esther Chien
// Assignment #6
//
// This program interprets the results of personality tests from an input file and prints the
// results to an output file.

import java.util.*;
import java.io.*;

public class PersonalityTest {

    /*
    Main method throws file not found exception
    Creates console scanner, calls getFiles method to get the file names from the user
    creates file scanner and printstream output from the files specified by the user
    calls interpret file method with the filescanner and output
    */
    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        String[] files = getFiles(console);
        Scanner fileScanner = new Scanner(new File(files[0]));
        PrintStream output = new PrintStream(new File(files[1]));
        interpretFile(fileScanner, output);
    }

    /*
    getFiles method accepts console scanner and returns string array of size 2
    the array[0] is the input file and [1] is the output file
    creates empty array, prints intro to console, prompts user for file names and stores them
    to the array, returns array.
    */
    public static String[] getFiles(Scanner console) {
        String[] files = new String[2];
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter.  It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.\n");

        System.out.print("input file name? ");
        files[0] = console.nextLine();
        System.out.print("output file name? ");
        files[1] = console.nextLine();
        return files;
    }

    /*
    Interpret file accepts Scanner filescanner and PrintStream output, no returns
    for each line pair in the file of the file scanner, method stores the first line as the name
    and the second as the answers string.
    Calls getpercentages method with the answers string to get the percent of b reponses
    Calls getType with the b percentage to get the personality type corresponding with the answers
    prints the results to the output file.
    */
    public static void interpretFile(Scanner fileScanner, PrintStream output) {
        while(fileScanner.hasNextLine()) {
            String name = fileScanner.nextLine();
            String answers = fileScanner.nextLine().toUpperCase();
            int[] BPercent = getPercentages(answers);
            String type = getType(BPercent);
            output.print(name + ": [");
            for(int i = 0; i < 3 ; i++) {
                output.print(BPercent[i] + ", ");
            }
            output.println(BPercent[3] + "] = " + type);
        }
    }

    /*
    method getPercentages accepts a String answers and returns an integer array of size 4 with the
    percentages of b responses for each personality type category
    Creates size four arrays for the a responses and b responses 
    for each character in the answers string, the arrays tally the response in either the a counts
    array or the b counts array
    for each of the four categories, b percent array[i] is set to the percentage of b answers of 
    total answers for category i
    returns b percent array
    */
    public static int[] getPercentages(String answers) {
        int[] ACounts = new int[4];
        int[] BCounts = new int[4];
        int[] BPercent = new int[4];
        for(int i = 0; i < answers.length(); i++) {
            int question = (i % 7 + 1) / 2;
            char answer = answers.charAt(i);
            if(answer == 'A') ACounts[question]++;
            if(answer == 'B') BCounts[question]++;
        }

        for(int i = 0; i < 4; i++){
            BPercent[i] =  (int)Math.round(BCounts[i] * 100.0 / (ACounts[i] + BCounts[i]));
        }
        return BPercent;
    }

    /*
    getType method accepts integer array of size 4 B percent and returns String that represents 
    personality type
    creates empty string
    adds to string result of letter method with bpercent [0], [1], [2], [3] and with corresponding
    letters
    returns finished string
    */
    public static String getType(int[] BPercent) {
        String type = "";
        type += letter(BPercent[0], 'E', 'I');
        type += letter(BPercent[1], 'S', 'N');
        type += letter(BPercent[2], 'T', 'F');
        type += letter(BPercent[3], 'J', 'P');
        return type;
    }

    /*
    Method letter accepts a percentage as an integer, a char A, and a char B.
    It returns a char.
    This is pretty much just a method to reduce redundancy when creating the String
    It tests the percentage of responses and returns the corresponding letter, determined
    either by the input characters or the X if the percentage is 50
    */
    public static char letter(int percent, char a, char b) {
        if(percent < 50){
            return a;
        } else if(percent > 50) {
            return b;
        } else {
            return 'X';
        }
    }
}
