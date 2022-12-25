import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int input = Integer.parseInt(bf.readLine());

        for (int i = input; i > 0; i--) {
            printStar(i);
            System.out.println();
        }
    }

    public static void printStar(int input) {
        for (int i = 0; i < input; i++) {
            System.out.print("*");
        }
    }
}
