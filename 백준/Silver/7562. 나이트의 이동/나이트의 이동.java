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

        int n = Integer.parseInt(br.readLine());

        int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());

            int[][] board = new int[len][len];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Pair start = new Pair(st.nextToken(), st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            Pair end = new Pair(st.nextToken(), st.nextToken());

            Queue<Pair> q = new LinkedList<>();
            q.add(start);

            while (!q.isEmpty()) {
                Pair cur = q.poll();
                if (cur.equals(end)) {
                    sb.append(board[cur.x][cur.y]).append("\n");
                    break;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || nx >= len || ny < 0 || ny >= len) {
                        continue;
                    }
                    if (board[nx][ny] > 0) {
                        continue;
                    }
                    board[nx][ny] = board[cur.x][cur.y] + 1;
                    q.offer(new Pair(nx, ny));
                }
            }
        }
        System.out.println(sb);
    }
}

class Pair {

    int x;

    int y;

    public Pair(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Pair obj) {
        return obj.x == this.x && obj.y == this.y;
    }
}