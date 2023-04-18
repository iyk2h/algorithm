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

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            char[][] board = new char[x][y];
            int[][] fire = new int[x][y];
            int[][] hum = new int[x][y];

            Queue<Pair> fireQ = new LinkedList<>();
            Queue<Pair> humQ = new LinkedList<>();

            for (int i = 0; i < x; i++) {
                String str = br.readLine();
                for (int j = 0; j < y; j++) {
                    char c = str.charAt(j);
                    board[i][j] = c;
                    if (c == '*') {
                        fireQ.offer(new Pair(i, j));
                        fire[i][j] = 1;
                    }
                    if (c == '@') {
                        humQ.offer(new Pair(i, j));
                        hum[i][j] = 1;
                    }
                }
            }

            // 불 번짐
            while (!fireQ.isEmpty()) {
                Pair cur = fireQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                        continue;
                    }
                    if (board[nx][ny] == '#' || fire[nx][ny] > 0) {
                        continue;
                    }
                    fireQ.offer(new Pair(nx, ny));
                    fire[nx][ny] = fire[cur.x][cur.y] + 1;
                }
            }

            boolean flag = false;

            // 상근이 이동
            while (!humQ.isEmpty() && !flag) {
                Pair cur = humQ.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                        flag = true;
                        sb.append(hum[cur.x][cur.y]).append("\n");
                        break;
                    }
                    if (board[nx][ny] == '#') {
                        continue;
                    }
                    if (hum[nx][ny] > 0) {
                        continue;
                    }
                    if (fire[nx][ny] != 0 && hum[cur.x][cur.y] + 1 >= fire[nx][ny]) {
                        continue;
                    }
                    humQ.offer(new Pair(nx, ny));
                    hum[nx][ny] = hum[cur.x][cur.y] + 1;
                }
            }

            if (!flag) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.println(sb);
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