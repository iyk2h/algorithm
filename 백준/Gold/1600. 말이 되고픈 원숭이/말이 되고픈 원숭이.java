import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][][] visited;

    static int[][] board;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int[] hdx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hdy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};

    static int min = Integer.MAX_VALUE;

    static int K, X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[X][Y][K + 1];
        board = new int[X][Y];

        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = BFS(0, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static int BFS(int x, int y) {
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(x, y, 0, K));
        visited[x][y][K] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.x == X - 1 && cur.y == Y - 1) {
                return cur.deep;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (overRange(nx, ny)) {
                    continue;
                }
                if (visited[nx][ny][cur.k] || board[nx][ny] == 1) {
                    continue;
                }
                visited[nx][ny][cur.k] = true;
                q.offer(new Pair(nx, ny, cur.deep + 1, cur.k));
            }
            if (cur.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hdx[i];
                    int ny = cur.y + hdy[i];
                    if (overRange(nx, ny)) {
                        continue;
                    }
                    if (visited[nx][ny][cur.k - 1] || board[nx][ny] == 1) {
                        continue;
                    }
                    visited[nx][ny][cur.k - 1] = true;
                    q.offer(new Pair(nx, ny, cur.deep + 1, cur.k - 1));
                }
            }
        }
        return min;
    }

    static boolean overRange(int nx, int ny) {
        return (nx < 0 || nx >= X || ny < 0 || ny >= Y);
    }
}

class Pair {

    int x;
    int y;
    int deep;
    int k;

    public Pair(int x, int y, int deep, int k) {
        this.x = x;
        this.y = y;
        this.deep = deep;
        this.k = k;
    }
}