import java.util.*;

import javax.swing.event.HyperlinkEvent;

import java.io.*;

public class Test{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("testFile.txt"));
        int[] scores = getScores(input);
        double average = (double)total / numScores;
        System.out.println(average);

        System.out.println(numAboveAverage(scores, average));
    }

    public static int[] getScores(Scanner input){
        int numScores = input.nextInt();
        int[] scores = new int[numScores];
        for (int times = 0; times < numScores; times++) {
            scores[times] = input.nextInt();
        }

        return scores;
    }

    public stativ double average

    public static int numAboveAverage (int[] scores, double average) {
        int count = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > average) {
                count++;
            }
        }
        return count;
    }
}