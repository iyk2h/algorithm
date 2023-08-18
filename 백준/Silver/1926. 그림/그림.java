import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] || map[i][j] == 0) {
                    continue;
                }
                cnt++;
                visit[i][j] = true;

                Queue<int[]> q = new LinkedList<>();

                q.offer(new int[]{i, j});

                int mcnt = 0;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0];
                    int cy = cur[1];

                    mcnt++;
                    for (int move = 0; move < 4; move++) {
                        int nx = cx + dx[move];
                        int ny = cy + dy[move];

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1
                                && !visit[nx][ny]) {
                            q.offer(new int[]{nx, ny});
                            visit[nx][ny] = true;
                        }
                    }
                }

                max = Math.max(max, mcnt);
            }
        }

        System.out.println(cnt + "\n" + max);

    }
}