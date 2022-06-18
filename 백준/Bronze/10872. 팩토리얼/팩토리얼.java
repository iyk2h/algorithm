import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int f = Integer.parseInt(bf.readLine());
        int answer = factorial(f);
        System.out.println(answer);

    }

    public static int factorial (int a) {
        if (a == 0) {
            return 1;
        }
        return a * factorial(a-1);
    }
}