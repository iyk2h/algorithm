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

        char[][] board = new char[x][y];
        int[][] pairDist = new int[x][y];
        int[][] fireDist = new int[x][y];

        Queue<Pair> pairQueue = new LinkedList<>();
        Queue<Fire> fireQueue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < y; j++) {
                fireDist[i][j] = -1;
                pairDist[i][j] = -1;
                if (chars[j] == 'F') {
                    fireQueue.add(new Fire(i, j));
                    fireDist[i][j] = 0;
                }
                if (chars[j] == 'J') {
                    pairQueue.add(new Pair(i, j));
                    pairDist[i][j] = 0;
                }
                board[i][j] = chars[j];
            }
        }

        while (!fireQueue.isEmpty()) {
            Fire cur = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    continue;
                }
                if (board[nx][ny] == '#' || fireDist[nx][ny] >= 0) {
                    continue;
                }
                fireDist[nx][ny] = fireDist[cur.x][cur.y] + 1;
                fireQueue.offer(new Fire(nx, ny));
            }
        }

        while (!pairQueue.isEmpty()) {
            Pair cur = pairQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= x || ny < 0 || ny >= y) {
                    System.out.println(pairDist[cur.x][cur.y] + 1);
                    return;
                }
                if (board[nx][ny] == '#' || pairDist[nx][ny] >= 0) {
                    continue;
                }
                if (pairDist[cur.x][cur.y] + 1 >= fireDist[nx][ny] && fireDist[nx][ny] != -1) {
                    continue;
                }
                pairDist[nx][ny] = pairDist[cur.x][cur.y] + 1;
                pairQueue.offer(new Pair(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
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

class Fire {

    int x;
    int y;

    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
    }
}