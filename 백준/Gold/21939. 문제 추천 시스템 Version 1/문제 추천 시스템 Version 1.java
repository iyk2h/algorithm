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

        TreeSet<Node> set = new TreeSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            set.add(new Node(num, level));
            hashMap.put(num, level);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();

            switch (input) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == 1) {
                        sb.append(set.last().n).append("\n");
                    } else {
                        sb.append(set.first().n).append("\n");
                    }
                    break;
                case "add":
                    int num = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    set.add(new Node(num, level));
                    hashMap.put(num, level);
                    break;
                case "solved":
                    int p = Integer.parseInt(st.nextToken());
                    int l = hashMap.get(p);
                    set.remove(new Node(p, l));
                    hashMap.remove(p);
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