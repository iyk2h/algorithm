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

        int t = n;

        List<tar> list = new ArrayList<>();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new tar(m, v));
        }

        Collections.sort(list);

        List<Integer> bag = new ArrayList<>();

        while (k-- > 0) {
            bag.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(bag);

        long total = 0;
        int listIdx = 0;
        PriorityQueue<tar> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);

        for (Integer i : bag) {
            while (listIdx < n && list.get(listIdx).m <= i) {
                tar cur = list.get(listIdx++);
                pq.add(new tar(cur.m, cur.v));
            }
            if (!pq.isEmpty()) {
                total += pq.poll().v;
            }
        }

        System.out.println(total);
    }
}

class tar implements Comparable<tar> {

    int m;
    int v;

    public tar(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(tar o) {
        if (o.m == this.m) {
            return o.v - this.v;
        }
        return this.m - o.m;
    }
}