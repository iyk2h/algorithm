import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Stack<Character> s = new Stack<>();
    static char ch[];
    static int ans, sum = 1;
 
    static void func() {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                sum *= 2;
                s.push(ch[i]);
            } else if (ch[i] == '[') {
                sum *= 3;
                s.push(ch[i]);
            } else if (ch[i] == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    System.out.println(0);
                    return;
                }
 
                if (s.peek() == '(') {
                    if (ch[i - 1] == '(')
                        ans += sum;
                    sum /= 2;
                    s.pop();
                }
            } else {
                if (s.isEmpty() || s.peek() != '[') {
                    System.out.println(0);
                    return;
                }
 
                if (s.peek() == '[') {
                    if (ch[i - 1] == '[')
                        ans += sum;
                    sum /= 3;
                    s.pop();
                }
            }
        }
 
        if (!s.isEmpty())
            System.out.println(0);
        else
            System.out.println(ans);
    }
 
    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        ch = st.nextToken().toCharArray();
    }
 
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
}