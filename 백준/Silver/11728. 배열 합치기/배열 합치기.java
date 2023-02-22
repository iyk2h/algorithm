import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(al);

        StringBuilder sb = new StringBuilder();

        for (int o : al) {
            sb.append(o).append(" ");
        }

        System.out.println(sb);
    }
}