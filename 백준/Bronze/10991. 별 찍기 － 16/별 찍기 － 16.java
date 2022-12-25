

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int input = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= input; i++) {
            printStar(i, input);
            System.out.println();
        }
    }

    public static void printStar(int input, int len) {
        for (int i = 0; i < (len - input); i++) {
            System.out.printf("%s", " ");
        }
        for (int i = 0; i < input; i++) {
            System.out.printf("%s", "*");
            System.out.printf("%s", " ");
        }
    }
}
