import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long J = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < GCD(K, J); i++) {
            sb.append("1");
        }
            System.out.println(sb);
    }

    static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

}
