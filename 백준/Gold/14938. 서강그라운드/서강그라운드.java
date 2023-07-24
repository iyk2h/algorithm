import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Node>> board;
    static int[] dist, item;
    static boolean[] visit;
    static int n, m;
    static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            board.add(new ArrayList<>());
        }
        item = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            board.get(v1).add(new Node(v2, cost));
            board.get(v2).add(new Node(v1, cost));
        }

        dist = new int[n + 1];
        visit = new boolean[n + 1];

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, dijkstra(i));
        }

        System.out.println(ans);
    }

    private static int dijkstra(int i) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visit, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(i, 0));
        dist[i] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visit[cur.index]) {
                visit[cur.index] = true;

                for (Node next : board.get(cur.index)) {
                    if (!visit[next.index] && dist[next.index] > dist[cur.index] + next.cost) {
                        dist[next.index] = dist[cur.index] + next.cost;
                        pq.offer(new Node(next.index, dist[next.index]));
                    }
                }
            }
        }

        int res = 0;

        for (int j = 1; j < n + 1; j++) {
            if (dist[j] <= m) {
                res += item[j];
            }
        }

        return res;
    }
}

class Node implements Comparable<Node> {

    int index, cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}