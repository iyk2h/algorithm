import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        use_charAt();
    }

    private static void use_charAt() {

        Scanner sc = new Scanner(System.in);
        Integer A = sc.nextInt();
        String B = sc.next();

        for( int i = B.length()-1 ; i>=0 ; i--) {
            System.out.println(A* (B.charAt(i)-'0'));
        }
        System.out.println(A * Integer.parseInt(B));
    }
}