import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            arr[index] ++;
        }

        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
