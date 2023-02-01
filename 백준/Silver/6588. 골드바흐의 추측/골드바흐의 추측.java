import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isPrime = new boolean[1000001];

        for (int i = 0; i <= Math.sqrt(1000000); i++) {
            if (i < 2) {
                isPrime[i] = true;
            }
            if (isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            boolean isGoldbach = false;

            if (N == 0) {
                System.out.println(sb);
                return;
            }

            for (int i = 3; i <= N; i += 2) {
                if (!isPrime[i] && !isPrime[N - i]) {
                    sb.append(N + " = " + i + " + " + (N - i)).append("\n");
                    isGoldbach = true;
                    break;
                }
            }

            if (!isGoldbach) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

    }

}