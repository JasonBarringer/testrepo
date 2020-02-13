import java.util.*;

public class Test{
    public static void main(String[] args){
        Random r = new Random();
        spinWheel(r, 3);
    }

    public static void spinWheel(Random r, int n) {
        int x = (r.nextInt(5) + 2) * 10;
        int count = 0;
        int count2 = 0;
        System.out.println("spins: ");
        do {
            System.out.print(x + ", ");
            x = (r.nextInt(5) + 2) * 10;
            if(20 == x) {
                count2 += 1;
            } else {
                count2 = 0;
            }
            count += 1;
        } while(count2 != n);
        System.out.println(x);

        System.out.println(n + " in a row after " + count + " spins");
    }
}