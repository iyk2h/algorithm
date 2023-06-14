import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                set.remove(input);
            }
            set.add(input);
        }

        for (String s : set) {
            sb.append(s).append("\n");
            if (--m == 0) {
                break;
            }
        }

        System.out.println(sb);
    }
}