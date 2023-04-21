import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, deep;
    static int[][] board;
    static int[][] deeps;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;

        board = new int[N][N];
        deeps = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 색릴하기
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                    deep++;
                    board[i][j] = deep;
                }

                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    board[cur.x][cur.y] = deep;
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (outRange(nx, ny)) {
                            continue;
                        }
                        if (visited[nx][ny] || board[nx][ny] == 0) {
                            continue;
                        }
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }

                }
            }
        }

        // 다른 섬 찾기
        visited = new boolean[N][N];
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] < 1 || visited[i][j]) {
                    continue;
                }
                int nowDeep = board[i][j];
                q.offer(new Pair(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (outRange(nx, ny)) {
                            continue;
                        }
                        if (!visited[nx][ny] && board[nx][ny] != nowDeep) {
                            visited[nx][ny] = true;
                            if (board[nx][ny] == 0) {
                                q.offer(new Pair(nx, ny));
                                deeps[nx][ny] = deeps[cur.x][cur.y] + 1;
                            } else {
                                answer = Math.min(answer, deeps[cur.x][cur.y]);
                            }
                        }
                    }
                }
                visited = new boolean[N][N];
            }
        }
        System.out.println(answer);
    }

    static boolean outRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}