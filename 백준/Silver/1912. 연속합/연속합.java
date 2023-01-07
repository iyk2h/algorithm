import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        int[] dp = new int[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str[i]);
        }

        dp[0] = values[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(values[i], dp[i - 1] + values[i]);
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }
}