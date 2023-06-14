import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> hash = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String input = st.nextToken();
            String pw = st.nextToken();
            if (hash.containsKey(input)) {
                hash.remove(input);
            }
            hash.put(input, pw);
        }

        while (m-- > 0) {
            sb.append(hash.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}