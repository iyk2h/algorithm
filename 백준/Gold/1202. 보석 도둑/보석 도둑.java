import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long total = 0;

        List<tar> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new tar(m, v));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.m == o2.m) {
                return o2.v - o1.v;
            }
            return o1.m - o2.m;
        });

        List<Integer> bags = new ArrayList<>();
        while (k-- > 0) {
            bags.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int listIdx = 0;
        for (int bag : bags) {
            while (listIdx < n && list.get(listIdx).m <= bag) {
                pq.offer(list.get(listIdx).v);
                listIdx++;
            }
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}

class tar {

    int m;
    int v;

    public tar(int m, int v) {
        this.m = m;
        this.v = v;
    }
}