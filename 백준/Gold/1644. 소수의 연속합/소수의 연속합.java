import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primgList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                primgList.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int total = 0;
        int len = primgList.size();

        while (true) {
            if (total >= n) {
                total -= primgList.get(start++);
            } else if (end == len) {
                break;
            } else {
                total += primgList.get(end++);
            }

            if (total == n) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}