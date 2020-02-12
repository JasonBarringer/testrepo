import java.io.*;
import java.util.*;

public class FindMinAndMax {
    public static void main(String[] args) throws FileNotFoundException {

        File inFile = new File("numbers.txt");

        Scanner s = new Scanner(inFile);
        double x = s.nextDouble();
        double min = x;
        double max = x;
        for(int i = 0; i < 4; i++) {
            x = s.nextDouble();
            if(x < min) min = x;
            if(x > max) max = x;

        }
        printResults(min, max);
    }

    public static void printResults(double min, double max) {
        System.out.print(min + " " + max);
    }

}