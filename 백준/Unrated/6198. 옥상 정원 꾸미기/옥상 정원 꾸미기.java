import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            // 이전에 있는 빌딩 중 새로운 빌딩의 높이보다 낮으면 모두 제거
            while (!stack.isEmpty() && stack.peek() <= tmp) {
                stack.pop();
            }
            // 빈 stack or 새로운 빌딩보다 큰 빌딩만 남음.
            // 즉, 새로운 빌딩을 볼 수 있는 빌딩들만 남음
            stack.push(tmp);
            result += stack.size() - 1;
        }
        System.out.println(result);
    }
}