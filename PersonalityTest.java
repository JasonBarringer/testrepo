import java.util.*;
import java.io.*;

public class PersonalityTest {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(new File("input.txt"));
        if(fileScanner.hasNextLine()){
            interpretFile(fileScanner);
        }
    }

    public static void interpretFile(Scanner fileScanner) {
        String name = fileScanner.nextLine();
        System.out.println(name);
        String answers = fileScanner.nextLine();
        int[] ACounts = new int[4];
        int[] BCounts = new int[4];
        for(int i = 0; i < answers.length(); i++) {
            int question = (i % 7 + 1)/2;
            char answer = answers.charAt(i);
            if(answer == 'A') ACounts[question]++;
            if(answer == 'B') BCounts[question]++;
            if(answer == '-');
        }
        System.out.println(ACounts[0]);
        System.out.println(BCounts[0]);
    }
}
