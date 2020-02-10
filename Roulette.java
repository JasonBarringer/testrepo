import java.util.*;

public class Roulette {
    public static void main(String[] args) throws InterruptedException {
        Scanner console = new Scanner(System.in);
        Random r = new Random();

        int bank = 100;
        int max = bank;

        while (bank > 0) {
            System.out.print("What's your bet? ");
            int bet = console.nextInt();
            System.out.print("HIGH or LOW? ");
            String HoL = console.next().toUpperCase();
            System.out.println("Spinning!");
            for(int i = 0; i < 3; i++) {
                    Thread.sleep(600);
                System.out.println("...");
            }
            Thread.sleep(600);

            int result = r.nextInt(36) + 1;
            System.out.println("The result was " + result + "...");

            Thread.sleep(600);

            if((HoL == "HIGH" && result >= 18) || (HoL == "LOW" && result < 18)) {
                System.out.println("You won!");
            }
        }

    }
}