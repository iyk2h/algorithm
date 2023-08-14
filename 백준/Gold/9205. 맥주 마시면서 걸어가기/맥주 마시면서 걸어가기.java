import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<Node> list = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
            }

            ArrayList<ArrayList<Integer>> board = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                board.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Manhattan(list.get(i), list.get(j)) <= 1000) {
                        board.get(i).add(j);
                        board.get(j).add(i);
                    }
                }
            }
            sb.append((bfs(board, n)) ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> board, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == n + 1) {
                return true;
            }

            for (int next : board.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }

    public static int Manhattan(Node n1, Node n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }
}

class Node {

    int x, y;

    public Node(int _x, int _y) {
        x = _x;
        y = _y;
    }
}