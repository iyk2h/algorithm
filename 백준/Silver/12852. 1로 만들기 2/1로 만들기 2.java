import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        int[] pre = new int[n + 1];

        dp[1] = 0;
        pre[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            pre[i] = i - 1;
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                pre[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                pre[i] = i / 2;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(dp[n]).append("\n");
        int cur = n;
        while (true) {
            sb.append(cur).append(" ");
            if (cur == 1) {
                break;
            }
            cur = pre[cur];
        }
        System.out.println(sb);
    }
}