import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        int[] opPriority = new int[50];
        opPriority['*'] = opPriority['/'] = 1;
        opPriority['('] = opPriority[')'] = -1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            }
            if (c == '(') {
                stack.add(c);
                continue;
            }
            if (c == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            while (!stack.isEmpty() && opPriority[stack.peek()] >= opPriority[c]) {
                sb.append(stack.pop());
            }
            stack.add(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}