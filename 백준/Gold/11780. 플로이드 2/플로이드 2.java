import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[][] board, next;
    static int n;
    static int INF = Integer.MAX_VALUE / 2;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        board = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                next[i][j] = -1;
                board[i][j] = INF;
                if (i == j) {
                    board[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[s][e] = Math.min(board[s][e], v);
            next[s][e] = s;

        }

        floyd();

        print();
    }

    private static void floyd() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (board[i][j] > board[i][k] + board[k][j]) {
                        board[i][j] = board[i][k] + board[k][j];
                        next[i][j] = next[k][j];
                    }
                }
            }
        }
    }

    private static void print() {
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (board[i][j] >= INF) {
                    sb.append(0);
                } else {
                    sb.append(board[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (next[i][j] == -1) {
                    sb.append(0);
                } else {
                    Stack<Integer> path = new Stack<>();
                    int pre = j;
                    path.push(j);

                    while (i != next[i][pre]) {
                        pre = next[i][pre];
                        path.push(pre);
                    }

                    sb.append(path.size() + 1).append(" ");

                    sb.append(i).append(" ");
                    while (!path.isEmpty()) {
                        sb.append(path.pop()).append(" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}