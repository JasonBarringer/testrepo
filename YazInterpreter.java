// Jason Barringer
// 02/25/2020
// CSE142
// TA: Esther Chien
// Assignment #6
//
// This program executes YazLang commands from either the console or a file and outputs them either back to the
//console or to a different file.

import java.io.*;
import java.util.*;

public class YazInterpreter {


    //This is the main method. Creates a console scanner. It then calls the intro method, then the run
    //program method, sending the scanner to the run program method. I'm not gonna lie to you, I'm kinda
    //miffed that you keep taking points off for my comments, but I went and read the style guide so 
    //hopefully I dont mess it up this time.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        intro();
        runProgram(console);
    }


    //This method takes no parameters and returns no values. It only prints the YazInterpreter introduction
    public static void intro(){
        System.out.println("Welcome to the YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a .txt file or enter console YazInteractions");
        System.out.println("mode to run single commands of YazLang.\n");
    }

    //This method recieves a console scanner parameter, recieves commands from the user, then runs
    //the methods for YazLang on either the console or in a file. Or you could exit with q
    //It runs until the user selects Quit
    public static void runProgram(Scanner console) throws FileNotFoundException{
        String command = getYaz(console).toUpperCase();
        while (!command.equals("Q")){
            if(command.equals("C")) {
                consoleInteractions(console);
            }
            if(command.equals("I")) {
                interperetYazFile(console);
            }
            command = getYaz(console).toUpperCase();
        }
    }


    //This method takes a console scanner, prompts the user for what they want to do
    //(console or file interactions or quit) then returns their selection as a String
    public static String getYaz(Scanner console) {
        System.out.print("(C)onsole YazInteractions, (I)nterpret .yzy program, (Q)uit? ");
        String command;
        do {
            command = console.nextLine().toUpperCase();
        } while(!command.equals("C") && !command.equals("I") && !command.equals("Q"));
        return(command);        
    }


    //This method takes a console scanner, and uses it to read YazLang commands from the console
    //until the user prompts it to end. It returns no values
    public static void consoleInteractions(Scanner console){
        System.out.println("YazInteractions session. Type END to exit.");
        String yazCommand;
        do{
            System.out.print("> ");
            yazCommand = runCommand(console, System.out);
        } while (!yazCommand.equals("END"));
        System.out.println();
    }


    //This method takes a console scanner and uses it to prompt the user for their input and output files.
    //It then reads all of the commands from the input file, outputs them to the output file, then prints
    //a message when it is done.
    public static void interperetYazFile(Scanner console) throws FileNotFoundException {
        System.out.print("Input file name: ");
        File yazFile = new File(console.nextLine());
        while(!yazFile.exists()){
            System.out.print("File not found. Try again: ");
            yazFile = new File(console.nextLine());
        }
        Scanner canner = new Scanner(yazFile);
        System.out.print("Output file name: ");
        PrintStream yazWriter = new PrintStream(console.nextLine());
        while(canner.hasNextLine()){
            runCommand(canner, yazWriter);
        }
        System.out.println("YazLang program interpreted and output to .txt file!");
    }


    //This method takes a Scanner input and a PrintStream output. It reads commands from the input, and 
    //prints them to the output. It returns the command, but this is only used in the consoleInteractions
    //method to call the END command.
    public static String runCommand(Scanner input, PrintStream output){
        String yazInput = input.nextLine();
        Scanner yazScanner = new Scanner(yazInput);
        String yazCommand = yazScanner.next().toUpperCase();
        if(yazCommand.equals("CONVERT")) {
            output.println(convert(yazScanner));
        }
        if(yazCommand.equals("RANGE")) {
            output.println(range(yazScanner));
        }
        if(yazCommand.equals("REPEAT")) {
            output.println(repeat(yazScanner));
        }
        return(yazCommand);
    }


    //This method takes a scanner input, and uses it to read the specifications of a CONVERT command.
    //It computes the conversion and returns the answer as a String 
    public static String convert(Scanner yazScanner) {
        int input = yazScanner.nextInt();
        String conversion = yazScanner.next().toUpperCase();
        int output = 0;
        if(conversion.equals("F")){
            output = (int)((input - 32) / 1.8);
            return output + "C";
        }else if(conversion.equals("C")){
            output = (int)((input * 1.8) + 32);
            return output + "F";
        }else{
            return "bruh";
        }
    }


    //This method takes a scanner input, and uses it to read the specifications of a RANGE command.
    //It returns the list of numbers as a String
    public static String range(Scanner yazScanner) {
        int start = yazScanner.nextInt();
        int limit = yazScanner.nextInt();
        int increment = yazScanner.nextInt();
        String yazString = "";
        for(int i = start; i < limit; i += increment) {
            yazString += (i + " ");
        }
        return yazString;
    }


    //This method takes a scanner input, and uses it to read the specifications of a REPEAT command.
    //It replaces underscores with spaces and removes quotes, then returns the final result as a String
    public static String repeat(Scanner yazScanner) {
        String yazString = "";
        while(yazScanner.hasNext()){
            String str = yazScanner.next();
            int times = yazScanner.nextInt();
            str = str.replace("_", " ");
            str = str.replace("\"", "");
            for(int i = 0; i < times; i++) {
                yazString += str;
            }
        }
        return yazString;
    }
}