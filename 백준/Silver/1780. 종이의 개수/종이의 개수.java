import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m = 0;
    static int z = 0;
    static int p = 0;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, N);

        System.out.println(m);
        System.out.println(z);
        System.out.println(p);
    }

    private static void func(int r, int l, int n) {
        if (checkColor(r, l, n)) {
            if (board[r][l] == -1) {
                m++;
            } else if (board[r][l] == 0) {
                z++;
            } else if (board[r][l] == 1) {
                p++;
            }

            return;
        }
        int size = n / 3;

        func(r, l, size);
        func(r, l + size, size);
        func(r, l + 2 * size, size);

        func(r + size, l, size);
        func(r + size, l + size, size);
        func(r + size, l + 2 * size, size);

        func(r + 2 * size, l, size);
        func(r + 2 * size, l + size, size);
        func(r + 2 * size, l + 2 * size, size);
    }

    private static boolean checkColor(int r, int l, int n) {
        int start = board[r][l];
        for (int i = r; i < r + n; i++) {
            for (int j = l; j < l + n; j++) {
                if (start != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}