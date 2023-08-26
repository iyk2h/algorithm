import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[][] fireDist = new int[n][m];
        int[][] JDist = new int[n][m];

        Queue<int[]> fq = new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];

                fireDist[i][j] = -1;
                JDist[i][j] = -1;
                if (map[i][j] == 'F') {
                    fireDist[i][j] = 0;
                    fq.add(new int[]{i, j});
                }
                if (map[i][j] == 'J') {
                    q.add(new int[]{i, j});
                    JDist[i][j] = 0;
                }
            }
        }

        while (!fq.isEmpty()) {
            int[] cur = fq.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (check(nx, ny)) {
                    continue;
                }
                if (map[nx][ny] == '#' || fireDist[nx][ny] >= 0) {
                    continue;
                }
                fq.offer(new int[]{nx, ny});
                fireDist[nx][ny] = fireDist[cx][cy] + 1;
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (check(nx, ny)) {
                    System.out.println(JDist[cx][cy] + 1);
                    return;
                }
                if (map[nx][ny] == '#' || JDist[nx][ny] >= 0) {
                    continue;
                }
                if (JDist[cx][cy] + 1 >= fireDist[nx][ny] && fireDist[nx][ny] != -1) {
                    continue;
                }
                q.offer(new int[]{nx, ny});
                JDist[nx][ny] = JDist[cx][cy] + 1;
            }
        }

        System.out.println("IMPOSSIBLE");

    }

    private static boolean check(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= m;
    }
}