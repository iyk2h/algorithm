import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int board[] = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (start <= n && end <= n) {
            if (total >= s && min > end - start) {
                min = end - start;
            }
            if (total < s) {
                total += board[end++];
            } else {
                total -= board[start++];
            }
        }

        System.out.println((min) == Integer.MAX_VALUE ? 0 : min);

    }
}