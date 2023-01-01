import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        int[] dp = new int[12];

        for (int i = 0; i < input; i++) {
            int n = Integer.parseInt(bf.readLine());
            
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for (int j = 3; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2 ] + dp[j-3];
            }

            System.out.println(dp[n]);
        }
    }
}
