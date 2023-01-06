import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        // 누적값
        dp[1] = values[1];
        if (n > 1) {
            dp[2] = values[1] + values[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + values[i - 1]) + values[i]);
        }

        System.out.println(dp[n]);
    }
}