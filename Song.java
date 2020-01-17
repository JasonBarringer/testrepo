// Jason Barringer
// 01/9/2020
// CSE142
// TA: Esther Chien
// Assignment #1
//
// This program will print the words to the cumulative song about the old woman who swallowed a fly.

public class Song {
   public static void main(String[] args) {
      //This is the main class. It prints the unique lines of the song and calls the methods for the non-unique lines
      System.out.println("There was an old woman who swallowed a fly.");
      fly();
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spider();
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      bird();
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      cat();
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dog();
      System.out.println("There was an old woman who swallowed a monkey,");
      System.out.println("Must've been hungry to swallow a monkey.");
      monkey();
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   //each of the following methods prints one of the recursive lines then calls the method for the next line.
   //It's done in this way so that you can start at any line and it will print all of the following lines.
   public static void monkey() {
      System.out.println("She swallowed the monkey to catch the dog,");
      dog();
   }
   
   public static void dog() {
      System.out.println("She swallowed the dog to catch the cat,");
      cat();
   }
   
   public static void cat() {
      System.out.println("She swallowed the cat to catch the bird,");
      bird();
   }
   
   public static void bird() {
      System.out.println("She swallowed the bird to catch the spider,");
      spider();
   }
   
   public static void spider() {
      System.out.println("She swallowed the spider to catch the fly,");
      fly();
   }
   
   public static void fly() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
}