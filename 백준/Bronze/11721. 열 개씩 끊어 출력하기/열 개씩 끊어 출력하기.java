import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input = bf.readLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
