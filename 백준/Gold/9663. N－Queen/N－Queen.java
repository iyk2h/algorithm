import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isused1 = new boolean[40];
    static boolean[] isused2 = new boolean[40];
    static boolean[] isused3 = new boolean[40];

    static int cnt;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        func(0);
        System.out.println(cnt);
    }

    private static void func(int cur) {
        if (cur == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isused1[i] || isused2[i + cur] || isused3[cur - i + n - 1]) {
                continue;
            }
            isused1[i] = true;
            isused2[i + cur] = true;
            isused3[cur - i + n - 1] = true;
            func(cur + 1);
            isused1[i] = false;
            isused2[i + cur] = false;
            isused3[cur - i + n - 1] = false;
        }
    }
}