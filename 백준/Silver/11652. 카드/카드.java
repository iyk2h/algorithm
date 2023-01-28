import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            Long input = Long.parseLong(br.readLine());

            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        long answer = 0;
        for (long key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            } else if (map.get(key) == max) {
                answer = Math.min(answer, key);
            }
        }

        System.out.println(answer);
    }
}