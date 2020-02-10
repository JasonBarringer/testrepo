import java.util.*;

public class Test{
    public static void main(String[] args){
        randomWalk();
    }

    public static void randomWalk() {
        Random r = new Random();
        int x = 0;
        int rr = 0;
        int max = 0;
        int length = 0;
        while(Math.abs(x) < 3) {
            length += 1;
            System.out.println("position = " + x);
            rr = r.nextInt(3) - 1;
            x += rr;
            max = Math.max(x, max);
        }
        System.out.println("position = " + x);
        System.out.println("max position = " + max);
        System.out.println("length = " + length);
    }
}