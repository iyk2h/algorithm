import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(bf.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        while (input > 0) {
            int a = Integer.parseInt(st.nextToken());
            boolean check = true;
            if(a == 1){
                check = false;
            }
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    check = false;
                }
            }
            if(check == true) {
                count++;
            }
            input--;
        }
        System.out.println(count);
    }
}
