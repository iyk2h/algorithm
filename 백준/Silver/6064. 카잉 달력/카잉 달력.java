import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m, n, x, y = 0;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            System.out.println(solve(m, n, x, y));
        }
    }

    private static int solve(int m, int n, int x, int y) {
        if (x == m) {
            x = 0;
        }
        if (y == n) {
            y = 0;
        }
        int l = lcm(m, n);
        for (int i = x; i <= l; i += m) {
            if (i == 0) {
                continue;
            }
            if (i % n == y) {
                return i;
            }
        }
        return -1;
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}