import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][m];
            boolean[][] visit = new boolean[n][m];

            int k = Integer.parseInt(st.nextToken());

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        cnt++;

                        visit[i][j] = true;
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int cx = cur[0];
                            int cy = cur[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = cx + dx[d];
                                int ny = cy + dy[d];

                                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                    continue;
                                }
                                if (map[nx][ny] == 0 || visit[nx][ny]) {
                                    continue;
                                }
                                q.add(new int[]{nx, ny});
                                visit[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}