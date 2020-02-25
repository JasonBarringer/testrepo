import java.io.*;
import java.util.*;

public class YazInterpreter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        intro();
        runProgram(console);
    }

    public static void intro(){
        System.out.println("Welcome to the YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a .txt file or enter console YazInteractions");
        System.out.println("mode to run single commands of YazLang.\n");
    }

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

    public static String getYaz(Scanner console) {
        System.out.print("(C)onsole YazInteractions, (I)nterpret .yzy program, (Q)uit? ");
        String command;
        do {
            command = console.nextLine().toUpperCase();
        } while(!command.equals("C") && !command.equals("I") && !command.equals("Q"));
        return(command);        
    }

    public static void consoleInteractions(Scanner console){
        System.out.println("YazInteractions session. Type END to exit.");
        String yazCommand;
        do{
            System.out.print("> ");
            yazCommand = runCommand(console, System.out);
        } while (!yazCommand.equals("END"));
        System.out.println();
    }

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