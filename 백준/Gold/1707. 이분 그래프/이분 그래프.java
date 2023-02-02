import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> arr;
    public static int[] color;
    public static boolean isBipartiteGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();
            color = new int[V + 1];
            isBipartiteGraph = true;

            for (int j = 0; j <= V; j++) {
                arr.add(new ArrayList<>());
                color[j] = 0;
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                arr.get(first).add(second);
                arr.get(second).add(first);
            }

            for (int j = 1; j <= V; j++) {
                Collections.sort(arr.get(j));
            }

            for (int j = 1; j <= V; j++) {
                if (!isBipartiteGraph) {
                    break;
                }
                if (color[j] == 0) {
                    bfs(j, 1);
                }
            }
            System.out.println(isBipartiteGraph ? "YES" : "NO");
        }


    }

    private static void bfs(int v, int inputColor) {
        Queue<Integer> queue = new LinkedList<>();

        color[v] = inputColor;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int y = queue.poll();

            for (int i = 0; i < arr.get(y).size(); i++) {
                Integer x = arr.get(y).get(i);
                if (color[x] == 0) {
                    queue.offer(x);
                    color[x] = -1 * color[y];
                } else if (color[y] + color[x] != 0) {
                    isBipartiteGraph = false;
                    return;
                }
            }
        }
    }
}




