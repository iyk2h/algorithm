import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for( int j = a ; j<=b; j++) {
            boolean check = true;
            if(j == 1){
                check = false;
            }
            else if (j > 2){
                for (int i = 2; i <= Math.sqrt(j); i++) {
                    if (j % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if(check == true) {
                System.out.println(j);
            }
        }
    }
}