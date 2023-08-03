import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[21];

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            switch (input) {
                case "all":
                    for (int i = 1; i < 21; i++) {
                        check[i] = true;
                    }
                    break;
                case "empty":
                    for (int i = 1; i < 21; i++) {
                        check[i] = false;
                    }
                    break;
                case "add":
                    check[Integer.parseInt(st.nextToken())] = true;
                    break;
                case "remove":
                    check[Integer.parseInt(st.nextToken())] = false;
                    break;
                case "check":
                    if (check[Integer.parseInt(st.nextToken())]) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "toggle":
                    int val = Integer.parseInt(st.nextToken());
                    check[val] = !check[val];
                    break;
            }
        }
        System.out.println(sb);
    }
}