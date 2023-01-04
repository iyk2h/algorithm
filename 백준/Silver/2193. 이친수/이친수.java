import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int digit = 2; digit <= n; digit++) {
            dp[digit][0] = dp[digit - 1][1] + dp[digit - 1][0];
            dp[digit][1] = dp[digit - 1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}