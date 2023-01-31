import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        for (int i = m - 1; i >= 0; i--) {
            int input = Integer.parseInt(st.nextToken());
            tmp += input * Math.pow(A, i);
        }

        if (tmp == 0) {
            System.out.println("0");
            return;
        }

        List<Integer> list = new ArrayList<>();
        while (tmp != 0) {
            list.add(tmp % B);
            tmp /= B;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }

        System.out.println(sb);

    }
}
