import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<Edge>[] edges;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[V + 1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[start].add(new Edge(end, cost));
            edges[end].add(new Edge(start, cost));
        }

        prim(1, V);

    }

    private static void prim(int start, int n) {
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int v = cur.w;
            int cost = cur.cost;

            if (visit[v]) {
                continue;
            }

            visit[v] = true;
            total += cost;

            for (Edge nx : edges[v]) {
                if (!visit[nx.w]) {
                    pq.offer(nx);
                }
            }
        }
        System.out.println(total);
    }
}

class Edge implements Comparable<Edge> {

    int w, cost;

    public Edge(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}