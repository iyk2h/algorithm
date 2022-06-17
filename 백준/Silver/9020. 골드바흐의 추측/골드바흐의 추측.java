import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bf.readLine());
        while (a>0) {
            int b = Integer.parseInt(bf.readLine());
            List<Integer> ls = new ArrayList<>();
            int f = 0;
            int l = 0;

            for (int j = 1; j <= b; j++) {
                boolean check = true;
                if (j == 1) {
                    check = false;
                } else if (j > 2) {
                    for (int i = 2; i <= Math.sqrt(j); i++) {
                        if (j % i == 0) {
                            check = false;
                            break;
                        }
                    }
                }
                if (check == true) {
                    int idx = 0;
                    ls.add(idx, j);
                    idx++;
                }
            }
            Collections.sort(ls);

            int min = 10000;
            int la = 0;
            for(int c : ls) {
                int tmp = b-c;
                if ( ls.contains(tmp) ) {
                    int n = tmp - c;
                    if (min > n & n >=0) {
                        la = c;
                        min = n;
                    }
                }
            }
            System.out.println(la+" "+(b-la));
            a--;
        }
    }
}