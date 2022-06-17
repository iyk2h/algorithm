import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str ;
        while (( str = bf.readLine()) != null) {
            int a = Integer.parseInt(str);
            if(a==0){
                return;
            }
            int b = 2*a;
            int count = 0;
            for (int j = a+1; j <= b; j++) {
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
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}