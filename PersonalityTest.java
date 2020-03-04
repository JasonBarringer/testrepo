import java.util.*;
import java.io.*;

public class PersonalityTest {


    //Main method, throws file not found exception of course.
    //This one makes a console scanner, calls the method to prompt the user for the file names,
    //makes a file scanner from the input, and makes a print stream from the output.
    //Finally, it calls interpretFile with the filescanner and printstream.
    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        String[] files = getFiles(console);
        Scanner fileScanner = new Scanner(new File(files[0]));
        PrintStream output = new PrintStream(new File(files[1]));
        interpretFile(fileScanner, output);
    }


    //Method getFiles prints the intro text and prompts the user for the names of the input and output files.
    //parameters: console scanner
    //Returns: String[], with [0] = input file name, and [1] = output file name
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
    Method interpretFile accepts a file scanner and a printstream output.
    For each pair of lines in the file, it stores the name and stores the answers both as a String
    It then creates a size 4 integer array by calling getPercentages with the answer String.
    This array contains the percentages of the frequency of the response being B for each category
    This is then converted into the personality type string by calling getType with the array of percentages.
    The results are then printed to the output file.
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
    Method getPercentages accepts the String of answers and returns an integer array with length 4 that
    contians the percentage of B responses in each category.
    First, it creates an array to count both the amount of A and B responses
    Then, it reads the String and counts the responses.
    Finally, it uses the values from the A and B counts arrays to calculate the percent B answers.
    this percent B array is returned.
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
            if(answer == '-');
        }

        for(int i = 0; i < 4; i++){
            BPercent[i] =  (int)Math.round(BCounts[i] * 100.0 / (ACounts[i] + BCounts[i]));
        }
        return BPercent;
    }


    /*
    method getType accepts the integer array of percentage B responses and returns the corresponding
    personality type as a String
    It does this by creating a blank string, adding the results of the letter method four times, then returning 
    the string.
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
