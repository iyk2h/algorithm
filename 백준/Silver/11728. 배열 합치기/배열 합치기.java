import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] f = new int[n];
        int[] s = new int[m];
        int[] answer = new int[n + m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            f[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int fi = 0;
        int si = 0;
        for (int i = 0; i < n + m; i++) {
            if (si == m) {
                answer[i] = f[fi++];
            } else if (fi == n) {
                answer[i] = s[si++];
            } else if (f[fi] <= s[si]) {
                answer[i] = f[fi++];
            } else {
                answer[i] = s[si++];
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int j : answer) {
            sb.append(j).append(" ");
        }
        System.out.print(sb);
    }
}