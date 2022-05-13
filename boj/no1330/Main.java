package boj.no1330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        while( (str = bf.readLine()) != null) {
            st = new StringTokenizer(str);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A>B) {
                System.out.println(">");
            }
            else if (A<B) {
                System.out.println("<");
            }
            else {
                System.out.println("==");
            }
        }

    }
}