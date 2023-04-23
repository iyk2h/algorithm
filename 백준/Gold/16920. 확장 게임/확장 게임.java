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

        int[] pk = new int[K];
        Queue<Node>[] q = new LinkedList[K];

        int[] area = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            pk[i] = Integer.parseInt(st.nextToken());
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == '.') {
                    board[i][j] = 0;
                } else if (c == '#') {
                    board[i][j] = -1;
                } else {
                    int p = c - '0';
                    q[p - 1].offer(new Node(i, j, 0));
                    board[i][j] = 1;
                    area[p - 1]++;
                }
            }
        }

        while (true) {
            boolean isExtend = false;
            // 플레이어 순차적 확장
            for (int i = 0; i < K; i++) {
                Queue<Node> nextQ = new LinkedList<>();
                while (!q[i].isEmpty()) {
                    Node cur = q[i].poll();
                    if (cur.k >= pk[i]) {
                        nextQ.offer(new Node(cur.x, cur.y, 0));
                        continue;
                    }
                    for (int j = 0; j < 4; j++) {
                        int nx = dx[j] + cur.x;
                        int ny = dy[j] + cur.y;
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            continue;
                        }
                        if (board[nx][ny] != 0 || board[nx][ny] > board[cur.x][cur.y]) {
                            continue;
                        }
                        q[i].offer(new Node(nx, ny, cur.k + 1));
                        board[nx][ny] = board[cur.x][cur.y] + 1;
                        area[i]++;
                        isExtend = true;
                    }
                }
                q[i] = nextQ;
            }
            if (!isExtend) {
                break;
            }
        }
        for (int i = 0; i < K; i++) {
            System.out.print(area[i] + " ");
        }
    }
}

class Node {

    int x;
    int y;
    int k;

    public Node(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", k=" + k +
                '}';
    }
}