import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        long result = 0;
        long pow = 1;
        int M = 1234567891;
        for (int i = 0; i < n; i++) {
            result += (input.charAt(i) - 'a' + 1) * pow % M;
            pow = pow * 31 % M;
        }
        System.out.println(result % M);
    }
}