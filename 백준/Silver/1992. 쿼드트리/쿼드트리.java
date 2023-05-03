import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = (str.charAt(j) - '0');
            }
        }

        func(0, 0, N);

        System.out.println(sb.toString());
    }

    private static void func(int r, int l, int n) {
        if (checkColor(r, l, n)) {
            if (board[r][l] == 0) {
                sb.append(0);
            } else if (board[r][l] == 1) {
                sb.append(1);
            }

            return;
        }
        int size = n / 2;

        sb.append("(");
        func(r, l, size);
        func(r, l + size, size);

        func(r + size, l, size);
        func(r + size, l + size, size);
        sb.append(")");
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