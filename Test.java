import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("testFile.txt"));
        while(input.hasNextLine()){
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
                String word = lineScan.next();
                word.replace("o", "0");
                word.replace("e", "3");
                word.replace("a", "4");
                word.replace("t", "7");
                if(word.endsWith("s")) {
                    word.replace("s", "z");
                }

            }
            System.out.println();
        }
    }
}