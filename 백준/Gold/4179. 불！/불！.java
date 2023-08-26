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
        int[][] fDist = new int[n][m];
        int[][] jDist = new int[n][m];

        Queue<int[]> fq = new LinkedList<>();
        Queue<int[]> jq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j];

                fDist[i][j] = -1;
                jDist[i][j] = -1;
                if (input[j] == 'F') {
                    fDist[i][j] = 0;
                    fq.offer(new int[]{i, j});
                }
                if (input[j] == 'J') {
                    jDist[i][j] = 0;
                    jq.offer(new int[]{i, j});
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
                if (map[nx][ny] == '#' || fDist[nx][ny] >= 0) {
                    continue;
                }
                fq.add(new int[]{nx, ny});
                fDist[nx][ny] = fDist[cx][cy] + 1;
            }
        }

        while (!jq.isEmpty()) {
            int[] cur = jq.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (check(nx, ny)) {
                    System.out.println(jDist[cx][cy] + 1);
                    return;
                }
                if (map[nx][ny] == '#' || jDist[nx][ny] >= 0) {
                    continue;
                }
                if (jDist[cx][cy] + 1 >= fDist[nx][ny] && fDist[nx][ny] != -1) {
                    continue;
                }
                jq.add(new int[]{nx, ny});
                jDist[nx][ny] = jDist[cx][cy] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean check(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= m;
    }
}