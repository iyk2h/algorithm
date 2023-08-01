import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            int n = s.length();
            boolean b = true;
            if (s.equals("0")) break;
            for (int i = 0; i <= n/2; i++) {
                if (s.charAt(i) != s.charAt(n-i-1)) b = false;
            }
            if (b) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
}