import java.util.*;

public class LoginSystem {

    public static final String REAL_PASSWORD = "test";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = s.nextLine();
        System.out.println("Welcome, " + fullName);
        String testPass = s.nextLine();
        while(!testPass.equals(REAL_PASSWORD)) {
            System.out.println("Try again...");
            System.out.println("Password? ");
            testPass = s.nextLine();
        }
        System.out.println("do not try again");
        s.close();
    }
}