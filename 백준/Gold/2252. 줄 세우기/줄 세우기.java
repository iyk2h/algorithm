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
            String[] tmp = br.readLine().split(" ");
            graph.get(Integer.parseInt(tmp[0])).add(Integer.valueOf(tmp[1]));
            edgeCnt[Integer.parseInt(tmp[1])]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < edgeCnt.length; i++) {
            if (edgeCnt[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int sn = q.poll();

            sb.append(String.valueOf(sn)).append(" ");
            List<Integer> list = graph.get(sn);

            for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                edgeCnt[tmp]--;
                if (edgeCnt[tmp] == 0) {
                    q.offer(tmp);
                }
            }
        }

        System.out.println(sb);
    }
}