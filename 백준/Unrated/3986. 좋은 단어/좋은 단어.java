import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();

            String[] str = br.readLine().split("");

            for (String s : str) {
                if (!stack.isEmpty()) {
                    if (stack.peek().equals(s)) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(s);
            }
            if (stack.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}