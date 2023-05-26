import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int val;

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        Integer[][] a = new Integer[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                a[i][j] = s * 100 + e;
            }
        }

        Arrays.sort(a, (e1, e2) -> {
            if (Objects.equals(e1[0], e2[0])) {
                return e2[1] - e1[1];
            }
            return e1[0] - e2[0];
        });

        int cnt = 0;
        int s = 301;
        int e = 1201;
        int index = 0;
        int max = 0;

        while (s < e) {
            boolean isFind = false;

            for (int i = index; i < n; i++) {
                if (a[i][0] > s) {
                    break;
                }
                if (max < a[i][1]) {
                    isFind = true;
                    max = a[i][1];
                    index = i + 1;
                }
            }

            if (isFind) {
                s = max;
                cnt++;
            } else {
                break;
            }

        }

        if (max < e) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }
    }
}