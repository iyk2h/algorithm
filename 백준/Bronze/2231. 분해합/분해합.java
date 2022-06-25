import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int m = Integer.parseInt(bf.readLine());

        int n = 1;
        while (m>=n) {
            int sum = 0;
            int tmp = n;
            while (tmp>0) {
                sum += tmp%10;
                tmp = tmp/10;
            }

            if((sum + n) == m) {
                System.out.println(n);
                return;
            }
            n++;
        }
        System.out.println(0);
    }
}
