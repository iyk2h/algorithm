import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> arr;
    public static boolean[] visited;
    public static int start;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            arr = new ArrayList<>();

            int N = Integer.parseInt(br.readLine());

            visited = new boolean[N + 1];
            for (int j = 0; j <= N; j++) {
                arr.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr.get(j).add(Integer.valueOf(st.nextToken()));
            }

            count = 0;
            for (int j = 1; j <= N; j++) {
                start = j;
                if (!visited[j]) {
                    dfs(j);
                }
            }
            System.out.println(count);
        }

    }

    public static void dfs(int v) {
        visited[v] = true;
        for (int i = 0; i < arr.get(v).size(); i++) {
            int x = arr.get(v).get(i);
            if (x == start) {
                count++;
            }
            if (!visited[x]) {
                dfs(x);
            }
        }
    }
}