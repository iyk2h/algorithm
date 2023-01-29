import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            left.add(String.valueOf(input.charAt(i)));
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();

            switch (commend) {
                case "P":
                    left.push(st.nextToken());
                    break;
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            bw.write(right.pop());
        }
        
        bw.flush();
        bw.close();
    }
}