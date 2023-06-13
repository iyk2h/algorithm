import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> hashMap = new HashMap<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            String state = st.nextToken();

            if (hashMap.containsKey(name)) {
                hashMap.remove(name);
            } else {
                hashMap.put(name, state);
            }
        }

        List<String> list = new ArrayList<String>(hashMap.keySet());

        sb.append(
                list.stream()
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.joining("\n")));

        System.out.println(sb);
    }
}