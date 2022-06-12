import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        while (input > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            for (int j = 1; j <= w; j++) {
                for (int i = 1; i <= h; i++) {
                    n--;
                    if(n == 0) {
                        System.out.printf("%d%02d\n",i,j);
                    }
                }
            }
            input--;
        }

    }
}
