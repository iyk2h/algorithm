import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < 7; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input % 2 != 0) {
                if (min > input) {
                    min = input;
                }
                answer += input;
            }
        }

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
            System.out.println(min);
        }
    }
}
