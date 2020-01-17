public class Figure {
   public static void main(String[] args) {
      drawDiamond();

      drawDiamond();

      drawX();
   }

   public static void drawDiamond() {
      drawMountatin();
      drawValley();
      System.out.println();
   }

   public static void drawX() {
      drawValley();
      drawMountatin();
      System.out.println();
   }

   public static void drawMountatin(){
      System.out.println("  /\\  ");
      System.out.println(" /  \\ ");
      System.out.println("/    \\");
   }

   public static void drawValley(){
      System.out.println("\\    /");
      System.out.println(" \\  / ");
      System.out.println("  \\/  ");
   }
}