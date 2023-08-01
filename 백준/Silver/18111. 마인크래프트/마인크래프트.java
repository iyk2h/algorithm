import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int max = 0;
        int min = 256;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }

        int time = 999999999;
        int high = 0;

        for (int t = min; t <= max; t++) {
            int cnt = 0;
            int block = b;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (t < arr[i][j]) {
                        cnt += ((arr[i][j] - t) * 2);
                        block += (arr[i][j] - t);
                    } else {
                        cnt += (t - arr[i][j]);
                        block -= (t - arr[i][j]);
                    }
                }
            }

            if (block < 0) {
                break;
            }
            if (time >= cnt) {
                time = cnt;
                high = t;
            }
        }

        System.out.println(time + " " + high);

    }
}