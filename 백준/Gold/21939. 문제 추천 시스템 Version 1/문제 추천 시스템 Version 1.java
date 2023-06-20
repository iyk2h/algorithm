import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeSet<Node> board = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            board.add(new Node(num, level));
            map.put(num, level);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "add":
                    int num = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    board.add(new Node(num, level));
                    map.put(num, level);
                    break;
                case "recommend":
                    int q = Integer.parseInt(st.nextToken());
                    if (q == 1) {
                        sb.append(board.last().n).append("\n");
                    } else {
                        sb.append(board.first().n).append("\n");
                    }
                    break;
                case "solved":
                    int key = Integer.parseInt(st.nextToken());
                    int ml = map.get(key);
                    board.remove(new Node(key, ml));
                    map.remove(key);
                    break;

            }

        }

        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {

    int n;
    int l;

    public Node(int n, int l) {
        this.n = n;
        this.l = l;
    }

    @Override
    public int compareTo(Node o) {
        if (l == o.l) {
            return n - o.n;
        }
        return l - o.l;
    }

    @Override
    public String toString() {
        return n + " " + l;
    }
}