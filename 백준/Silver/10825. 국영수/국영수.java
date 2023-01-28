import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main( String[ ] args ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][4];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String Korean = st.nextToken();
            String English = st.nextToken();
            String Math = st.nextToken();

            arr[i][0] = name;
            arr[i][1] = Korean;
            arr[i][2] = English;
            arr[i][3] = Math;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1].equals(o2[1])) {
                if (o1[2].equals(o2[2])) {
                    if (o1[3].equals(o2[3])) {
                        return o1[0].compareTo(o2[0]);
                    }
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }
            return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        });

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append("\n");
        }

        System.out.println(sb);
    }
}