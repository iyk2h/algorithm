import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[][] rgb = new char[n][n];
        char[][] rrb = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                rgb[i][j] = chars[j];
                rrb[i][j] = chars[j];
                if (chars[j] == 'G') {
                    rrb[i][j] = 'R';
                }
            }
        }

        bfs(rgb);
        System.out.print(" ");
        bfs(rrb);

    }

    private static void bfs(char[][] map) {
        int cnt = 0;

        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) {
                    continue;
                }

                q.offer(new int[]{i, j});
                visit[i][j] = true;

                cnt++;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0];
                    int cy = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (map[cx][cy] == map[nx][ny] && !visit[nx][ny]) {
                            visit[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}