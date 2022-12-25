import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] b = (bf.readLine()).split(",");
            int result = Integer.parseInt(b[0])  + Integer.parseInt(b[1]);
            System.out.println(result);
        }
    }
}