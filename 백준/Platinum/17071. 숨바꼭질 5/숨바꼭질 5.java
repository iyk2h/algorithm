import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_LENGTH = 500_000;
    static int sis;
    static int bro;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sis = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        visit = new boolean[2][MAX_LENGTH + 1];

        System.out.println(sis == bro ? 0 : String.valueOf(bfs()));
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(sis);
        visit[0][sis] = true;

        int size, mod, time = 0;
        while (!q.isEmpty()) {
            size = q.size();
            time++;
            mod = time % 2;

            bro += time;
            if (bro > MAX_LENGTH) {
                return -1;
            }

            while (size-- > 0) {
                int cur = q.poll();

                if (cur - 1 >= 0 && !visit[mod][cur - 1]) {
                    q.offer(cur - 1);
                    visit[mod][cur - 1] = true;
                }

                if (cur + 1 <= MAX_LENGTH && !visit[mod][cur + 1]) {
                    q.offer(cur + 1);
                    visit[mod][cur + 1] = true;
                }

                if (cur * 2 <= MAX_LENGTH && !visit[mod][cur * 2]) {
                    q.offer(cur * 2);
                    visit[mod][cur * 2] = true;
                }
            }

            if (visit[mod][bro]) {
                return time;
            }
        }
        return -1;
    }
}