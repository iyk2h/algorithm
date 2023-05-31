import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] info = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            info[i][0] = Math.max(h, o);
            info[i][1] = Math.min(h, o);
        }

        int d = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            if(info[i][0] - info[i][1] > d) {
                info[i][0] = Integer.MAX_VALUE;
                info[i][1] = Integer.MAX_VALUE;
            } else {
                info[i][0] -= d;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o1[0] - o2[0];
            }
        });

        for(int[] i: info) {
            if(i[0] == Integer.MAX_VALUE && Integer.MAX_VALUE == i[1])
                continue;
            else {
                int[] l1 = new int[2];
                l1[0] = i[0];
                l1[1] = 1;
                pq.offer(l1);
                int[] l2 = new int[2];
                l2[0] = i[1];
                l2[1] = -1;
                pq.offer(l2);
            }
        }

        int max = 0;
        int current = 0;
        while(!pq.isEmpty()) {
            current += pq.poll()[1];
            max = Math.max(current, max);
        }
        System.out.println(max);
    }
}