import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int start = 665;
        int end = 0;
        int count = 0;

        int input = Integer.parseInt(bf.readLine());

        while (true) {
            start++;
            String check = String.valueOf(start);

            for(int i = 0; i < check.length()-2 ; i++) {
                if(check.charAt(i) == '6' & check.charAt(i+1) == '6' & check.charAt(i+2) == '6') {;
                    count++;
                    if(count == input) {
                        System.out.println(start);
                        return;
                    }
                    break;
                }
            }
        }
    }
}
