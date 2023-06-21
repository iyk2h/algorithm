import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            while (n-- > 0) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while (pq.size() > 1) {
                long sum = pq.poll() + pq.poll();
                pq.offer(sum);
                answer += sum;
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
