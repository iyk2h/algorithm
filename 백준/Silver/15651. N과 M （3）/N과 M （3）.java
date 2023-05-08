import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isused;
    static int n, s;

    static int[] board;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new int[n + 1];
        isused = new boolean[n + 1];

        func(0);
        System.out.println(sb);
    }

    private static void func(int cur) {
        if (cur == s) {
            for (int i = 0; i < s; i++) {
                sb.append(board[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int st = 1;

        for (int i = st; i <= n; i++) {
            board[cur] = i;
            func(cur + 1);
        }
    }
}