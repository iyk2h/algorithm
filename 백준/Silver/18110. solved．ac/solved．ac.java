import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cut = (int) ((n * 0.15) + 0.5);
        int sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += arr[i];
        }

        System.out.println((int) (sum / (double) (n - cut * 2) + 0.5));
    }
}