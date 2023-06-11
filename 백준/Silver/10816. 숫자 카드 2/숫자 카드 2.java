import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] board = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();

        while (M-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upper_index(board, target)
                            - lower_index(board, target))
                    .append(" ");
        }

        System.out.println(sb);
    }

    private static int lower_index(int[] board, int target) {
        int st = 0;
        int en = board.length;

        while (st < en) {
            int mid = (st + en) / 2;
            if (board[mid] >= target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

    private static int upper_index(int[] board, int target) {
        int st = 0;
        int en = board.length;

        while (st < en) {
            int mid = (st + en) / 2;
            if (board[mid] > target) {
                en = mid;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }
}