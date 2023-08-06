import java.io.*;
import java.util.*;

public class Main {

    static List<ArrayList<Integer>> board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            board.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board.get(a).add(b);
            board.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] deep = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            deep[i] = -1;
        }

        q.offer(start);
        deep[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == end) {
                System.out.println(deep[cur]);
                return;
            }

            for (int i = 0; i < board.get(cur).size(); i++) {
                int next = board.get(cur).get(i);
                if (deep[next] == -1) {
                    q.offer(next);
                    deep[next] = deep[cur] + 1;
                }
            }
        }
        System.out.println(-1);
    }
}