import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] arr = new int[x][y];
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int mx = 0;
        int cnt = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (visited[i][j] || arr[i][j] == 0) {
                    continue;
                }
                Queue<Pair> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.offer(new Pair(i, j));
                cnt++;

                int area = 0;
                while (!queue.isEmpty()) {
                    area++;
                    Pair cur = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = cur.getX() + dx[k];
                        int ny = cur.getY() + dy[k];
                        if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                            continue;
                        }
                        if (visited[nx][ny] || arr[nx][ny] != 1) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new Pair(nx, ny));
                    }
                }
                mx = Math.max(mx, area);
            }
        }
        System.out.println(cnt);
        System.out.println(mx);
    }
}


class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}