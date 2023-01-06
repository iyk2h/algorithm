import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[2][n + 1];
            dp[0][0] = dp[1][0] = 0;

            String[] arr = br.readLine().split(" ");
            String[] arr2 = br.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                dp[0][j] = Integer.parseInt(arr[j - 1]);
                dp[1][j] = Integer.parseInt(arr2[j - 1]);
            }

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + dp[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + dp[1][j];
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}