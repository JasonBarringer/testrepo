import java.util.*;

import javax.swing.event.HyperlinkEvent;

import java.io.*;

public class Test{
    public static void main(String[] args) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("output.txt"));
        Random r = new Random();
        for(int i = 1; i < 70; i++) {
            int x = r.nextInt(5);
            if(x < 2){
                output.print("A");
            } else if(x < 4){
                output.print("B");
            } else {
                output.print("-");
            }
        }
        output.println();
        for(int i = 1; i < 70; i++) {
            int x = r.nextInt(5);
            if(x < 2){
                output.print("A");
            } else if(x < 4){
                output.print("B");
            } else {
                output.print("-");
            }
        }
        output.println();
        for(int i = 1; i < 70; i++) {
            int x = r.nextInt(5);
            if(x < 2){
                output.print("A");
            } else if(x < 4){
                output.print("B");
            } else {
                output.print("-");
            }
        }
        output.println();
    }

}