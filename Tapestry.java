public class Tapestry {
    public static void main(String[] args) {
        drawFringe();
        drawBodyTop();
        drawBodyBottom();
        drawFringe();
    }

    public static void drawFringe() {
        System.out.println("#================#");
    }

    public static void drawBodyTop() {
        for (int i = 0; i <= 3; i++) {
            System.out.print("|");

            for(int x = 1; x <= 6 - 2 *i; x++) {
                System.out.print(" ");
            }

            System.out.print("<>");

            for(int x = 1; x <= 4 * i; x++) {
                System.out.print(".");
            }

            System.out.print("<>");

            for(int x = 1; x <= 6 - 2 *i; x++) {
                System.out.print(" ");
            }

            System.out.println("|");
        }
    }
    
    public static void drawBodyBottom() {
        for (int i = 0; i <= 3; i++) {
            System.out.print("|");

            for(int x = 1; x <= 2 * i; x++) {
                System.out.print(" ");
            }

            System.out.print("<>");

            for(int x = 1; x <= 12 - (4 * i); x++) {
                System.out.print(".");
            }

            System.out.print("<>");

            for(int x = 1; x <= 2 *i; x++) {
                System.out.print(" ");
            }

            System.out.println("|");
        }
    }
}