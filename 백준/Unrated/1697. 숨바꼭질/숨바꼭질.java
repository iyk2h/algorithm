import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] visited = new int[100002];

        for (int i = 0; i < 100002; i++) {
            visited[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        visited[x] = 0;

        q.offer(x);

        while (visited[y] == -1) {
            int cur = q.poll();
            for (int nxt : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (nxt < 0 || nxt > 100000) {
                    continue;
                }
                if (visited[nxt] != -1) {
                    continue;
                }
                visited[nxt] = visited[cur] + 1;
                q.offer(nxt);
            }
        }
        System.out.println(visited[y]);
    }
}