import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int lastNodeIndex;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());

            while (true) {
                int otherNodeIndex = Integer.parseInt(st.nextToken());
                if (otherNodeIndex == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                tree[index].add(new Node(otherNodeIndex, weight));
            }
        }

        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(lastNodeIndex, 0);

        System.out.println(max);
    }

    public static void dfs(int index, int weight) {
        if (weight > max) {
            max = weight;
            lastNodeIndex = index;
        }
        visited[index] = true;

        for (int i = 0; i < tree[index].size(); i++) {
            Node node = tree[index].get(i);
            if (!visited[node.index]) {
                dfs(node.index, node.weight + weight);
                visited[node.index] = true;
            }
        }
    }

    public static class Node {

        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
