import java.util.*;
import java.io.*;

public class PersonalityTest {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner console = new Scanner(System.in);
        String[] files = getFiles(console);
        Scanner fileScanner = new Scanner(new File(files[0]));
        PrintStream output = new PrintStream(new File(files[1]));
        interpretFile(fileScanner, output);
    }

    public static String[] getFiles(Scanner console) {
        String[] files = new String[2];
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.\n");

        System.out.print("input file name? ");
        files[0] = console.nextLine();
        System.out.print("output file name? ");
        files[1] = console.nextLine();
        return files;
    }

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
            BPercent[i] =  BCounts[i] * 100 / (ACounts[i] + BCounts[i]);
        }
        return BPercent;
    }

    public static String getType(int[] BPercent) {
        String type = "";
        type += letter(BPercent[0], "E", "I");
        type += letter(BPercent[1], "S", "N");
        type += letter(BPercent[2], "T", "F");
        type += letter(BPercent[3], "J", "P");
        return type;
    }

    public static String letter(int percent, String a, String b) {
        if(percent < 50){
            return a;
        } else {
            return b;
        }
    }
}
