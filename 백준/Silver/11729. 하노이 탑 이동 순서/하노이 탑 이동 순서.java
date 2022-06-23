import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(bf.readLine());


        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }
    public static void hanoi(int n, int start, int pass, int to) {
        count++;
        if(n == 1) {
            sb.append(start+" "+to+"\n");
            return;
        }
        hanoi(n-1, start, to, pass);
        sb.append(start+" "+to+"\n");
        hanoi(n-1, pass, start, to);
    }
}