import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static boolean[] finished;
    static int count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                dfs(j);
            }

            System.out.println(n - count);
        }
    }

    static void dfs(int now) {
        if (visited[now]) {
            return;
        }

        visited[now] = true;
        int tmp = arr[now];

        if (!visited[tmp]) {
            dfs(tmp);
        } else {
            if (!finished[tmp]) {
                count++;
                for (int k = tmp; k != now; k = arr[k]) {
                    count++;
                }
            }
        }

        finished[now] = true;
    }
}