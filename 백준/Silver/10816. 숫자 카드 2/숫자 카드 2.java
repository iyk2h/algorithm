import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");
        }

        System.out.println(sb);

    }

    public static int lowerBound(int[] arr, int key) {
        int si = 0;
        int li = arr.length;

        while (si < li) {
            int mid = (li + si) / 2;

            if (key <= arr[mid]) {
                li = mid;
            } else {
                si = mid + 1;
            }
        }
        return si;
    }

    public static int upperBound(int[] arr, int key) {
        int si = 0;
        int li = arr.length;

        while (si < li) {
            int mid = (li + si) / 2;

            if (key < arr[mid]) {
                li = mid;
            } else {
                si = mid + 1;
            }
        }
        return si;
    }
}