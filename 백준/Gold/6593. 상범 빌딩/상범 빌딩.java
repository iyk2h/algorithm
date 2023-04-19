import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int[] dx = new int[]{1, 0, -1, 0, 0, 0};
        int[] dy = new int[]{0, 1, 0, -1, 0, 0};
        int[] dz = new int[]{0, 0, 0, 0, 1, -1};

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int z = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (z == 0 && x == 0 && y == 0) {
                System.out.println(sb);
                return;
            }

            char[][][] board = new char[z][x][y];
            int[][][] times = new int[z][x][y];
            Queue<Pair> q = new LinkedList<>();

            for (int h = 0; h < z; h++) {
                for (int i = 0; i < x; i++) {
                    String tmp = br.readLine();
                    for (int j = 0; j < y; j++) {
                        board[h][i][j] = tmp.charAt(j);
                        if (board[h][i][j] == 'S') {
                            q.offer(new Pair(h, i, j));
                            times[h][i][j] = 1;
                        }
                    }
                }
                br.readLine();
            }

            boolean flag = false;

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                for (int i = 0; i < 6; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nz = cur.z + dz[i];

                    if (nx < 0 || nx >= x || ny < 0 || ny >= y || nz < 0 || nz >= z) {
                        continue;
                    }
                    if (board[nz][nx][ny] == '#' || times[nz][nx][ny] > 0) {
                        continue;
                    }

                    times[nz][nx][ny] = times[cur.z][cur.x][cur.y] + 1;

                    if (board[nz][nx][ny] == 'E') {
                        sb.append("Escaped in ").append(times[nz][nx][ny] - 1)
                                .append(" minute(s).\n");
                        flag = true;
                        break;
                    }
                    q.offer(new Pair(nz, nx, ny));
                }
            }
            if (!flag) {
                sb.append("Trapped!\n");
            }
        }
    }
}

class Pair {

    int z;
    int x;
    int y;

    public Pair(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}