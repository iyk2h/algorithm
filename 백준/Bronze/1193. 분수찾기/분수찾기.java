import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        int count = 1;
        int sum = 0;
        while (true) {
            if (input <= sum + count) {
                if (count % 2 == 0) {
                    System.out.println((input - sum) + "/" + (count - (input - sum - 1)));
                } else {
                    System.out.println((count - (input - sum - 1)) + "/" + (input - sum));
                }
                break;
            } else {
                sum += count;
                count++;
            }
        }
    }
}

