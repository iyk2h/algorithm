import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        boolean[][] visited;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int maxLimit = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (maxLimit < board[i][j]) {
                    maxLimit = board[i][j];
                }
            }
        }

        int max = 0;

        for (int h = 0; h <= maxLimit; h++) {

            Queue<Pair> q = new LinkedList<>();
            visited = new boolean[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (board[i][j] > h && !visited[i][j]) {
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
                                if (visited[nx][ny]) {
                                    continue;
                                }
                                if (board[nx][ny] <= h) {
                                    continue;
                                }
                                q.offer(new Pair(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            if (cnt >= max) {
                max = cnt;
            }
        }

        System.out.println(max);
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