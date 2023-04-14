import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] board = new int[x][y];

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                int nx = Integer.parseInt(input[0]);
                int ny = Integer.parseInt(input[1]);
                board[nx][ny] = 1;
            }

            int cnt = 0;
            for (int j = 0; j < x; j++) {
                for (int l = 0; l < y; l++) {
                    if (board[j][l] == 0) {
                        continue;
                    }
                    Queue<Pair> q = new LinkedList<>();

                    cnt++;
                    q.offer(new Pair(j, l));
                    board[j][l] = 0;

                    while (!q.isEmpty()) {
                        Pair cur = q.poll();

                        for (int m = 0; m < 4; m++) {
                            int nx = cur.x + dx[m];
                            int ny = cur.y + dy[m];

                            if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                                continue;
                            }
                            if (board[nx][ny] == 0) {
                                continue;
                            }
                            board[nx][ny] = 0;
                            q.offer(new Pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
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