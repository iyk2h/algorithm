import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int x;
    static int y;
    static int[][] board;
    static int[][][] deep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        board = new int[x][y];
        deep = new int[x][y][2];

        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(dfs());
    }

    private static int dfs() {

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                deep[i][j][0] = deep[i][j][1] = -1;
            }
        }

        deep[0][0][0] = deep[0][0][1] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.x == x - 1 && cur.y == y - 1) {
                return deep[cur.x][cur.y][cur.z];
            }
            int nextDeep = deep[cur.x][cur.y][cur.z] + 1;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (OOB(nx, ny)) {
                    continue;
                }
                if (board[nx][ny] == 0 && deep[nx][ny][cur.z] == -1) {
                    deep[nx][ny][cur.z] = nextDeep;
                    q.offer(new Pair(nx, ny, cur.z));
                }

                // 벽 부쉼
                if (cur.z != 1 && board[nx][ny] == 1 && deep[nx][ny][1] == -1) {
                    deep[nx][ny][1] = nextDeep;
                    q.offer(new Pair(nx, ny, 1));
                }
            }
        }

        return -1;
    }

    private static boolean OOB(int nx, int ny) {
        return nx < 0 || nx >= x || ny < 0 || ny >= y;
    }
}

class Pair {

    int x;

    int y;
    int z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}