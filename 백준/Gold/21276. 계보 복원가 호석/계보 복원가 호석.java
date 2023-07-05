import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            names[i] = st.nextToken();
        }
        Arrays.sort(names);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(names[i], i);
        }

        int[] edgeCnt = new int[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = map.get(st.nextToken());
            int p = map.get(st.nextToken());

            graph.get(p).add(s);
            edgeCnt[s]++;
        }

        Queue<Integer> q = new LinkedList<>();

        List<Integer> root = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (edgeCnt[i] == 0) {
                root.add(i);
                q.offer(i);
            }
        }

        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (--edgeCnt[next] == 0) {
                    q.offer(next);
                    children.get(cur).add(next);
                }
            }
        }

        sb.append(root.size()).append("\n");

        for (int i : root) {
            sb.append(names[i]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(names[i]).append(" ").append(children.get(i).size()).append(" ");
            children.get(i).sort(null);
            for (int ci : children.get(i)) {
                sb.append(names[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}