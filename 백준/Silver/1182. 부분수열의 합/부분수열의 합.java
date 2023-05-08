import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];

    static int cnt;
    static int n, s;

    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (s == 0) {
            cnt--;
        }

        System.out.println(cnt);
    }

    private static void func(int cur, int tot) {
        if (cur == n) {
            if (tot == s) {
                cnt++;
            }
            return;
        }

        func(cur + 1, tot);
        func(cur + 1, tot + board[cur]);
    }
}