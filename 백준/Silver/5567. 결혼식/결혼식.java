import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        vis = new boolean[n + 1];

        arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dfs(1, 0);

        int cnt = 0;

        for (int i = 2; i < vis.length; i++) {
            if (vis[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int cur, int depth) {
        if (depth == 2) {
            return;
        }

        for (int i : arr.get(cur)) {
            vis[i] = true;
            dfs(i, depth + 1);
        }
    }
}
