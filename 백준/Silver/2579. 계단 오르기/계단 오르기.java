import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            values[i + 1] = Integer.parseInt(br.readLine());
        }

        dp[1] = values[1];
        if (n > 1) {
            dp[2] = values[1] + values[2];
        }
        for (int i = 3; i <= n; i++) {
            int maxValue = Math.max(values[i - 1] + dp[i - 3], dp[i - 2]) + values[i];
            dp[i] = maxValue;
        }
        System.out.println(dp[n]);
    }
}