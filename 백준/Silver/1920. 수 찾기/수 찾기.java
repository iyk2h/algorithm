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
            sb.append(binarySearch(board, Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int[] board, int target) {
        int st = 0;
        int en = board.length - 1;

        while (st <= en) {
            int mid = (st + en) / 2;
            if (board[mid] < target) {
                st = mid + 1;
            } else if (board[mid] > target) {
                en = mid - 1;

            } else {
                return 1;
            }
        }
        return 0;
    }
}