import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (binarySearch(arr, target) == -1) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int target) {
        int si = 0;
        int li = arr.length - 1;

        while (si <= li) {
            int mid = (si + li) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                si = mid + 1;
            } else {
                li = mid - 1;
            }
        }
        return -1;
    }
}