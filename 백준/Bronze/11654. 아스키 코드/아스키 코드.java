import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = String.valueOf(bf.readLine());

        char c = input.charAt(0);
        int as = c;
        System.out.println(as);

    }
}
