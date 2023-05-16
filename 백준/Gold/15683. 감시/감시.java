import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] board;
    static int[][] tmpBoard;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<cctv> cctvs = new ArrayList<>();

        board = new int[n][m];

        int min = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctvs.add(new cctv(i, j));
                }
                if (board[i][j] == 0) {
                    min++;
                }
            }
        }

        if (min == 0) {
            System.out.println(min);
            return;
        }

        for (int tmp = 0; tmp < 1 << (2 * cctvs.size()); tmp++) {
            tmpBoard = new int[n][m];
            for (int k = 0; k < n; k++) {
                // 2차배열 깊은 복사
                System.arraycopy(board[k], 0, tmpBoard[k], 0, m);
            }

            int brute = tmp;

            for (int j = 0; j < cctvs.size(); j++) {
                int x = cctvs.get(j).x;
                int y = cctvs.get(j).y;
                int kind = board[x][y];
                int dir = brute % 4;
                brute /= 4;

                if (kind == 1) {
                    upd(x, y, dir);
                } else if (kind == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                } else if (kind == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                } else if (kind == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tmpBoard[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
            if (min == 0) {
                System.out.println(min);
                return;
            }
        }
        System.out.println(min);
    }

    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || x >= n || y < 0 || y >= m || tmpBoard[x][y] == 6) {
                return;
            }
            if (tmpBoard[x][y] != 0) {
                continue;
            }
            tmpBoard[x][y] = 7;
        }
    }
}


class cctv {

    int x;
    int y;

    public cctv(int x, int y) {
        this.x = x;
        this.y = y;
    }
}