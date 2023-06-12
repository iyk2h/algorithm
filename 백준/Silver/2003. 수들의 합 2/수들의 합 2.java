import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int total = 0;
        int len = list.size();

        while (true) {
            if (total >= m) {
                total -= list.get(start++);
            } else if (end == len) {
                break;
            } else {
                total += list.get(end++);
            }

            if (total == m) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}