import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][n + 1];
        boolean[] vis = new boolean[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[b][a] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            for (int i = 1; i < board[cur].length; i++) {
                if (board[cur][i] == 0) {
                    continue;
                }
                if (vis[i]) {
                    continue;
                }
                q.offer(i);
                vis[i] = true;
            }
        }

        System.out.println(cnt - 1);
    }
}
