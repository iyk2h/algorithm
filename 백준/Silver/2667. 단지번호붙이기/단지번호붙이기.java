import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] apart;
    static int apartNum;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        apart = new int[N * N];
        visited = new boolean[N][N];
        apartNum = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    dfs(i, j);
                }
            }
        }

        Arrays.sort(apart);
        System.out.println(apartNum);
        for (int i = 0; i < apart.length; i++) {
            if (apart[i] == 0) {
            } else {
                System.out.println(apart[i]);
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        apart[apartNum]++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}