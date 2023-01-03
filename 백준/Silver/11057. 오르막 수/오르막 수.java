import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] dp;
    final static int divVal = 10_007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        int result = 0;

        for (int i = 0; i < 10; i++) {
            result += L(n, i);
        }
        System.out.println(result % divVal);
    }

    static int L(int n, int i) {
        if (dp[n][i] != 0) {
            return dp[n][i];
        }
        if (i == 0) {
            dp[n][i] = L(n - 1, i);
        } else {
            for (int j = i; j >= 0; j--) {
                dp[n][i] += L(n - 1, j);
            }
        }

        return dp[n][i] % divVal;
    }
}