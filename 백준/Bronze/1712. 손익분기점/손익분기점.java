import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long count = 1;

        if (b >= c) {
            System.out.println("-1");
        } else {
            while (true) {
                if (a + (b * count) < (c * count)) {
                    System.out.println(count);
                    return;
                }
                count++;
            }
        }
    }
}
