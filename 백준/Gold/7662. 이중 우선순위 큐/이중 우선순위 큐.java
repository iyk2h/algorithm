import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> que = new TreeMap<>();

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String in = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (in.equals("I")) {
                    que.put(val, que.getOrDefault(val, 0) + 1);
                } else {
                    if (que.isEmpty()) {
                        continue;
                    }
                    int num = val == 1 ? que.lastKey() : que.firstKey();
                    if (que.put(num, que.get(num) - 1) == 1) {
                        que.remove(num);
                    }
                }

            }
            sb.append(que.isEmpty() ? "EMPTY" : que.lastKey() + " " + que.firstKey()).append("\n");
        }

        System.out.println(sb);
    }
}