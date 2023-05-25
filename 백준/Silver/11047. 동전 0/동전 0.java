import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int val;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        val = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i] <= val) {
                val -= arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}