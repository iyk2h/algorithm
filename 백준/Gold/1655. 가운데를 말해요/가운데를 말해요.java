import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();

        while (t-- > 0) {

            int i = Integer.parseInt(br.readLine());

            if (leftQ.size() == rightQ.size()) {
                leftQ.offer(i);
                if (!rightQ.isEmpty() && leftQ.peek() > rightQ.peek()) {
                    leftQ.offer(rightQ.poll());
                    rightQ.offer(leftQ.poll());
                }
            } else {
                rightQ.offer(i);
                if (leftQ.peek() > rightQ.peek()) {
                    leftQ.offer(rightQ.poll());
                    rightQ.offer(leftQ.poll());
                }
            }

            sb.append(leftQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
