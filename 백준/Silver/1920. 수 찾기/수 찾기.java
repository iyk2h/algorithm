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


        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (binarySearch(arr, key) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    public static int binarySearch(int arr[], int key) {
        int si = 0;
        int li = arr.length - 1;

        while (si <= li) {
            int mid = (si + li) / 2;

            if (key < arr[mid]) {
                li = mid - 1;
            } else if (key > arr[mid]) {
                si = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}