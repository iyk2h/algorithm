import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dslr(a, b);
        }
    }

    private static void dslr(int a, int b) {
        visit = new boolean[10000];
        String[] commend = new String[10000];

        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        visit[a] = true;
        Arrays.fill(commend, "");
        while (!q.isEmpty() && !visit[b]) {
            int c = q.poll();
            int D = (2 * c) % 10000;
            int S = (c == 0) ? 9999 : c - 1;
            int L = (c % 1000) * 10 + c / 1000;
            int R = (c % 10) * 1000 + c / 10;

            if (!visit[D]) {
                q.add(D);
                visit[D] = true;
                commend[D] = commend[c] + "D";
            }

            if (!visit[S]) {
                q.add(S);
                visit[S] = true;
                commend[S] = commend[c] + "S";
            }

            if (!visit[L]) {
                q.add(L);
                visit[L] = true;
                commend[L] = commend[c] + "L";
            }

            if (!visit[R]) {
                q.add(R);
                visit[R] = true;
                commend[R] = commend[c] + "R";
            }
        }
        System.out.println(commend[b]);
    }
}