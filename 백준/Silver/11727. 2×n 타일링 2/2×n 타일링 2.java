import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        /*
        규칙성 : dp[n] = dp[n-1] + dp[n-2] * 2;
        dp[1] = 1
        dp[2] = 2
        */

        int[] dp = new int[input + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= input; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        
        System.out.println(dp[input]);
    }
}
