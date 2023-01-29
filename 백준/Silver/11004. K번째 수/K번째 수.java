import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(arr);

        System.out.println(arr[K - 1]);
    }

    public static void sort(int[] a) {
        m_pivot_sort(a, 0, a.length - 1);
    }

    private static void m_pivot_sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(a, lo, hi);

        m_pivot_sort(a, lo, pivot);
        m_pivot_sort(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int left, int right) {

        int lo = left - 1;
        int hi = right + 1;
        int pivot = a[(left + right) / 2];

        while (true) {
            do {
                lo++;
            } while (a[lo] < pivot);

            do {
                hi--;
            } while (a[hi] > pivot && lo <= hi);

            if (lo >= hi) {
                return hi;
            }

            swap(a, lo, hi);
        }

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}