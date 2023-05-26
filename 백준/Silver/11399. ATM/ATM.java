import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int val;

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        Integer[] a = new Integer[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sum += a[j];
            }
        }

        System.out.println(sum);
    }
}