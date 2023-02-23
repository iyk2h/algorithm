

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int si = 1;
        int li = arr[K - 1] - arr[0] + 1;

        while (si < li) {
            int mid = (li + si) / 2;

            // 잘린 개수가 적으면 자르는 사이즈를 줄임
            if (countInstall(arr, mid) < N) {
                li = mid;
            } else {
                si = mid + 1;
            }

        }

        System.out.println(si - 1);
    }

    private static int countInstall(int[] arr, long mid) {
        int count = 1;
        int lastLocate = arr[0];

        for (int locate : arr) {
            if (locate - lastLocate >= mid) {
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }
}