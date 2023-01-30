import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> ar = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            long sum = 0;

            int n = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()){
                ar.add(Integer.valueOf(st.nextToken()));
            }

            for (int j = 0; j < ar.size(); j++) {
                for (int k = j; k < ar.size(); k++) {
                    if (j != k) {
                        sum += GCD(ar.get(j), ar.get(k));
                    }
                }
            }
            System.out.println(sum);
        }

    }

    static long GCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return GCD(b, a % b);
        }
    }

}
