import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, cost));
        }

        edges.sort(Comparator.comparingInt(o -> o.cost));

        int[] parent = new int[V + 1];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int answer = 0;

        for (int i = 0; i < E; i++) {
            Edge cur = edges.get(i);
            if (!isCameParent(parent, cur.s, cur.e)) {
                union(parent, cur.s, cur.e);
                answer += cur.cost;
            }
        }

        System.out.println(answer);
    }

    private static boolean isCameParent(int[] parent, int s, int e) {
        s = find(parent, s);
        e = find(parent, e);

        return s == e;
    }

    private static int find(int[] parent, int s) {
        if (parent[s] == s) {
            return s;
        } else {
            return parent[s] = find(parent, parent[s]);
        }
    }

    private static void union(int[] parent, int s, int e) {
        s = find(parent, s);
        e = find(parent, e);
        if (s != e) {
            parent[e] = s;
        }
    }
}

class Edge {

    int s, e, cost;

    public Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
}