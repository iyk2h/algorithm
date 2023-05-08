import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isused = new boolean[10];
    static int n, s;

    static int[] board = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        func(0);
    }

    private static void func(int cur) {
        if (cur == s) {
            for (int i = 0; i < s; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return;
        }
        int st = 1; // 시작점
        if (cur != 0) {
            st = board[cur - 1] + 1;
        }
        for (int i = st; i <= n; i++) {
            if (!isused[i]) {
                board[cur] = i;
                isused[i] = true;
                func(cur + 1);
                isused[i] = false;
            }
        }
    }
}