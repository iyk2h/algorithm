import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Node>> board = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++) {
            board.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            board.get(v1).add(new Node(v2, cost));
        }

        Dijkstra(v, start);

    }

    private static void Dijkstra(int n, int start) {
        boolean[] visit = new boolean[n + 1];
        int[] dist = new int[n + 1];

        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);

        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int curIndex = pq.poll().index;
            if (visit[curIndex]) {
                continue;
            }
            visit[curIndex] = true;

            for (Node next : board.get(curIndex)) {
                if (dist[next.index] > dist[curIndex] + next.cost) {
                    dist[next.index] = dist[curIndex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

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