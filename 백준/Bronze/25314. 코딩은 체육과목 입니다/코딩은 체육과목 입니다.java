import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n /= 4;
        while (n-- > 0) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}