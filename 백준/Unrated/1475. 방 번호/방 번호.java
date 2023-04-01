import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        String str = br.readLine();

        for (char c : str.toCharArray()) {
            int i = (int)c-'0';
            if (i == 9) {
                i = 6;
            }
            arr[i]++;
        }

        arr[6] = (arr[6] + 1) / 2;

        int answer = -1;
        for (int i : arr) {
            if (answer < i) {
                answer = i;
            }
        }
        System.out.println(answer);
    }
}