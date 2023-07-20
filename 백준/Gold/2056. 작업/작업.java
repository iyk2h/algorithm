import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] edge = new int[n + 1];
        int[] time = new int[n + 1];

        ArrayList<ArrayList<Integer>> board = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            for (int j = 0; j < next; j++) {
                int ni = Integer.parseInt(st.nextToken());
                board.get(ni).add(i);
                edge[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            result[i] = time[i];

            if (edge[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nx : board.get(cur)) {
                edge[nx]--;
                result[nx] = Math.max(result[nx], result[cur] + time[nx]);

                if (edge[nx] == 0) {
                    q.offer(nx);
                }
            }
        }
        Arrays.sort(result);

        System.out.println(result[result.length - 1]);
    }
}