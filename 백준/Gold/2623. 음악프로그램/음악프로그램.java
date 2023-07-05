import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] edgeCnt = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int cur = Integer.parseInt(st.nextToken());
                graph.get(before).add(cur);
                edgeCnt[cur]++;

                before = cur;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (edgeCnt[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);

            for (int next : graph.get(cur)) {
                if (--edgeCnt[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (result.size() != n) {
            sb.append("0").append("\n");
        } else {
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }
}