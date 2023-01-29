import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] arr = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.substring(i);
        }

        Arrays.sort(arr, (Comparator.naturalOrder()));

        for (String str : arr) {
            System.out.println(str);
        }
    }
}