import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, sx, sy, d, cnt;
    static int[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        cnt = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(sx, sy, d);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int d) {

        board[x][y] = -1;
        for (int i = 0; i < 4; i++) {

            d = (d + 3) % 4;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                cnt++;
                dfs(nx, ny, d);
                return;
            }
        }

        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if (bx >= 0 && bx < n && by >= 0 && by < m && board[bx][by] != 1) {
            dfs(bx, by, d);
        }
    }
}