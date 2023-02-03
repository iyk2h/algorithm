import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[] visited = new boolean[N + 1];
            int[] arr = new int[N + 1];
            int count = 0;

            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                if (visited[j]) {
                    continue;
                }
                int tmp = arr[j];
                while (true) {
                    if (visited[tmp]) {
                        count++;
                        break;
                    }
                    visited[tmp] = true;
                    tmp = arr[tmp];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}