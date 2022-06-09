import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        int s = 1;
        int n = 1;
        while(n < 166667) {
            if ( 1 == input) {
                System.out.println(s);
                return;
            }
            else if ( s < input & input <= s+(6*(n-1))) {
                System.out.println(n);
                return;
            }
            s = s+(6*(n-1));
            n++;
        }
    }
}
