import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while (!(str = br.readLine()).equals(".")) {
            str = str.replaceAll("[^\\(\\)\\[\\]]", "");

            if (str.equals("")) {
                sb.append("yes").append("\n");
                continue;
            }

            Stack<String> stack = new Stack<>();
            String[] arr = str.split("");

            for (String s : arr) {
                if (!stack.isEmpty()) {
                    if (s.equals("]")) {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                            continue;
                        }
                    } else if (s.equals(")")) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            continue;
                        }
                    }
                }
                stack.push(s);
            }

            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);

    }
}