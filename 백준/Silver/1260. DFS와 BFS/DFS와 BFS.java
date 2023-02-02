import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr.get(first).add(second);
            arr.get(second).add(first);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(arr.get(i + 1));
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int v) {
        dfsVisited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < arr.get(v).size(); i++) {
            int y = arr.get(v).get(i);
            if (!dfsVisited[y]) {
                dfs(y);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        bfsVisited[v] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");
            for (int i = 0; i < arr.get(x).size(); i++) {
                Integer y = arr.get(x).get(i);
                if (!bfsVisited[y]) {
                    queue.offer(y);
                    bfsVisited[y] = true;
                }
            }
        }
    }

}
