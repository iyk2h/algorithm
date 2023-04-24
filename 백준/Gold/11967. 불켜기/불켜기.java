import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static LinkedList<Node>[][] board;
    static boolean[][] visit;
    static boolean[][] lights;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new LinkedList[N][N];
        lights = new boolean[N][N];

        lights[0][0] = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            int a = Integer.parseInt(input[2]) - 1;
            int b = Integer.parseInt(input[3]) - 1;

            board[x][y].add(new Node(a, b));
        }

        System.out.println(bfs() + 1);


    }

    static boolean isNotRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    static int bfs() {
        int cnt = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visit = new boolean[N][N];

        boolean isSwitchOn = false;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node turnOn : board[cur.x][cur.y]) {
                if (!lights[turnOn.x][turnOn.y]) {
                    isSwitchOn = true;
                    lights[turnOn.x][turnOn.y] = true;
                    cnt++;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isNotRange(nx, ny)) {
                    continue;
                }
                if (visit[nx][ny] || !lights[nx][ny]) {
                    continue;
                }
                q.offer(new Node(nx, ny));
                visit[nx][ny] = true;
            }
        }

        if (isSwitchOn) {
            return cnt + bfs();
        }
        return cnt;
    }
}

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node{" + "x=" + x + ", y=" + y + '}';
    }
}