import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[201];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken()) + 100;
            arr[idx]++;
        }

        int v = Integer.parseInt(br.readLine()) + 100;
        System.out.println(arr[v]);
    }
}