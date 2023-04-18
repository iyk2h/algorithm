import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] board = new int[h][x][y];
        int[][][] dist = new int[h][x][y];
        Queue<Area> q = new LinkedList<>();

        int[] dx = {1, 0, -1, 0, 0, 0};
        int[] dy = {0, 1, 0, -1, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};

        for (int d = 0; d < h; d++) {
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < y; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        q.offer(new Area(d, i, j));
                    }
                    if (input == 0) {
                        dist[d][i][j] = -1;
                    }
                    board[d][i][j] = input;
                }
            }
        }

        while (!q.isEmpty()) {
            Area cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nh = cur.h + dh[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nh < 0 || nh >= h || nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    continue;
                }
                if (dist[nh][nx][ny] >= 0) {
                    continue;
                }
                dist[nh][nx][ny] = dist[cur.h][cur.x][cur.y] + 1;
                q.offer(new Area(nh, nx, ny));
            }
        }

        int answer = 0;
        for (int d = 0; d < h; d++) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (dist[d][i][j] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dist[d][i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}

class Area {

    int h;
    int x;
    int y;

    public Area(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}