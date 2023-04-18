import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] dx = new int[]{u, -d};
        int[] board = new int[f + 1];

        for (int i = 1; i <= f; i++) {
            board[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        board[s] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 2; i++) {
                int nx = cur + dx[i];
                if (nx < 0 || nx > f || board[nx] != -1) {
                    continue;
                }
                q.offer(nx);
                board[nx] = board[cur] + 1;
            }
        }
        if (board[g] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(board[g]);
        }
    }
}