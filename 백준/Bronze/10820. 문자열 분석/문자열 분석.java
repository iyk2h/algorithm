import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int N = Integer.parseInt(br.readLine());

        String buf = "";

        while ((buf = br.readLine()) != null) {
            int[] arr = new int[4];
            for (int i = 0; i < buf.length(); i++) {
                char c = buf.charAt(i);

                if (c <= 'z' && c >= 'a') {
                    arr[0]++;
                } else if (c <= 'Z' && c >= 'A') {
                    arr[1]++;
                } else if (c <= '9' && c >= '0') {
                    arr[2]++;
                } else if (c == ' ') {
                    arr[3]++;
                }
            }
            for (int i = 0; i < 4; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
