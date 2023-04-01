import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] ar) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

//        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> one = new HashMap<>();
        HashMap<Integer, Integer> zero = new HashMap<>();

        String str = br.readLine();
        int n = Integer.parseInt(str.split(" ")[0]);
        int k = Integer.parseInt(str.split(" ")[1]);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int s = Integer.parseInt(line.split(" ")[0]);
            int y = Integer.parseInt(line.split(" ")[1]);

            if (s == 0) {
                zero.put(y, zero.getOrDefault(y, 0) + 1);
            } else if (s == 1) {
                one.put(y, one.getOrDefault(y, 0) + 1);
            }
        }

        for (Entry<Integer, Integer> e : zero.entrySet()) {
            int cnt = e.getValue();
            while (cnt > 0) {
                answer++;
                cnt -= k;
            }
        }
        for (Entry<Integer, Integer> e : one.entrySet()) {
            int cnt = e.getValue();
            while (cnt > 0) {
                answer++;
                cnt -= k;
            }
        }

        System.out.println(answer);
    }
}