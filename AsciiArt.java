// Jason Barringer
// 01/20/2020
// CSE142
// TA: Esther Chien
// Assignment #2
//
// This program will draw a snake man with length LENGTH

public class AsciiArt{
//length is defined here
    public static final int LENGTH = 10;
    
    //main method; calls both head and body methods
    public static void main(String[] args){
        printHead();
        printBody();
    }

    //the head is just a series of println commands
    public static void printHead() {
        System.out.println("   _________");
        System.out.println("  /         \\");
        System.out.println("  |         |");
        System.out.println("__|_________|__");
        System.out.println(" (''''(o)^(0)|");
        System.out.println("  |  _   _\\ (");
        System.out.println("  \\   |  __ /");
        System.out.println("   \\_______/");
    }

    /*
    The body consists of the neck, the end of the tail, and the wiggly middle bit that can be very long
    The wiggly middle bit is the part that is drawn by the loop that is controlled by LENGTH
    */
    public static void printBody() {
        System.out.println("     \\\\ //");

        for(int i = 0; i < LENGTH; i++) {
            System.out.println("     /::/");
            System.out.println("    |::|");
            System.out.println("     \\::\\");
            System.out.println("      |::|");
        }

        System.out.println("      |::/");
        System.out.println("      \\:|");
        System.out.println("       \\/");
    }
}