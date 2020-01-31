import java.util.IllformedLocaleException;

public class Test{
    public static void main(String[] args){
        int x = -5;
        try {
            if(x < 0){
                throw new IllformedLocaleException("hey fucker you buth");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}