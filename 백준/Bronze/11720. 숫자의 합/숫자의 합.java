import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int in = Integer.parseInt(bf.readLine());

        int sum = 0;
        String i = String.valueOf(bf.readLine());

        while (in > 0) {
            sum = sum + Integer.parseInt(String.valueOf(i.charAt(in-1)));
            in--;
        }
        System.out.println(sum);
    }
}