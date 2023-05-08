import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuffer sb = new StringBuffer();
    static int n;
    static int m;
    static int[] board;
    static boolean[] isUsed;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1];
        isUsed = new boolean[n + 1];

        func(0);
        System.out.println(sb);
    }

    private static void func(int c) {
        if (c == m) {
            for (int i = 0; i < m; i++) {
                sb.append(board[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int st = 1;
        if (c != 0) {
            st = board[c - 1] + 1;
        }

        for (int i = st; i <= n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                board[c] = i;
                func(c + 1);
                isUsed[i] = false;
            }
        }
    }
}