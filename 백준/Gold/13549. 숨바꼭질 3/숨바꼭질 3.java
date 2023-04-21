import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static Queue<Pair> q;
    static final int LMT = 100001;
    static int s, g;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        visited = new boolean[LMT + 2];

        Pair sis = new Pair(s, 0);
        q.offer(sis);
        teleport(sis);

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int idx = cur.idx;
            visited[idx] = true;
            if (idx == g) {
                System.out.println(cur.time);
                return;
            }
            for (int i : new int[]{idx - 1, idx + 1, idx * 2}) {
                if (i < 0 || i >= LMT) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                Pair nx = new Pair(i, cur.time + 1);
                q.offer(nx);
                visited[i] = true;
                teleport(nx);
            }
        }
    }

    static void teleport(Pair i) {
        int tmp = i.idx;
        if (tmp == 0) {
            return;
        }
        while (tmp < LMT && !visited[g]) {
            if (!visited[tmp]) {
                visited[tmp] = true;
                q.offer(new Pair(tmp, i.time));
                if (tmp == g) {
                    return;
                }
            }
            tmp <<= 1;
        }
    }
}

class Pair {

    int idx;
    int time;

    public Pair(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}