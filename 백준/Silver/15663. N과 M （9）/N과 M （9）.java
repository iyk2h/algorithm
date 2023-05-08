import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isused;
    static int n, s;

    static int[] board;
    static int[] val;

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new int[n + 1];
        val = new int[n];
        isused = new boolean[10001];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(val);

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
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            if (!isused[i] && tmp != val[i]) {
                isused[i] = true;
                board[cur] = val[i];
                tmp = board[cur];
                func(cur + 1);
                isused[i] = false;
            }
        }
    }
}