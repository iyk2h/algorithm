import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] RGBBoard = new char[n][n];
        char[][] RBBoard = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                char c = chars[j];
                RGBBoard[i][j] = c;
                if (c == 'G') {
                    c = 'R';
                }
                RBBoard[i][j] = c;
            }
        }

        visited = new boolean[n][n];
        bfd(RGBBoard, n);

        System.out.print(" ");

        visited = new boolean[n][n];
        bfd(RBBoard, n);
    }

    private static void bfd(char[][] board, int n) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (visited[i][j]) {
                    continue;
                }

                q.offer(new Pair(i, j));
                visited[i][j] = true;

                cnt++;

                while (!q.isEmpty()) {

                    Pair cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (board[nx][ny] == board[cur.x][cur.y] && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Pair(nx, ny));
                        }
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}

class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}