import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();

        while (n-- > 0) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().i).append("\n");
                }
            } else {
                pq.offer(new Node(i));
            }
        }

        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {

    int i;
    int abs;

    public Node(int i) {
        this.i = i;
        this.abs = Math.abs(i);
    }

    @Override
    public int compareTo(Node o) {
        if (abs == o.abs) {
            return i - o.i;
        }
        return abs - o.abs;
    }
}