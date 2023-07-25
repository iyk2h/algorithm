import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x;
    static ArrayList<ArrayList<Node>> board;
    static ArrayList<ArrayList<Node>> reverse_board;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        board = new ArrayList<>();
        reverse_board = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            board.add(new ArrayList<>());
            reverse_board.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            board.get(s).add(new Node(e, val));
            reverse_board.get(e).add(new Node(s, val));
        }

        int[] dist1 = dikstra(board);
        int[] dist2 = dikstra(reverse_board);

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        System.out.println(ans);
    }

    private static int[] dikstra(ArrayList<ArrayList<Node>> list) {
        int[] dist = new int[n + 1];
        boolean[] visit = new boolean[n + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[x] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visit[cur.index]) {
                continue;
            }
            visit[cur.index] = true;
            for (Node next : list.get(cur.index)) {
                if (dist[next.index] > dist[cur.index] + next.cost) {
                    dist[next.index] = dist[cur.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        return dist;
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
        return cost - o.cost;
    }
}