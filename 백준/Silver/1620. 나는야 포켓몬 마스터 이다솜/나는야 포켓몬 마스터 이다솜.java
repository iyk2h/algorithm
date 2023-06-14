import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] strings = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            strings[i] = br.readLine();
            hashMap.put(strings[i], i);
        }

        while (m-- > 0) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                sb.append(strings[Integer.parseInt(input)]);
            } else {
                sb.append(hashMap.get(input));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}