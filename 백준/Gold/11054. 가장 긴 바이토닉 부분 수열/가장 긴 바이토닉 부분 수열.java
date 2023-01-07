import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        int[] dp = new int[n];
        int[] downDp = new int[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str[i]);
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (values[i] > values[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int j = n - 1; j > i; j--) {
                if (values[i] > values[j] && downDp[i] < downDp[j] + 1) {
                    downDp[i] = downDp[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i] += downDp[i];
        }

        int maxVal = -1;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }
        System.out.println(maxVal);
    }
}