import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int t = n;
        while (t-- > 0) {
            int tt = n;
            st = new StringTokenizer(br.readLine());
            while (tt-- > 0) {
                pq.offer(Integer.valueOf(st.nextToken()));
            }
        }
        
        while (n-- > 1) {
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
