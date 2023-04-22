import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static final int LMT = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sis = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());

        int[] visited = new int[LMT + 2];
        int[] log = new int[LMT + 2];

        log[sis] = sis;

        Queue<Integer> q = new LinkedList<>();

        q.offer(sis);
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == bro) {
                System.out.println(visited[cur]);
                break;
            }

            for (int i : new int[]{cur + 1, cur - 1, cur * 2}) {
                if (i < 0 || i >= LMT) {
                    continue;
                }
                if (visited[i] > 0) {
                    continue;
                }
                visited[i] = visited[cur] + 1;
                q.offer(i);
                log[i] = cur;
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(bro);
        int idx = bro;

        while (idx != sis) {
            stack.push(log[idx]);
            idx = log[idx];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}