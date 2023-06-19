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

            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                String in = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (in.equals("I")) {
                    map.put(val, map.getOrDefault(val, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    int key = -1;
                    if (val == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.println(sb);
    }
}