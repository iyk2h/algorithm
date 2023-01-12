import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new long[100 + 1];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5]= 2;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 6; j <= n; j ++) {
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            System.out.println(dp[n]);
        }
    }
}