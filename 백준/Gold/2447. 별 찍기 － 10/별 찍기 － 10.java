import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }

        func(0, 0, N);

        for (int i = 0; i < N; i++) {
            sb.append(board[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void func(int r, int l, int n) {
        if (n == 1) {
            board[r][l] = '*';
            return;
        }

        int size = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                func(r + size * i, l + size * j, size);
            }
        }
    }
}