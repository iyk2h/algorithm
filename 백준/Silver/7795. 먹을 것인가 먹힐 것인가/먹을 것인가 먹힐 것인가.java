import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] xb = new int[x];
            int[] yb = new int[y];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < x; i++) {
                xb[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < y; i++) {
                yb[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(xb);
            Arrays.sort(yb);

            int cnt = 0;

            for (int i = 0; i < x; i++) {
                for (int yy : yb) {
                    if (xb[i] > yy) {
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}