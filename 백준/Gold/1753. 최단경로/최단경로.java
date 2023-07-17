import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<Node>[] graph;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];


        for (int i = 0; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v1].add(new Node(v2, cost));
        }

        Dijkstra(v, start);
    }

    private static void Dijkstra(int n, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.poll().index;

            if (check[cur]) {
                continue;
            }

            check[cur] = true;

            for (Node next : graph[cur]) {
                if (dist[next.index] > dist[cur] + next.cost) {
                    dist[next.index] = dist[cur] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        dist[0] = Integer.MIN_VALUE;

        for (int i : dist) {
            if (i == Integer.MIN_VALUE) {
            } else if (i == INF) {
                System.out.println("INF");
            } else {
                System.out.println(i);
            }
        }
    }
}

class Node implements Comparable<Node> {

    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}