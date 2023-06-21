import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int sum = 0;
        int t = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            list.add(new Node(d, n));
        }

        Collections.sort(list);

        for (Node node : list) {
            int size = pq.size();

            if (size < node.d) {
                pq.offer(node.n);
            } else if (size == node.d) {
                int peak = pq.peek();
                if (node.n > peak) {
                    pq.poll();
                    pq.offer(node.n);
                }
            }
        }

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}

class Node implements Comparable<Node> {

    int d;
    int n;

    public Node(int d, int n) {
        this.d = d;
        this.n = n;
    }

    @Override
    public int compareTo(Node o) {
        if (d == o.d) {
            return o.n - this.n;
        }
        return this.d - o.d;
    }
}