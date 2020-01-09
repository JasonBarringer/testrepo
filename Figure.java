public class Figure{
   public static void main(String[] args){
      drawShape("diamond");
      drawShape("diamond");
      drawShape("x");
   }
  
   public static void draw(String str){
      if(str == "top"){
         System.out.println("  /\\  ");
         System.out.println(" /  \\ ");
         System.out.println("/    \\");
      }
      else if(str == "bottom"){
         System.out.println("\\    /");
         System.out.println(" \\  / ");
         System.out.println("  \\/  ");
      }
      else{
         System.out.println();
      }
      }
      public static void drawShape(String shape){
         if(shape == "diamond"){
            draw("top");
            draw("bottom");
            draw("");
         }
         if(shape == "x"){
            draw("bottom");
            draw("top");
            draw("");
         }
      }
   }