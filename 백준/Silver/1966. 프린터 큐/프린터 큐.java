import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Pair> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.offer(new Pair(j, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;

            while (!q.isEmpty()) {
                Pair front = q.poll();
                boolean isMax = true;

                for (int j = 0; j < q.size(); j++) {
                    if (front.order < q.get(j).order) {
                        q.offer(front);
                        for (int k = 0; k < j; k++) {
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }

                }
                if (!isMax) {
                    continue;
                }

                cnt++;
                if (front.index == m) {
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static class Pair {

        int index;
        int order;

        public Pair(int index, int order) {
            this.index = index;
            this.order = order;
        }
    }
}