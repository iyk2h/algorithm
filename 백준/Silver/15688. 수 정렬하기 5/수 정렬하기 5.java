import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] board;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        board = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(0, n);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(board[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void merge(int s, int e) {
        int mid = (s + e) / 2;
        int lidx = s;
        int ridx = mid;

        for (int i = s; i < e; i++) {
            if (ridx == e) {
                tmp[i] = board[lidx++];
            } else if (lidx == mid) {
                tmp[i] = board[ridx++];
            } else if (board[lidx] <= board[ridx]) {
                tmp[i] = board[lidx++];
            } else {
                tmp[i] = board[ridx++];
            }
        }
        for (int i = s; i < e; i++) {
            board[i] = tmp[i];
        }
    }

    private static void merge_sort(int s, int e) {
        if (e == s + 1) {
            return;
        }
        int mid = (s + e) / 2;
        merge_sort(s, mid);
        merge_sort(mid, e);
        merge(s, e);
    }
}