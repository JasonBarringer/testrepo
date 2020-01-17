public class Test{
    public static void main(String[] args){
        int size = 7;
        for(int i = 1; i <= size; i++){
            for(int x = 1; x <= 4 * (size - i); x++){
                System.out.print("/");
            }
            
            for(int x = 1; x <= 8 * (i - 1); x++){
                System.out.print("*");
            }
            
            for(int x = 1; x <= 4 * (size - i); x++){
                System.out.print("\\");
            }

            System.out.println();
        }
    }
}