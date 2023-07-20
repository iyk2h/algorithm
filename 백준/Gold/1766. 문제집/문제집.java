import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        int[] cnt = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board.get(a).add(b);
            cnt[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i < n + 1; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            for (int next : board.get(cur)) {
                cnt[next]--;
                if (cnt[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}