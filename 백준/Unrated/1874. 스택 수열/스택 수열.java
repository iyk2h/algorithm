import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] ar) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int val = 0;

        while (n-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input > val) {
                for (int i = val + 1; i <= input; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                val = input;
            } else if (stack.peek() != input) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }
}