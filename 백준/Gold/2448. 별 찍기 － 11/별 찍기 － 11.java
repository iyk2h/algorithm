import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        board = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }

        func(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void func(int r, int l, int n) {
        if (n == 3) {
            board[r][l] = '*';
            board[r + 1][l - 1] = board[r + 1][l + 1] = '*';
            board[r + 2][l - 2] = board[r + 2][l - 1] = board[r + 2][l] = board[r + 2][l
                    + 1] = board[r + 2][l + 2] = '*';
            return;
        } else {
            int size = n / 2;
            func(r, l, size);
            func(r + size, l - size, size);
            func(r + size, l + size, size);
        }
    }
}