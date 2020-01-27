// Jason Barringer
// 01/20/2020
// CSE142
// TA: Esther Chien
// Assignment #2
//
// This program will draw the space needle with size SIZE

public class SpaceNeedle {

    //size is defined here
    public static final int SIZE = 5;

    //main method calls each other method in the order they appear in the space needle
    public static void main(String[] args) {;

        drawPoll();
        drawTop();
        drawBottom();
        drawPoll();
        drawBigPoll();
        drawTop();

    }

    //this draws the small thin part of the poll
    public static void drawPoll() {
        for(int i = 1; i <= SIZE; i++) {
            
            for(int x = 1; x <= 3 * SIZE; x++) {
                System.out.print(" ");
            }

            System.out.println("||");
        }
    }

    //this draws the /\ shaped part of the drawing
    public static void drawTop() {
        for(int i = 1; i <= SIZE; i++) {
            
            for(int x = 1; x <= 3 * (SIZE - i); x++) {
                System.out.print(" ");
            }

            System.out.print("__/");

            for(int x = 1; x <= 3 * (i-1); x++) {
                System.out.print(":");
            }

            System.out.print("||");

            for(int x = 1; x <= 3 * (i-1); x++) {
                System.out.print(":");
            }

            System.out.println("\\__");
        }

        System.out.print("|");

        for(int i = 1; i <= 6 * SIZE; i++) {
            System.out.print("\"");
        }

        System.out.println("|");
    }

    //this draws the \/ shaped part of the drawing
    public static void drawBottom() {
        for(int i = 0; i < SIZE; i++) {
            
            for(int x = 1; x <= 2 * i; x++) {
                System.out.print(" ");
            }
    
            System.out.print("\\_");
    
            for(int x = 1; x <= 3 * SIZE - (2 * i) - 1; x++) {
                System.out.print("/\\");
            }

            System.out.println("_/");
        }
    }

    //this draws the main, bulky part of the poll
    public static void drawBigPoll() {
        for(int i = 1; i <= SIZE * SIZE; i++) {
            for(int x = 1; x < SIZE * 2 + 2; x++) {
                System.out.print(" ");
            }

            System.out.print("|");

            for(int x = 1; x <= SIZE - 2; x++) {
                System.out.print("%");
            }

            System.out.print("||");

            for(int x = 1; x <= SIZE - 2; x++) {
                System.out.print("%");
            }

            System.out.println("|");
        }
    }
}