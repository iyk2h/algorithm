import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0;

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int val = Integer.parseInt(st.nextToken());

            int targetIdx = dq.indexOf(val);
            int midIdx;

            if (dq.size() % 2 == 0) {
                midIdx = dq.size() / 2 - 1;
            } else {
                midIdx = dq.size() / 2;
            }

            if (targetIdx <= midIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    int tmp = dq.pollFirst();
                    dq.offerLast(tmp);
                    cnt++;
                }
            } else {
                for (int j = 0; j < dq.size() - targetIdx; j++) {
                    dq.offerFirst(dq.pollLast());
                    cnt++;
                }
            }
            dq.pollFirst();
        }

        System.out.println(cnt);

    }
}