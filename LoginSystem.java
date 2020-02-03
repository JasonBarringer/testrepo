import java.util.*;

public class LoginSystem {

    public static final String REAL_PASSWORD = "test";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = s.nextLine();
        System.out.println("Welcome, " + fullName);
        while(true) {
            System.out.println("Password? (\"exit\" to exit) ");
            String testPass = s.nextLine();
            if(testPass.equals(REAL_PASSWORD)) {
                System.out.println("do not try again");
                return;
            } else if(testPass.equals("exit")){
                System.out.println("loser");
                return;
            } else {
                System.out.println("Try again?");
            }
        }
    }
}