// Jason Barringer
// 2/2/2020
// CSE142
// TA: Esther Chien
// Assignment #4
//
// This program will accpet user input on their monthly income and expenses, then calculate their net gain or loss!

import java.util.Scanner;

public class Budgeter {

    //This is the amount of days in the given month, it's at 31 right now (Shoutout to January 2020)
    public static int days = 31;

    //This is the main method! It calls each of the other methods in order.
    //It's pretty much the head honcho around these parts.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        printIntro();
        double income = getValue(s, "income");
        int mod = monthlyOrDaily(s);
        double expense = getValue(s, "expense");
        double budget = calculateBudget(income, expense, mod);
        printBudget(budget);
    }

    //print intro prints the intro. It's very good at it
    public static void printIntro() {
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.\n");
    }

    //monthlyOrDaily is dedicated to asking the age old question, 'Enter 1) monthly or 2) daily expenses?'
    public static int monthlyOrDaily(Scanner s) {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        return s.nextInt();
    }

    //getValue is the heart and soul of this program. It gets the user input and returns the total sum.
    //It works for both income and expenses (it thinks it's soooooo cool...)
    public static double getValue(Scanner s, String incomeOrExpense) {
        System.out.print("How many categories of " + incomeOrExpense + "? ");

        int categories = s.nextInt();
        double sum = 0;
        for(int i = 0; i < categories; i++) {
            System.out.print("    Next " + incomeOrExpense + " amount? $");
            sum += s.nextDouble();
        }

        System.out.println();
        return sum;
    }

    //Calculate budget calculates and prints the daily and monthly income and expenses
    //then, it calculates and returns the difference between the monthly income and expenses
    //Bit of a numberphile this one!!
    public static double calculateBudget(double incomeM, double expense, int mod) {
        double incomeD = incomeM / days;
        double expenseM, expenseD;
        if(mod == 1) {
            expenseM = expense;
            expenseD = expense / days;
        } else {
            expenseM = expense * days;
            expenseD = expense;
        }

        System.out.printf("Total income = $%.2f ($%.2f/day)\n", incomeM, incomeD);
        System.out.printf("Total expenses = $%.2f ($%.2f/day)\n", expenseM, expenseD);
        System.out.println();

        return incomeM - expenseM;
    }

    //print budget never stops talking (ugh)
    //it tells you about your income compared to your expenses and makes a comment about it (judgemental much?)
    public static void printBudget(double budget) {
        if(budget > 0) {
            System.out.printf("You earned $%.2f more than you spent this month.\n", budget);
            if(budget > 250) {
                System.out.println("You're a big saver.");
                System.out.println("What if we vibed in the tree cage? jkjk... unless?");
            } else {
                System.out.println("You're a saver.");
                System.out.println("Hi! I like shorts! They're comfy and easy to wear!");
            }
        } else {
            System.out.printf("You spent $%.2f more than you earned this month.\n", -budget);
            if(budget > -250) {
                System.out.println("You're a spender.");
                System.out.println("Hey, woah, that's not safe");
            } else {
                System.out.println("You're a big spender.");
                System.out.println("Spendy spendy chicken tendy.");
            }
        }
    }
    
}