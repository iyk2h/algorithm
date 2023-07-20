import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];

        int answer = 0;

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());

            dp[i] = time;
            int next = Integer.parseInt(st.nextToken());
            for (int j = 0; j < next; j++) {
                int ni = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[ni] + time);
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}