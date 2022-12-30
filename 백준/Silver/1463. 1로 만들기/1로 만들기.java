import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        System.out.println(solve(input, 0));
    }

    private static int solve(int input, int count){
        if (input < 2) {
            return count;
        }
        return Math.min(solve(input / 2, count + 1 + (input % 2)), solve(input / 3, count + 1 + (input % 3)));
    }
}
