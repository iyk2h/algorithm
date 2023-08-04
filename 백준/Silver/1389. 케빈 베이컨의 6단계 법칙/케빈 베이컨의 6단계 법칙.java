import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int INF = Integer.MAX_VALUE / 2;

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = INF;
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int res = INF;
        int idx = -1;

        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += arr[i][j];
            }

            if (res > total) {
                res = total;
                idx = i;
            }

        }
        System.out.println(idx);
    }
}