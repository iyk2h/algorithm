import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int b = Integer.parseInt(bf.readLine());
        while (b>1) {
            for (int i = 2; i <= b ; i ++) {
                if(b%i==0){
                    System.out.println(i);
                    b = b/i;
                    break;
                }
            }
        }
    }
}