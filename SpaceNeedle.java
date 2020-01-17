public class SpaceNeedle {

    public static final int SIZE = 5;
    public static void main(String[] args) {;

        drawPoll();
        drawTop();
        drawBottom();
        drawPoll();
        drawBigPoll();
        drawTop();

    }

    public static void drawPoll() {
        for(int i = 1; i <= SIZE; i++) {
            
            for(int x = 1; x <= 3 * SIZE; x++) {
                System.out.print(" ");
            }

            System.out.println("||");
        }
    }

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