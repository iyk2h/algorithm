import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        int[] board = new int[N];
        List<Integer> two = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(board);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                two.add(board[i] + board[j]);
            }
        }

        Collections.sort(two);

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (Collections.binarySearch(two, board[i] - board[j]) > -1) {
                    System.out.println(board[i]);
                    return;
                }
            }
        }
    }
}