import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> hash = new HashMap<>();

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String kind = st.nextToken();

                hash.put(kind, hash.getOrDefault(kind, 0) + 1);
            }
            int result = 1;

            for (int val : hash.values()) {
                result *= (val + 1);
            }
            sb.append(result - 1).append("\n");

        }
        System.out.println(sb);
    }
}