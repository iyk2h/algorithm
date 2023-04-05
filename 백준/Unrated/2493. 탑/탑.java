import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();

        for (int n = 1; n <= N; n++) {
            // 현재 탑의 높이
            int current = Integer.parseInt(st.nextToken());

            while (!stack.empty()) {
                // 이전 탑의 높이가 현재 높이보다 작으면 필요 없으므로 pop
                if (stack.peek()[1] < current) {
                    stack.pop();
                }
                // 이전 탑의 높이가 현재 높이보다 크면 여기에 수신하므로 이전 탑의 높이 출력
                else {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }

            // 스택이 비었다는 것은 수신할 탑이 없다는 뜻이므로 0 출력
            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            // 현재 탑(탑의 위치, 탑의 높이) push
            stack.push(new int[]{n, current});
        }
    }
}