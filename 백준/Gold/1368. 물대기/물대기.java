import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int[] parents;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int[] ws = new int[n + 1];
        parents = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ws[i] = Integer.parseInt(br.readLine());
            parents[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int w = Integer.parseInt(line[j - 1]);
                if (i == j) {
                    pq.offer(new Edge(0, i, ws[i]));
                } else {
                    pq.offer(new Edge(i, j, w));
                }
            }
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (find(cur.s) == find(cur.e)) {
                continue;
            }

            union(cur.s, cur.e);
            answer += cur.cost;
        }

        System.out.println(answer);
    }

    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 > p2) {
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
        }
    }

    private static int find(int v) {
        if (parents[v] == v) {
            return v;
        } else {
            return find(parents[v]);
        }
    }
}

class Edge implements Comparable<Edge> {

    int s, e, cost;

    public Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}