
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int sum = 0;
        int last = 0;
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());

        for( int j = b ; j>=a; j--) {
            boolean check = true;
            if(j == 1){
                check = false;
            }
            else if (j > 2){
                for (int i = 2; i < j; i++) {
                    if (j % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if(check == true) {
                sum += j;
                last = j;

            }
        }
        if(sum == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sum);
            System.out.println(last);
        }
    }
}