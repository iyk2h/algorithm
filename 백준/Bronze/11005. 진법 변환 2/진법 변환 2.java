import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        char[] arr = new char[36];
        int i = 0;

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (N > 0) {
            int tmp = N % B;

            if (tmp < 10) {
                arr[i] = ((char) (tmp + '0'));
            } else {
                arr[i] = ((char) (tmp - 10 + 'A'));
            }
            N /= B;
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            sb.append(arr[j]);
        }
        System.out.print(sb);
    }
}
