import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        StringTokenizer st;

        for(int i = 0 ; i < input; i++) {
            st = new StringTokenizer(bf.readLine());
            int f = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            int c = 0;
            while (c < b.length()) {
                int a = f;
                while (a > 0) {
                    System.out.print(b.charAt(c));
                    a--;
                }
                c++;
            }
            System.out.println();
        }
    }
}