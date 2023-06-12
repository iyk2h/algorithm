import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        int[] board = new int[N];

        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(board);

        int e = 0;
        for (int s = 0; s < N; s++) {
            while (e < N && board[e] - board[s] < M) {
                e++;
            }
            if (e == N) {
                break;
            }
            min = Math.min(min, board[e] - board[s]);
        }
        sb.append(min);
        System.out.println(sb);
    }
}