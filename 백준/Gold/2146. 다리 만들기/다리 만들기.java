import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] visit;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                    map[i][j] = cnt;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cx = cur[0];
                        int cy = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];

                            if (oob(nx, ny)) {
                                continue;
                            }
                            if (map[nx][ny] == 1 && !visit[nx][ny] ) {
                                visit[nx][ny] = true;
                                map[nx][ny] = cnt;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        visit = new boolean[n][n];
        dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < 1 || visit[i][j]) {
                    continue;
                }
                int nowDeep = map[i][j];
                q.add(new int[]{i, j});
                visit[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0];
                    int cy = cur[1];

                    for (int k = 0; k < 4; k++){
                        int nx = cx + dx[k];
                        int ny = cy + dy[k];

                        if (oob(nx, ny)) {
                            continue;
                        }
                        if (visit[nx][ny] || map[nx][ny] == nowDeep) {
                            continue;
                        }
                        visit[nx][ny] = true;
                        if (map[nx][ny] == 0) {
                            q.add(new int[]{nx, ny});
                            dist[nx][ny] = dist[cx][cy] + 1;
                        } else {
                            answer = Math.min(answer, dist[cx][cy]);
                        }
                    }
                }
                visit = new boolean[n][n];
            }
        }
        System.out.println(answer);
    }

    private static boolean oob(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n;
    }
}