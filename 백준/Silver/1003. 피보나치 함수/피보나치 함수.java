import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] fibo = new int[41][2];

        fibo[0][0] = 1;
        fibo[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int f = Integer.parseInt(br.readLine());
            sb.append(fibo[f][0]).append(" ").append(fibo[f][1]).append("\n");
        }
        System.out.println(sb);
    }
}