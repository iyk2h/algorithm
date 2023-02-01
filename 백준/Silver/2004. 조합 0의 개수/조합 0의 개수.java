import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long countFive = five_pow(N) - five_pow(N - M) - five_pow(M);
        long countTwo = two_pow(N) - two_pow(N - M) - two_pow(M);
        System.out.println(Math.min(countFive, countTwo));

    }

    static long five_pow(long num) {
        int count = 0;

        while (num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    static long two_pow(long num) {
        int count = 0;

        while (num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }

}