import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        board = new long[n];

        int idx = 0;

        while (st.hasMoreTokens()) {
            StringBuffer sb = new StringBuffer(st.nextToken());
            board[idx++] = Long.parseLong(sb.reverse().toString());
        }

        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            while (st.hasMoreTokens()) {
                StringBuffer sb = new StringBuffer(st.nextToken());
                board[idx++] = Long.parseLong(sb.reverse().toString());
            }
        }

        Arrays.sort(board);

        StringBuffer sb = new StringBuffer();
        for (long tmp : board) {
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}