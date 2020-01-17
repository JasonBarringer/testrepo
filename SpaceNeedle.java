public class SpaceNeedle {

    static int size = 2;
    public static void main(String[] args) {;

        drawPoll();
        drawTop();
        //drawMiddle();
        drawBottom();
        drawPoll();
        drawBigPoll();
        drawTop();


    }

    public static void drawPoll() {
        for(int i = 1; i <= size; i++) {
            
            for(int x = 1; x <= 3 * size; x++) {
                System.out.print(" ");
            }

            System.out.println("||");
        }
    }

    public static void drawTop() {
        for(int i = 1; i <= size; i++) {
            
            for(int x = 1; x <= 3 * (size - i); x++) {
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

        for(int i = 1; i <= 6 * size; i++) {
            System.out.print("\"");
        }

        System.out.println("|");
    }

    // public static void drawMiddle() {
    //     System.out.print("|");
    //     for(int i = 1; i <= 6 * size; i++) {
    //         System.out.print("\"");
    //     }
    //     System.out.println("|");
    // }

    public static void drawBottom() {
        for(int i = 0; i < size; i++) {
            
            for(int x = 1; x <= 2 * i; x++) {
                System.out.print(" ");
            }
    
            System.out.print("\\_");
    
            for(int x = 1; x <= 3 * size - (2 * i) - 1; x++) {
                System.out.print("/\\");
            }

            System.out.println("_/");
        }
    }

    public static void drawBigPoll() {
        for(int i = 1; i <= size * size; i++) {
            for(int x = 1; x < size * 2 + 2; x++) {
                System.out.print(" ");
            }

            System.out.print("|");

            for(int x = 1; x <= size - 2; x++) {
                System.out.print("%");
            }

            System.out.print("||");

            for(int x = 1; x <= size - 2; x++) {
                System.out.print("%");
            }

            System.out.println("|");
        }
    }
}