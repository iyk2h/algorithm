import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(solve(input));
    }

    private static int solve(String input) {
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int j = 0; j < input.length(); j++) {
            char c = input.charAt(j);
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                stack.pop();
                if (input.charAt(j - 1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }
        return result;
    }

}
