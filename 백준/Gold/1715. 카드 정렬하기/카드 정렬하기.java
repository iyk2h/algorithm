import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (n-- > 0) {
            pq.offer(Integer.valueOf(br.readLine()));
        }

        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            pq.offer(sum);
            answer += sum;
        }

        System.out.println(answer);
    }
}
