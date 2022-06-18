import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int f = Integer.parseInt(bf.readLine());

        int answer = pivo(0,1, f);
        System.out.println(answer);
    }

    public static int pivo (int n, int m, int i) {
        if (i == 1) {
            return m;
        }
        if (i == 0) {
            return 0;
        }

        return pivo(m, n+m , i-1);
    }
}