import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int[][] board = new int[N][M];
        boolean[][][] visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                int a = str.charAt(j) - '0';
                board[i][j] = a;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0, 1, true));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.cnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny][cur.k]) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    if (cur.k < K) {
                        if (visited[nx][ny][cur.k + 1]) {
                            continue;
                        }
                        if (cur.T) {
                            q.offer(new Node(nx, ny, cur.k + 1, cur.cnt + 1, !cur.T));
                            visited[nx][ny][cur.k + 1] = true;
                        } else {
                            q.offer(new Node(cur.x, cur.y, cur.k, cur.cnt + 1, !cur.T));
                        }
                    }
                }
                if (board[nx][ny] == 0) {
                    q.offer(new Node(nx, ny, cur.k, cur.cnt + 1, !cur.T));
                    visited[nx][ny][cur.k] = true;
                }
            }
        }
        System.out.println(-1);
    }
}

class Node {

    int x;
    int y;
    int k;
    int cnt;
    boolean T;

    public Node(int x, int y, int k, int cnt, boolean t) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.cnt = cnt;
        T = t;
    }
}